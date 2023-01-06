package com.example.ecommerceapi.product;

import org.springframework.data.repository.CrudRepository;

public interface JPAProductRepository extends CrudRepository<Product, Long> {
}
