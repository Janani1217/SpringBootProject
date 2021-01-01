package com.janani.spring.data.repos;

import org.springframework.data.repository.CrudRepository;

import com.janani.spring.data.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
