package com.example.ecommerceapi.product;

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
    private int quantity;
}
