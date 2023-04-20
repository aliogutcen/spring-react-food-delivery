package com.ogutcenali.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryResponse {
    private String categoryName;

    private String desc;

    private Boolean isVegan;

}
