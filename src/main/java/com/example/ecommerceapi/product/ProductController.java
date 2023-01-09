package com.example.ecommerceapi.product;

import com.example.ecommerceapi.product.dto.NewProductDTO;
import com.example.ecommerceapi.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.lang.String.*;
import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    private final String BASE_PATH = "/api/products";
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> productDTOS = productService.getAll();
        return ResponseEntity.ok().body(productDTOS);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> create(@RequestBody NewProductDTO newProductDTO) {
        ProductDTO productDTO = productService.create(newProductDTO);
        URI location = URI.create(format("%s/%s", BASE_PATH, productDTO.id()));
        return ResponseEntity.created(location).body(productDTO);
    }


}
