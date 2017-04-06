package com.romanmarkunas.supermarket.purchase;

import com.romanmarkunas.supermarket.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Item, Integer> items;


    public Basket() {

        this.items = new HashMap<>();
    }


    public void add(Item item) {

        if (!items.containsKey(item)) {

            items.put(item, 1);
        }
        else {
            items.put(item, items.get(item) + 1);
        }
    }

    public Map<Item, Integer> getItems() { return new HashMap<>(items); }
}
