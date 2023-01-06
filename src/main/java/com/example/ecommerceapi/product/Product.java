package com.example.ecommerceapi.product;

import com.example.ecommerceapi.productsection.ProductSection;
import jakarta.persistence.*;

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

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getLeftInStock() {
        return leftInStock;
    }

    public void setLeftInStock(Integer leftInStock) {
        this.leftInStock = leftInStock;
    }

    public Set<ProductSection> getProductSections() {
        return productSections;
    }

    public void setProductSections(Set<ProductSection> productSections) {
        this.productSections = productSections;
    }
}
