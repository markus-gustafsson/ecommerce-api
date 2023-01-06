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

    public CartDTO create() {
        Cart savedCart = cartRepository.save(new Cart());
        System.out.println("KEKLMAO! -->  -->  -->" + savedCart); // TODO: remove this line
        return CartConverter.toDTO(savedCart);
    }
}
