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

    public ProductSection() {
    }

    public ProductSection(String name) {
        this.name = name;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * @return The id and name of the ProductSection
     */
    @Override
    public String toString() {
        return "ProductSection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
