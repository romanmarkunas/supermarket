package com.romanmarkunas;

import java.util.HashMap;
import java.util.Map;

class Basket {

    private Map<Item, Integer> items;


    Basket() {

        this.items = new HashMap<>();
    }


    void add(Item item) {

        if (!items.containsKey(item)) {

            items.put(item, 1);
        }
        else {
            items.put(item, items.get(item) + 1);
        }
    }

    Map<Item, Integer> getItems() { return new HashMap<>(items); }

    double getTotal() {

        double total = 0.0;

        for (Item item : items.keySet()) {

            total += item.getPrice() * items.get(item);
        }

        return total;
    }
}
