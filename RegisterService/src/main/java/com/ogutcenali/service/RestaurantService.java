package com.ogutcenali.service;

import com.ogutcenali.dto.request.RegisterRestaurantRequestDto;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.exception.RegisterException;
import com.ogutcenali.mapper.IRestaurantMapper;
import com.ogutcenali.repository.IRestaurantRepository;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {

    private final IRestaurantRepository restaurantRepository;


    public RestaurantService(IRestaurantRepository restaurantRepository) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;

    }

    public Boolean register(RegisterRestaurantRequestDto restaurantRequestDto) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findOptionalByMail(restaurantRequestDto.getMail());
        if (restaurantOptional.isPresent()) throw new RegisterException(ErrorType.RESTAURANT_ALREADY_EXISTS);
        save(IRestaurantMapper.INSTANCE.toRestaurant(restaurantRequestDto));

        return true;
    }


}
