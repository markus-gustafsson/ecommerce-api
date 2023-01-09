package com.example.ecommerceapi.cart.dto;

import com.example.ecommerceapi.product.productincart.dto.ProductInCartDTO;

import java.util.List;

public record CartDTO(
    Long id,
    Integer totalNumberOfProducts,
    Double totalPrice,
    List<ProductInCartDTO> products
) {
}
