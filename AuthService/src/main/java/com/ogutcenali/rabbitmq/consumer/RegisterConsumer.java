package com.ogutcenali.rabbitmq.consumer;

import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.rabbitmq.model.RegisterUserForAuth;
import com.ogutcenali.service.RestaurantAuthService;
import com.ogutcenali.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterConsumer {

    private final UserAuthService userAuthService;
    private final RestaurantAuthService restaurantAuthService;

    @RabbitListener(queues ="queque-register-user" )
    public void registerUserforAuth(RegisterUserForAuth registerUserForAuth){
        userAuthService.registerUser(registerUserForAuth);
    }

    @RabbitListener(queues ="queque-register-restaurant" )
    public void registerRestaurantforAuth(RegisterRestaurant registerRestaurantForAuth){
        restaurantAuthService.registerRestaurant(registerRestaurantForAuth);
    }
}
