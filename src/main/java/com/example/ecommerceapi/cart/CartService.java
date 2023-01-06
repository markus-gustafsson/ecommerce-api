package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.cart.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /**
     * @return The CartDTO representation of the newly created Cart
     */
    public CartDTO create() {
        Cart savedCart = cartRepository.save(new Cart());
        return CartConverter.toDTO(savedCart);
    }
}
