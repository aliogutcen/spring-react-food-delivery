package com.ogutcenali.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SizeOptionResponseDto {
   private String label;
   private double price;
}
