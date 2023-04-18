package com.ogutcenali.service;

import com.ogutcenali.dto.request.UpdateRestaurantInformationRequestDto;
import com.ogutcenali.dto.response.GetAllInfoForRestaurant;
import com.ogutcenali.mapper.IRestaurantMapper;
import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.repository.IRestaurantRepository;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.utility.JwtTokenManager;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class RestaurantService extends ServiceManager<Restaurant, String> {

    private final IRestaurantRepository restaurantRepository;
    private final JwtTokenManager jwtTokenManager;

    public RestaurantService(IRestaurantRepository restaurantRepository, JwtTokenManager jwtTokenManager) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public void registerRestaurant(RegisterRestaurant registerRestaurantForAuth) {
        Restaurant restaurant = IRestaurantMapper.INSTANCE.toRestaurant(registerRestaurantForAuth);
        save(restaurant);
    }

    public GetAllInfoForRestaurant updateInformation(UpdateRestaurantInformationRequestDto informationRequestDto) {

        Optional<Long> authid = jwtTokenManager.decodeToken(informationRequestDto.getToken());
        System.out.println(authid.get());
        Optional<Restaurant> restaurant = restaurantRepository.findOptionalByAuthid(authid.get());
        System.out.println(restaurant.get());

        restaurant.get().setDistrict(informationRequestDto.getDistrict());
        restaurant.get().setNeighbourhood(informationRequestDto.getNeighbourhood());
        restaurant.get().setOpenDays(informationRequestDto.getOpenDays());
        restaurant.get().setCloseTime(informationRequestDto.getCloseTime());
        restaurant.get().setCloseTime(informationRequestDto.getCloseTime());
        /**
         * AÇILIŞ VE KAPANIŞ SAATLERİNİ AYARLAMA!
         */
        Restaurant restaurant1 = update(restaurant.get());
        return IRestaurantMapper.INSTANCE.GET_ALL_INFO_FOR_RESTAURANT(restaurant1);

    }





    /**
     * bilgileri getirme fonksiyonu
     */
    public GetAllInfoForRestaurant getAllInfoForRestaurantResponseEntity(String token) {
        Optional<Long> authid = jwtTokenManager.decodeToken(token);
        System.out.println(authid.get());
        Optional<Restaurant> restaurant = restaurantRepository.findOptionalByAuthid(authid.get());
        return IRestaurantMapper.INSTANCE.GET_ALL_INFO_FOR_RESTAURANT(restaurant.get());
    }
}
