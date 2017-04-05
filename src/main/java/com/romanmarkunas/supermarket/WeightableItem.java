package com.romanmarkunas.supermarket;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }

        if (null == obj) {

            return false;
        }

        if (obj.getClass() != getClass()) {

            return false;
        }

        WeightableItem item = (WeightableItem) obj;

        return (item.getBarCode() == this.getBarCode() && item.weight == this.weight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getBarCode());
    }
}
