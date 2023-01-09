package com.example.ecommerceapi.productsection;

import com.example.ecommerceapi.product.ProductConverter;
import com.example.ecommerceapi.product.dto.ProductDTO;
import com.example.ecommerceapi.productsection.dto.ProductSectionDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSectionConverter {
    public static ProductSectionDTO toProductSectionDTO(ProductSection productSection) {
        List<ProductDTO> productDTOS = productSection.getProducts().stream()
                .map(ProductConverter::toProductDTO)
                .toList();

        return new ProductSectionDTO(
                productSection.getId(),
                productSection.getName(),
                productDTOS
        );
    }
}
