package com.example.ProductCatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") Long productId, @RequestHeader(value = "referer", required = false) String referer) {
        cartService.addToCart(productId);
        return "redirect:" + referer;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        Cart cart = cartService.getCart();
        Map<Product, Integer> cartItems = new HashMap<>();
        if (cart != null && cart.getItems() != null) {
            for(Map.Entry<Long, Integer> entry : cart.getItems().entrySet()) {
                productService.getProductById(entry.getKey()).ifPresent(product -> cartItems.put(product, entry.getValue()));
            }
        }
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/removeFromCart/{id}")
    public String removeFromCart(@PathVariable("id") Long productId){
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }

    @PostMapping("/clearCart")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}
