package com.template.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "model_json")
public class ModelJson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jsonIn;
    private String jsonOut;
}
