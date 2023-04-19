package com.ogutcenali.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddNewCategory {

    String categoryName;

    String desc;

    Boolean isVegan;
}
