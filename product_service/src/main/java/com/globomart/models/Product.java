package com.globomart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;
/*
    @Column
    @CreationTimestamp
    @JsonIgnore
    private Date created;

    @Column
    @UpdateTimestamp
    @JsonIgnore
    private Date updated;*/
}
