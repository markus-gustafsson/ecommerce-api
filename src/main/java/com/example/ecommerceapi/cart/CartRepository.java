package com.example.ecommerceapi.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public class CartRepository {
    private JPACartRepository jpaCartRepository;
    @Autowired
    public CartRepository(JPACartRepository jpaCartRepository) {
        this.jpaCartRepository = jpaCartRepository;
    }

    public Cart save(Cart cart) {
        return jpaCartRepository.save(cart);
    }

    public Cart findById(Long id) throws NoSuchElementException {
        return jpaCartRepository.findById(id).orElseThrow();
    }
}
