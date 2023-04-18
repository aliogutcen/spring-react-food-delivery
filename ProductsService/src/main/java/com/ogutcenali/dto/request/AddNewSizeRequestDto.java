package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddNewSizeRequestDto {

     String token;
     String label;
     double price;
}
