package com.ogutcenali.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUserForAuth implements Serializable {

    private String mail;

    private String username;

    private String password;


}
