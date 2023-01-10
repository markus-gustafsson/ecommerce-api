package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.product.productincart.ProductInCart;
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

    public void updateTotalPrice() {
        this.totalPrice = this.products.stream()
                .map(productInCart -> productInCart.getPrice() * productInCart.getQuantity())
                .reduce(0.0, Double::sum);
    }

    public void updateTotalNumberOfProducts() {
        this.totalNumberOfProducts = this.products.stream()
                .map(ProductInCart::getQuantity)
                .reduce(0, Integer::sum);
    }

    public List<ProductInCart> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInCart> products) {
        this.products = products;
    }

    public void addProduct(ProductInCart productInCart, Integer quantity) {
        for (ProductInCart p : this.products) {
            if (p.getId().equals(productInCart.getId())) {
                p.updateQuantity(quantity);
                return;
            }
        }
        this.products.add(productInCart);
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

    public boolean deleteProduct(ProductInCart productInCart) {
        return this.products.remove(productInCart);
    }
}
