package com.example.api;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Foo {

    @Id
    @GeneratedValue
    private Long id;

    private String Bar;

}
