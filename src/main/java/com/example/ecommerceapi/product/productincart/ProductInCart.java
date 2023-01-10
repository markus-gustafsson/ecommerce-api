package com.example.ecommerceapi.product.productincart;

import com.example.ecommerceapi.cart.Cart;
import jakarta.persistence.*;

@Entity
@Table(name = "product_in_cart")
public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Cart inCart;
    private Integer quantity;

    public ProductInCart() {
    }

    public ProductInCart(Long id, String name, Double price, String imageUrl, Cart inCart, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.inCart = inCart;
        this.quantity = quantity;
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

    public Cart getInCart() {
        return inCart;
    }

    public void setInCart(Cart inCart) {
        this.inCart = inCart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void updateQuantity(Integer change) {
        this.quantity += change;
    }

    @Override
    public String toString() {
        return "ProductInCart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", inCart=" + inCart +
                ", quantity=" + quantity +
                '}';
    }
}
