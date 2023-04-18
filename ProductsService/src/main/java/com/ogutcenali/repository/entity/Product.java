package com.ogutcenali.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "products")
public class Product extends BaseEntity {

    @Id
    private String id;
    private Long restaurantId;
    private String name;
    private double price;
    private List<String> ingreditions;
    List<SizeOption> sizeOptions;
    List<ExtraOptions> extraOptions;


}
