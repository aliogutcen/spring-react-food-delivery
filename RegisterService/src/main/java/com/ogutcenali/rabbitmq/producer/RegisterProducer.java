package com.ogutcenali.rabbitmq.producer;

import com.ogutcenali.rabbitmq.model.RegisterRestaurantForAuth;
import com.ogutcenali.rabbitmq.model.RegisterUserForAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProducer {

    private final RabbitTemplate rabbitTemplate;

    public void registerUserForAuth(RegisterUserForAuth registerUserForAuth){
        rabbitTemplate.convertAndSend("direct-exchange-register-auth","keyRegisterUser",registerUserForAuth);
    }


    public void registerRestaurantForAuth(RegisterRestaurantForAuth registerRestaurantForAuth){
        rabbitTemplate.convertAndSend("direct-exchange-register-auth","keyRegisterRestaurant",registerRestaurantForAuth);
    }
}
