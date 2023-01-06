package com.example.ecommerceapi.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
