package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.product.ProductInCart;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalNumberOfProducts;
    private Double totalPrice;
    @OneToMany
    private List<ProductInCart> products;
}
