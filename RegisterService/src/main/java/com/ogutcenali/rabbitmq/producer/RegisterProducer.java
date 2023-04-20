package com.ogutcenali.rabbitmq.producer;

import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.rabbitmq.model.RegisterUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProducer {

    private final RabbitTemplate rabbitTemplate;

    public void registerUserForAuth(RegisterUser registerUser){
        rabbitTemplate.convertAndSend("fanout-exchange-register-customer","", registerUser);
    }
    public void registerRestaurantForAuth(RegisterRestaurant registerRestaurantForAuth){
        rabbitTemplate.convertAndSend("fanout-exchange-register-restaurant","",registerRestaurantForAuth);
    }
}
