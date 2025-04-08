package com.example.ProductCatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product>getFeaturedProducts() {
        return productRepository.findByFeatured(true);
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return  productRepository.findById(id);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
