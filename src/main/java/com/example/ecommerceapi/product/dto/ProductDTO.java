package com.example.ecommerceapi.product.dto;

public record ProductDTO(
        Long id,
        String name,
        Double price,
        String imageUrl,
        Integer leftInStock
) {
}
