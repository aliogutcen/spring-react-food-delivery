package com.ogutcenali.service;

import com.ogutcenali.mapper.IRestaurantMapper;
import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.repository.IRestaurantRepository;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service

public class RestaurantService extends ServiceManager<Restaurant, String> {

    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
    }

    public void registerRestaurant(RegisterRestaurant registerRestaurantForAuth) {
        Restaurant restaurant = IRestaurantMapper.INSTANCE.toRestaurant(registerRestaurantForAuth);
        save(restaurant);
    }
}
