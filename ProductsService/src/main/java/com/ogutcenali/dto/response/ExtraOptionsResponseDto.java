package com.ogutcenali.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExtraOptionsResponseDto {
    private String label;
    private double price;
}
