package com.example.ecommerceapi.product.dto;

public record NewProductDTO(
        String name,
        Double price,
        String imageUrl,
        Integer amountOfProducts
) {
}
