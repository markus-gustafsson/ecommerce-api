package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.cart.dto.CartDTO;
import com.example.ecommerceapi.product.dto.AddProductToCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(path = "/api/carts")
public class CartController {
    private final String BASE_PATH = "/api/carts";
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> initializeEmptyCart() {
        CartDTO cartDTO = cartService.create();
        URI location = URI.create(String.format("%s/%s", BASE_PATH, cartDTO.id()));
        return ResponseEntity.created(location).body(cartDTO);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> get(@PathVariable Long id) {
        try {
            CartDTO cartDTO = cartService.getById(id);
            return ResponseEntity.ok(cartDTO);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    // PUT, add product(in cart) to cart, decrease stock in Product
    @PutMapping(path = "/{cartId}/products", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> addProductToCart(
            @PathVariable Long cartId,
            @RequestBody AddProductToCartDTO addProductToCartDTO
    ) {
        try {
            CartDTO cartDTO = cartService.addProductToCart(cartId, addProductToCartDTO);
            return ResponseEntity.ok(cartDTO);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    // DELETE, remove product(in cart) from cart, increase stock in Product
    @DeleteMapping(path = "/{cartId}/products/{productId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        CartDTO cartDTO = cartService.deleteProductFromCart(cartId, productId);
        return ResponseEntity.ok(cartDTO);
    }
}
