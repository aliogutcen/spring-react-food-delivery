package com.ogutcenali.rabbitmq.producer;

import com.ogutcenali.rabbitmq.model.SupportRegisterRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportProducer {

    private final RabbitTemplate rabbitTemplate;


    public void sendSupportAcceptRegisterForRestaurant(SupportRegisterRestaurant supportRegisterRestaurant){
        rabbitTemplate.convertAndSend("direct-exchange-register-auth","key-register-support",supportRegisterRestaurant);
    }
}
