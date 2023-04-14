package com.ogutcenali.repository.entity;

import com.ogutcenali.repository.enums.ERole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class RestaurantAuth extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;

    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    ERole role = ERole.RESTAURANT;
}
