package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.cart.dto.CartDTO;
import com.example.ecommerceapi.product.ProductConverter;
import com.example.ecommerceapi.product.productincart.dto.ProductInCartDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartConverter {

    public static CartDTO toCartDTO(Cart cart) {
        List<ProductInCartDTO> productInCartDTOS = cart.getProducts()
                .stream()
                .map(ProductConverter::toProductInCartDTO)
                .toList();

        return new CartDTO(
                cart.getId(),
                cart.getTotalNumberOfProducts(),
                cart.getTotalPrice(),
                productInCartDTOS
        );
    }
}
