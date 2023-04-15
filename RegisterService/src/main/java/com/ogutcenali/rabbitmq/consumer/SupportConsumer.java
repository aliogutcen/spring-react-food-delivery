package com.ogutcenali.rabbitmq.consumer;

import com.ogutcenali.rabbitmq.model.SupportRegisterRestaurant;
import com.ogutcenali.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportConsumer {

    private final RestaurantService restaurantService;


    @RabbitListener(queues = "queuqe-register-from-support")
    public void acceptRestaurant(SupportRegisterRestaurant supportRegisterRestaurant) {
        restaurantService.acceptRestaurant(supportRegisterRestaurant);
    }

}
