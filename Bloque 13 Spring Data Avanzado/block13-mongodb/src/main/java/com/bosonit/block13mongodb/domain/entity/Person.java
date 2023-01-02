package com.bosonit.block13mongodb.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
}
