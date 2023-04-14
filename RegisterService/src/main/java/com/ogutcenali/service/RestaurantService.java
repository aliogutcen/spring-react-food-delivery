package com.ogutcenali.service;

import com.ogutcenali.dto.request.RegisterRestaurantRequestDto;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.exception.RegisterException;
import com.ogutcenali.mapper.IRestaurantMapper;
import com.ogutcenali.rabbitmq.model.RegisterRestaurantForAuth;
import com.ogutcenali.rabbitmq.producer.RegisterProducer;
import com.ogutcenali.repository.IRestaurantRepository;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {

    private final IRestaurantRepository restaurantRepository;
    private final AcceptRegisterRestaurantService acceptRegisterRestaurantService;
    private final RegisterProducer registerProducer;

    public RestaurantService(IRestaurantRepository restaurantRepository, AcceptRegisterRestaurantService acceptRegisterRestaurantService, RegisterProducer registerProducer) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;

        this.acceptRegisterRestaurantService = acceptRegisterRestaurantService;
        this.registerProducer = registerProducer;
    }

    public Boolean register(RegisterRestaurantRequestDto restaurantRequestDto) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findOptionalByMail(restaurantRequestDto.getMail());
        if (restaurantOptional.isPresent()) throw new RegisterException(ErrorType.RESTAURANT_ALREADY_EXISTS);
        Restaurant restaurant = save(IRestaurantMapper.INSTANCE.toRestaurant(restaurantRequestDto));

        /**
         *KAYIT SONRASI ONAY İŞLEMİNE GİDER
         * */
        acceptRegisterRestaurantService.approvalProcess(restaurant.getId());
        return true;
    }


    public Boolean enoughForApproval(Long restaurantId) {
        Optional<Restaurant> restaurant = findById(restaurantId);
        if (restaurant.get().getProductsNumber() > 20) return true;
        return false;
    }

    public void registerRestaurantForAuth(Long restaurantId) {
        Optional<Restaurant> restaurant = findById(restaurantId);
        registerProducer.registerRestaurantForAuth(RegisterRestaurantForAuth.builder()
                .mail(restaurant.get().getMail())
                .password(restaurant.get().getPassword())
                .build());
    }
}
