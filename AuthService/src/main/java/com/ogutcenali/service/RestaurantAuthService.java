package com.ogutcenali.service;

import com.ogutcenali.rabbitmq.model.RegisterRestaurantForAuth;
import com.ogutcenali.repository.IRestaurantAuthRepository;
import com.ogutcenali.repository.entity.RestaurantAuth;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RestaurantAuthService extends ServiceManager<RestaurantAuth, Long> {
    private final IRestaurantAuthRepository restaurantAuthRepository;

    public RestaurantAuthService(IRestaurantAuthRepository restaurantAuthRepository) {
        super(restaurantAuthRepository);
        this.restaurantAuthRepository = restaurantAuthRepository;
    }

    public void registerRestaurant(RegisterRestaurantForAuth registerRestaurantForAuth) {
        RestaurantAuth restaurantAuth = RestaurantAuth.builder()
                .mail(registerRestaurantForAuth.getMail())
                .password(registerRestaurantForAuth.getPassword()).build();
        save(restaurantAuth);
    }
}
