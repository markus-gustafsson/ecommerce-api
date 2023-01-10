package com.example.ecommerceapi.cart;

import com.example.ecommerceapi.cart.dto.CartDTO;
import com.example.ecommerceapi.product.Product;
import com.example.ecommerceapi.product.productincart.ProductInCart;
import com.example.ecommerceapi.product.ProductRepository;
import com.example.ecommerceapi.product.dto.AddProductToCartDTO;
import com.example.ecommerceapi.product.productincart.ProductInCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductInCartRepository productInCartRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, ProductInCartRepository productInCartRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.productInCartRepository = productInCartRepository;
    }

    /**
     * @return The CartDTO representation of the newly created Cart
     */
    public CartDTO create() {
        Cart savedCart = cartRepository.save(new Cart());
        return CartConverter.toCartDTO(savedCart);
    }

    public CartDTO getById(Long id) {
        Cart cart = cartRepository.findById(id);
        return CartConverter.toCartDTO(cart);
    }


    // FIXME: This needs to be refactored!!
    public CartDTO addProductToCart(Long cartId, AddProductToCartDTO addProductToCartDTO) {
        Long productId = addProductToCartDTO.productId();
        Integer quantity = addProductToCartDTO.quantity();

        Cart cart = cartRepository.findById(cartId);
        Product product = productRepository.findById(productId);
        ProductInCart productInCart = productInCartRepository.findById(productId);
        if (productInCart == null) {
            ProductInCart newProductInCart = createNewProductInCart(addProductToCartDTO, cart, product);
            productInCart = productInCartRepository.save(newProductInCart);
        }

        cart.addProduct(productInCart, quantity);
        cart.updateTotalNumberOfProducts();
        cart.updateTotalPrice();

        // TODO: This should perhaps only be done at "checkout"
        product.updateStock(-quantity);
        Cart updatedCart = cartRepository.save(cart);
        productRepository.save(product);
        return CartConverter.toCartDTO(updatedCart);
    }

    private static ProductInCart createNewProductInCart(AddProductToCartDTO addProductToCartDTO, Cart cart, Product product) {
        return new ProductInCart(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                cart,
                addProductToCartDTO.quantity()
        );
    }

    public CartDTO deleteProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId);
        Product product = productRepository.findById(productId);
        ProductInCart productInCart = productInCartRepository.findById(productId);
        Integer quantity = productInCart.getQuantity();

        cart.deleteProduct(productInCart);
        cart.updateTotalNumberOfProducts();
        cart.updateTotalPrice();
        Cart updatedCart = cartRepository.save(cart);

        product.updateStock(quantity);
        productRepository.save(product);

        return CartConverter.toCartDTO(updatedCart);
    }
}
