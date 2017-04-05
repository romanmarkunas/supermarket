package com.romanmarkunas;

public class WeightableItem extends Item {

    private double weight;


    WeightableItem(int barCode, String description, double price, double weight) {

        super(barCode, description, price);
        this.weight = weight;
    }


    double getWeight() { return this.weight; }

    @Override
    double getPrice() {

        return (this.weight * getUnitPrice());
    }
}
