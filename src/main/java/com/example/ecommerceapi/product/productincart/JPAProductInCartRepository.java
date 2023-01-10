package com.example.ecommerceapi.product.productincart;

import com.example.ecommerceapi.cart.Cart;
import org.springframework.data.repository.CrudRepository;

public interface JPAProductInCartRepository extends CrudRepository<ProductInCart, Long> {
}
