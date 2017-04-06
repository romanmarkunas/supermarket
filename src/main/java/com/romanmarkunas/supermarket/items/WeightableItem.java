package com.romanmarkunas.supermarket.items;

import java.util.Objects;

public class WeightableItem extends Item {

    private double weight;


    public WeightableItem(int barCode, String description, double price, double weight) {

        super(barCode, description, price);
        this.weight = weight;
    }


    public double getWeight() { return this.weight; }

    @Override
    public double getPrice() {

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

    @Override
    public String toString() { return (getDescription() + " " + getUnitPrice() + " " + this.weight); }
}
