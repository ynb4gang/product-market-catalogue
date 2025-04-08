package com.example.ProductCatalogue;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CartService {
    private Cart cart = new Cart();

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Long productId) {
        cart.addItem(productId);
    }

    public void removeFromCart(Long productId) {
        cart.removeItem(productId);
    }

    public void clearCart() {
        cart.clearCart();
    }
}
