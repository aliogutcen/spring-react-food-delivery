package com.ogutcenali.dto.request;

import com.ogutcenali.repository.enums.WeekDays;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateRestaurantInformationRequestDto {

    private String token;
    private String district;

    private String neighbourhood;

    List<WeekDays> openDays;

    private LocalTime openTime;

    private LocalTime closeTime;

}
