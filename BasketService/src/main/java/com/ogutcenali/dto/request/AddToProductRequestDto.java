package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddToProductRequestDto {

    String token;

    String productId;

    Integer quantity;
}
