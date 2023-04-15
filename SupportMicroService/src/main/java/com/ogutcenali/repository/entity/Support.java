package com.ogutcenali.repository.entity;

import com.ogutcenali.repository.enums.ESupportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "supports")
public class Support extends BaseEntity {

    @Id
    String id;
    ESupportType eSupportType;

    String title;

    String mail;

    String subject;

    @DateTimeFormat
    LocalDate localDate;

    Boolean isClose;


}
