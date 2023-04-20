package com.ogutcenali.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {


    private String city;

    private String district;

    private String neighbourhood;

    private Integer doorNo;

    private String openAddress;


}
