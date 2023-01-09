package com.example.ecommerceapi.product.dto;

public record AddProductToCartDTO(
        Long productId,
        Integer quantity
) {
}
