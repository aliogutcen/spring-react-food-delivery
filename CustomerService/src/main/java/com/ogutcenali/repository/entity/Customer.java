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
@Document(value = "customers")
public class Customer  extends BaseEntity{

    @Id
    private String id;

    private Long authId;

    private String mail;

    private String username;

    private List<Address> addressList;
}
