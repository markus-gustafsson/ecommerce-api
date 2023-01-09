package com.example.ecommerceapi.productsection;

import com.example.ecommerceapi.productsection.dto.NewProductSectionDTO;
import com.example.ecommerceapi.productsection.dto.ProductSectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
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

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductSectionDTO> createNew(@RequestBody NewProductSectionDTO newProductSectionDTO) {
        ProductSectionDTO productSectionDTO = productSectionService.create(newProductSectionDTO);
        URI location = URI.create(String.format("%s/%s", BASE_PATH, productSectionDTO.id()));
        return ResponseEntity.created(location).body(productSectionDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productSectionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
