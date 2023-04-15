package com.ogutcenali.dto.request;

import com.ogutcenali.repository.enums.ESupportType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SendSupportRequestDto {
    ESupportType eSupportType;

    String title;

    String mail;

    String subject;

    @DateTimeFormat
    LocalDate localDate;
}
