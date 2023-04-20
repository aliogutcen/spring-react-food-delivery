package com.ogutcenali.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchange = "direct-exchange-register-auth";

    private String fanoutExchange = "fanout-exchange-register-restaurant";

    private String fanoutExchangeCustomer = "fanout-exchange-register-customer";

    private String quequeRegisterRestaurantMicroSrvice = "quequ-register-micro-service";
    private String quequeRegisterUser = "queque-register-user";

    private String registerCustomer = "queque-register-customer";
    private String quequeRegisterFromSupport = "queuqe-register-from-support";

    private String keyRegisterFromSupport = "key-register-support";

    private String quequeRegisterRestaurant = "queque-register-restaurant";


    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    FanoutExchange fanoutExchangeCustomer() {
        return new FanoutExchange(fanoutExchangeCustomer);
    }


    /**
     * START
     * AUTH-MICROSERVICES REGISTER USER AND CUSTOMER MICROSERVICE REGISTER USER
     */


    @Bean
    Queue quequeRegisterUser() {
        return new Queue(quequeRegisterUser);
    }

    @Bean
    Binding registerAuthUser(FanoutExchange fanoutExchangeCustomer, Queue quequeRegisterUser) {
        return BindingBuilder.bind(quequeRegisterUser).to(fanoutExchangeCustomer);
    }

    @Bean
    Queue registerCustomer() {
        return new Queue(registerCustomer);
    }

    @Bean
    Binding registerCustomer(FanoutExchange fanoutExchangeCustomer, Queue registerCustomer) {
        return BindingBuilder.bind(registerCustomer).to(fanoutExchangeCustomer);
    }

    /**
     * FINISH
     * AUTH-MICROSERVICES REGISTER USER AND CUSTOMER MICROSERVICE REGISTER USER
     */


    @Bean
    Queue quequeRegisterFromSupport() {
        return new Queue(quequeRegisterFromSupport);
    }

    @Bean
    Binding registerRestaurantFromSupport(DirectExchange directExchange, Queue quequeRegisterFromSupport) {
        return BindingBuilder.bind(quequeRegisterFromSupport).to(directExchange).with(keyRegisterFromSupport);
    }


    @Bean
    Queue quequeRegisterRestaurant() {
        return new Queue(quequeRegisterRestaurant);
    }

    @Bean
    Queue quequeRegisterRestaurantMicroSrvice() {
        return new Queue(quequeRegisterRestaurantMicroSrvice);
    }

    @Bean
    Binding reegisterRestaurant(FanoutExchange fanoutExchange, Queue quequeRegisterRestaurant) {
        return BindingBuilder.bind(quequeRegisterRestaurant).to(fanoutExchange);
    }

    @Bean
    Binding registerRestaurantFromRegister(FanoutExchange fanoutExchange, Queue quequeRegisterRestaurantMicroSrvice) {
        return BindingBuilder.bind(quequeRegisterRestaurantMicroSrvice).to(fanoutExchange);
    }


}
