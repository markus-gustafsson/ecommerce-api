package com.example.ecommerceapi.product;

import com.example.ecommerceapi.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    private final String BASE_PATH = "/api/products";
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> productDTOS = productService.getAll();
        return ResponseEntity.ok().body(productDTOS);
    }


}
