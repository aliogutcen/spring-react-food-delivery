package com.ogutcenali.repository.entity;

import com.ogutcenali.repository.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "restaurant")
public class Restaurant extends BaseEntity {

    @Id
    private String id;

    private Integer productsNumber;
    private String country;
    private String restaurantName;

    private String city;
    private String district;

    private String neighbourhood;
    private String managerName;

    private String managerSurname;

    List<WeekDays> openDays;

    private LocalTime openTime;

    private LocalTime closeTime;
}
