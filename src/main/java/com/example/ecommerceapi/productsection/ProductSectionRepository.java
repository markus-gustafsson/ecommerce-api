package com.example.ecommerceapi.productsection;

import com.example.ecommerceapi.productsection.dto.ProductSectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductSectionRepository {
    private final JPAProductSectionRepository jpaProductSectionRepository;

    @Autowired
    public ProductSectionRepository(JPAProductSectionRepository jpaProductSectionRepository) {
        this.jpaProductSectionRepository = jpaProductSectionRepository;
    }

    public List<ProductSection> findAll() {
        return (List<ProductSection>) jpaProductSectionRepository.findAll();
    }

    public ProductSection findById(Long id) throws NoSuchElementException {
        return jpaProductSectionRepository.findById(id).orElseThrow();
    }
}
