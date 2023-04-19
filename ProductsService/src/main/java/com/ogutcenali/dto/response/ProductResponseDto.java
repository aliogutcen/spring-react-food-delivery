package com.ogutcenali.dto.response;


import com.ogutcenali.repository.entity.Category;
import com.ogutcenali.repository.entity.SizeOption;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponseDto {

    private String id;

    private String name;
    private double price;
    private List<String> ingreditions;
    List<SizeOption> sizeOptions;

    Category category;

}
