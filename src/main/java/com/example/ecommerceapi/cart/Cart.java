package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.product.ProductInCart;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalNumberOfProducts = 0;
    private Double totalPrice = 0.0;
    @OneToMany
    private List<ProductInCart> products = new ArrayList<>();

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public Integer getTotalNumberOfProducts() {
        return totalNumberOfProducts;
    }

    public void setTotalNumberOfProducts(Integer totalNumberOfProducts) {
        this.totalNumberOfProducts = totalNumberOfProducts;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductInCart> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInCart> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalNumberOfProducts=" + totalNumberOfProducts +
                ", totalPrice=" + totalPrice +
                ", products=" + products +
                '}';
    }
}
