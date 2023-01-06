package com.example.ecommerceapi.product;

import com.example.ecommerceapi.product.dto.ProductDTO;
import com.example.ecommerceapi.product.dto.ProductInCartDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public static ProductInCartDTO toProductInCartDTO(ProductInCart productInCart) {
        return new ProductInCartDTO(
                productInCart.getId(),
                productInCart.getName(),
                productInCart.getPrice(),
                productInCart.getImageUrl(),
                productInCart.getQuantity()
        );
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.getLeftInStock()
        );
    }
}
