package com.example.ecommerceapi.productsection;

import com.example.ecommerceapi.product.Product;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product_section")
public class ProductSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private Set<Product> products = new LinkedHashSet<>();
}
