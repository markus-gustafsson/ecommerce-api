package com.example.ecommerceapi.product.dto;

public record ProductInCartDTO(
        Long id,
        String name,
        Double price,
        String imageUrl,
        Integer quantity
) {
}
