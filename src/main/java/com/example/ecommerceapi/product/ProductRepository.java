package com.example.ecommerceapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Product findById(Long id) throws NoSuchElementException {
        return jpaProductRepository.findById(id).orElseThrow();
    }

    public Product save(Product product) {
        return jpaProductRepository.save(product);
    }
}
