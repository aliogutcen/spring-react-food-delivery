package com.ogutcenali.dto.response;

import com.ogutcenali.repository.enums.ESupportType;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportRegistrationConfirmationResponse {
    String mail;
    LocalDate localDate;
    ESupportType eSupportType;
}
