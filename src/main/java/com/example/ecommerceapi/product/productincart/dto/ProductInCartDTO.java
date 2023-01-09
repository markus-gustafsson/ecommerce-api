package com.example.ecommerceapi.product.productincart.dto;

public record ProductInCartDTO(
        Long id,
        String name,
        Double price,
        String imageUrl,
        Integer quantity
) {
}
