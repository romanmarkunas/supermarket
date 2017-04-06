package com.romanmarkunas.supermarket.promotions;

import com.romanmarkunas.supermarket.items.Item;

import java.util.Map;

public abstract class PromotionStrategy {

    private String name;


    public PromotionStrategy(String name) {

        this.name = name;
    }


    public abstract double calculateDiscount(Map<Item, Integer> sameBarcodeItems);



    public String getName() { return name; }
}
