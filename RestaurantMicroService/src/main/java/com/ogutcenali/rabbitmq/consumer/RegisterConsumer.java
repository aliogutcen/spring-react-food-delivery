package com.ogutcenali.rabbitmq.consumer;

import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterConsumer {

    private final RestaurantService restaurantService;

    @RabbitListener(queues = "quequ-register-micro-service")
    public void registerRestaurantforAuth(RegisterRestaurant registerRestaurantForAuth) {
        restaurantService.registerRestaurant(registerRestaurantForAuth);
    }
}
