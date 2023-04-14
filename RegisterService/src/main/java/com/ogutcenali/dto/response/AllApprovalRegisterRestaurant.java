package com.ogutcenali.dto.response;

import com.ogutcenali.repository.enums.EStatus;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllApprovalRegisterRestaurant {
    private Long restaurantId;
    private String message;

    @Enumerated(EnumType.STRING)
    EStatus eStatus;
}
