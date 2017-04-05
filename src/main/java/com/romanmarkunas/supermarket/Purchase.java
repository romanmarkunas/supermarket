package com.romanmarkunas.supermarket;

import java.util.Map;

class Purchase {

    private Double subtotal = null;

    Purchase() {

    }


    void evaluate(Basket basket) {

        Map<Item, Integer> items = basket.getItems();

        this.subtotal = calculateSubtotal(items);
    }

    double getSubtotal() { return this.subtotal; }


    private double calculateSubtotal(Map<Item, Integer> items) {

        double subtotal = 0.0;


        for (Item item : items.keySet()) {

            subtotal += item.getPrice() * items.get(item);
        }

        return subtotal;
    }
}
