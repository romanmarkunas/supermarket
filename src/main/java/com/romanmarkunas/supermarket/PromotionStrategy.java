package com.romanmarkunas.supermarket;

import java.util.Map;

abstract class PromotionStrategy {

    private String name;


    PromotionStrategy(String name) {

        this.name = name;
    }


    abstract double calculateDisoount(Map<Item, Integer> sameBarcodeItems);



    public String getName() { return name; }
}
