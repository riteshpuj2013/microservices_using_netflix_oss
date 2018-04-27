package com.globomart.repositories;

import com.globomart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {
}
