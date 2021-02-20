package com.practice.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.productservice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}