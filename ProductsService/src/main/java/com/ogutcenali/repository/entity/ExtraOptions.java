package com.ogutcenali.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "extra_options")
public class ExtraOptions extends BaseEntity {
    @Id
    private String id;

    private Long restaurantId;
    private String label;
    private double price;


}
