package com.ogutcenali.dto.request;

import com.ogutcenali.dto.response.ExtraOptionsResponseDto;
import com.ogutcenali.dto.response.SizeOptionResponseDto;
import com.ogutcenali.repository.entity.ExtraOptions;
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

    List<ExtraOptions> extraOptions;

    List<String> ingreditions;
}
