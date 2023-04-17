package com.ogutcenali.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRestaurant implements Serializable {
    private Integer productsNumber;
    private String country;
    private String restaurantName;

    private String city;
    private String district;

    private String neighbourhood;
    private String managerName;

    private String managerSurname;

    private String mail;

    private String phone;
    private String tcNo;

    private String password;

    private Long authid;
}
