package com.ogutcenali.dto.request;

import com.ogutcenali.repository.entity.SizeOption;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddNewProductRequestDto {

    String token;
    String name;

    double price;

    List<SizeOption> sizeOption;

    String categoryName;


}
