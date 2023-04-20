package com.ogutcenali.rabbitmq.consumer;

import com.ogutcenali.rabbitmq.model.RegisterUser;
import com.ogutcenali.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterConsumer {

    private final CustomerService customerService;

    @RabbitListener(queues = "queque-register-customer")
    public void saveCustomerFromRegister(RegisterUser registerUser){
        customerService.saveCustomerFromRegister(registerUser);
    }
}
