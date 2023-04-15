package com.ogutcenali.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportRegisterRestaurant implements Serializable {

    String mail;
}
