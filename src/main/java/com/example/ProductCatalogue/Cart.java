package com.example.ProductCatalogue;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, Integer> items = new HashMap<>();
    public Map<Long, Integer> getItems() {
        return items;
    }

    public void addItem(Long productId) {
        items.put(productId, items.getOrDefault(productId, 0)+1);
    }

    public void removeItem(Long productId) {
        items.remove(productId);
    }

    public void clearCart() {
        items.clear();
    }
}
