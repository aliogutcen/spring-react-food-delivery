package com.ogutcenali.repository.entity;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.HashMap;
import java.util.Map;

@RedisHash("Food_Basket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Basket {

    @Id
    private String id;

    private Long authId;

    private Map<String, Integer> products;


}
