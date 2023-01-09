package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.cart.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/carts")
public class CartController {
    private final String BASE_PATH = "/api/carts";
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> initializeEmptyCart() {
        CartDTO cartDTO = cartService.create();
        URI location = URI.create(String.format("%s/%s", BASE_PATH, cartDTO.id()));
        return ResponseEntity.created(location).body(cartDTO);
    }
}
