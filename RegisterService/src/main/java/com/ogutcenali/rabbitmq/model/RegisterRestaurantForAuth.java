package com.ogutcenali.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRestaurantForAuth implements Serializable {

    private String mail;

    private String password;
}
