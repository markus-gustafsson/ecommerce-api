package com.example.ecommerceapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private JPAProductRepository jpaProductRepository;

    @Autowired
    public ProductRepository(JPAProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    public List<Product> findAll() {
        return (List<Product>) jpaProductRepository.findAll();
    }
}
