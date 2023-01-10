package com.example.ecommerceapi.product.productincart;

import com.example.ecommerceapi.cart.Cart;
import com.example.ecommerceapi.productsection.JPAProductSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductInCartRepository {
    private final JPAProductInCartRepository jpaProductInCartRepository;

    @Autowired
    public ProductInCartRepository(JPAProductInCartRepository jpaProductInCartRepository) {
        this.jpaProductInCartRepository = jpaProductInCartRepository;
    }

    public ProductInCart save(ProductInCart productInCart) {
        return jpaProductInCartRepository.save(productInCart);
    }

    public ProductInCart findById(Long id) {
        return jpaProductInCartRepository.findById(id).orElse(null);
    }
}
