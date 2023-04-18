package com.ogutcenali.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "size_option")
public class SizeOption extends BaseEntity {

    @Id
    String id;
    Long restaurantId;
    String label;
    double price;


}