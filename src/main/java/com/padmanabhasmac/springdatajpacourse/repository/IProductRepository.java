package com.padmanabhasmac.springdatajpacourse.repository;

import com.padmanabhasmac.springdatajpacourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
