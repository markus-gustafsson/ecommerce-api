package com.example.ecommerceapi.productsection.dto;

import com.example.ecommerceapi.product.dto.ProductDTO;

import java.util.List;

public record ProductSectionDTO(
        Long id,
        String name,
        List<ProductDTO> products
) {
}
