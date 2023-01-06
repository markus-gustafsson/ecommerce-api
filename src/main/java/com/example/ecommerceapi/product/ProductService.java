package com.example.ecommerceapi.product;

import com.example.ecommerceapi.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductConverter::toProductDTO)
                .toList();
    }
}
