package com.romanmarkunas.supermarket;

import java.util.Map;

public abstract class PromotionStrategy {

    private String name;


    public PromotionStrategy(String name) {

        this.name = name;
    }


    abstract double calculateDiscount(Map<Item, Integer> sameBarcodeItems);



    public String getName() { return name; }
}
