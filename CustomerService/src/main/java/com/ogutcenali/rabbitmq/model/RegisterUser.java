package com.ogutcenali.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUser implements Serializable {

    private String mail;

    private String username;

    private String password;

    private Long userId;
}
