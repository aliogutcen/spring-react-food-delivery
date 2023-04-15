package com.ogutcenali.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchange = "direct-exchange-register-auth";

    private String quequeRegisterFromSupport = "queuqe-register-from-support";

    private String keyRegisterFromSupport = "key-register-support";


    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue quequeRegisterFromSupport() {
        return new Queue(quequeRegisterFromSupport);
    }

    @Bean
    Binding registerRestaurantFromSupport(DirectExchange directExchange, Queue quequeRegisterFromSupport) {
        return BindingBuilder.bind(quequeRegisterFromSupport).to(directExchange).with(keyRegisterFromSupport);
    }

}
