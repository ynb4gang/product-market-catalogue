package com.example.ProductCatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("featuredProducts", productService.getAllProducts());
        return "home";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productList";
    }

    @GetMapping("/createProduct")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("message") String message) {
        System.out.println("Received contact form submission: " + name + ", " + email + ", " + message);
        return "redirect:/contact";
    }

}
