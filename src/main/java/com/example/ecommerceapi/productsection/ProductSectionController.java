package com.example.ecommerceapi.productsection;

import com.example.ecommerceapi.productsection.dto.ProductSectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/product-sections")
public class ProductSectionController {
    private final String BASE_PATH = "/api/product-sections";
    private final ProductSectionService productSectionService;

    @Autowired
    public ProductSectionController(ProductSectionService productSectionService) {
        this.productSectionService = productSectionService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductSectionDTO>> getAll() {
        List<ProductSectionDTO> productSectionDTOS = productSectionService.getAll();
        return ResponseEntity.ok(productSectionDTOS);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductSectionDTO> getById(@PathVariable Long id) {
        try {
            ProductSectionDTO productSectionDTO = productSectionService.getById(id);
            return ResponseEntity.ok(productSectionDTO);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
}
