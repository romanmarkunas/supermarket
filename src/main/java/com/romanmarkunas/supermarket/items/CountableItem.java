package com.romanmarkunas.supermarket.items;

import java.util.Objects;

public class CountableItem extends Item {

    public CountableItem(int barCode, String description, double price) {

        super(barCode, description, price);
    }


    @Override
    public double getPrice() { return getUnitPrice(); }

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

        CountableItem item = (CountableItem) obj;

        return (item.getBarCode() == this.getBarCode());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getBarCode());
    }
}
