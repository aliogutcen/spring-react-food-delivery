package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeleteAddressRequestDto {
    private String token;
    private String city;

    private String district;

    private String neighbourhood;

    private Integer doorNo;

    private String openAddress;
}
