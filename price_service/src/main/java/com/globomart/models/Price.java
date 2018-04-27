package com.globomart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "price")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "category")
    private Double price;

    @Column(name = "currency")
    private String currency;
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
