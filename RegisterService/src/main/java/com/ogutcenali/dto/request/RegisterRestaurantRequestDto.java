package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRestaurantRequestDto {
   private String country;
    private String restaurantName;
    private Integer productsNumber;
    private String city;
    private String district;

    private String neighbourhood;
    private String managerName;

    private String managerSurname;

    private String mail;

    private String phone;
    private String tcNo;

}