package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUserRequestDto {

    private String mail;

    private String username;

    private String password;
    private String phone;
}
