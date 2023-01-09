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
        System.out.println("");
        System.out.println("TOTAL PRICE BEFORE UPDATED -> " + this.totalPrice);
        System.out.println("");
        this.totalPrice = this.products.stream()
                .map(productInCart -> productInCart.getPrice() * productInCart.getQuantity())
                .reduce(0.0, Double::sum);
//        this.totalPrice = 0.0;
//        for (ProductInCart p : this.products) {
//            System.out.println("p.getPrice() --> " + p.getPrice());
//            System.out.println("p.getQuantity() --> " + p.getQuantity());
//            System.out.println("price * quantity == " + p.getPrice() * p.getQuantity());
//            this.totalPrice += p.getPrice() * p.getQuantity();
//        }
        System.out.println("");
        System.out.println("TOTAL PRICE _AFTER_ UPDATED -> " + this.totalPrice);
        System.out.println("");
    }

    public void updateTotalNumberOfProducts() {
        System.out.println("");
        System.out.println("TOTAL NUMBER OF PRODUCTS IN CART BEFORE UPDATED -> " + this.totalNumberOfProducts);
        System.out.println("");
        this.totalNumberOfProducts = this.products.stream()
                .map(ProductInCart::getQuantity)
                .reduce(0, Integer::sum);
        System.out.println("");
        System.out.println("TOTAL NUMBER OF PRODUCTS IN THE CART _AFTER_ UPDATED -> " + this.totalNumberOfProducts);
        System.out.println("");
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
}
