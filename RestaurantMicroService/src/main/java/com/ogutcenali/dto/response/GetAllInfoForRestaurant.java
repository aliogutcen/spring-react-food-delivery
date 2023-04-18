package com.ogutcenali.dto.response;

import com.ogutcenali.repository.enums.WeekDays;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetAllInfoForRestaurant {


    private String id;
    private Integer productsNumber;
    private String country;
    private String restaurantName;

    private String city;
    private String district;

    private String neighbourhood;
    private String managerName;

    private String managerSurname;

    List<WeekDays> openDays;

    private String openTime;

    private String closeTime;
}
