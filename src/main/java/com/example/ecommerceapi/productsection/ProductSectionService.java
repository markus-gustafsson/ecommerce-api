package com.example.ecommerceapi.productsection;

import com.example.ecommerceapi.productsection.dto.ProductSectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSectionService {
    private final ProductSectionRepository productSectionRepository;

    @Autowired
    public ProductSectionService(ProductSectionRepository productSectionRepository) {
        this.productSectionRepository = productSectionRepository;
    }

    public List<ProductSectionDTO> getAll() {
        List<ProductSection> productSectionList = productSectionRepository.findAll();
        return productSectionList.stream()
                .map(ProductSectionConverter::toProductSectionDTO)
                .toList();
    }

    public ProductSectionDTO getById(Long id) {
        ProductSection productSection = productSectionRepository.findById(id);
        return ProductSectionConverter.toProductSectionDTO(productSection);
    }
}
