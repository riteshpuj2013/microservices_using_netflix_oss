package com.globomart.repositories;

import com.globomart.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long>, JpaRepository<Price, Long> {
}
