package com.example.ecommerceapi.cart;

import org.springframework.data.repository.CrudRepository;

public interface JPACartRepository extends CrudRepository<Cart, Long> {
}
