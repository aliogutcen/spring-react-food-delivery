package com.ogutcenali.repository.entity;

import com.ogutcenali.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class AcceptRegisterRestaurant extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private Long restaurantId;
    private String message;
    @Column(columnDefinition = "DATE")
    private LocalDate applicationDate;


    @Enumerated(EnumType.STRING)
    EStatus eStatus;
}
