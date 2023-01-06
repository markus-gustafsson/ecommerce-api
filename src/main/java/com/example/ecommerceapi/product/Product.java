package com.example.ecommerceapi.product;

import com.example.ecommerceapi.productsection.ProductSection;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String imageUrl;
    private Integer leftInStock;
    @ManyToMany(mappedBy = "products")
    private Set<ProductSection> productSections = new LinkedHashSet<>();
}
