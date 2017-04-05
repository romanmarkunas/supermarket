package com.romanmarkunas.supermarket;

import java.util.Objects;

class CountableItem extends Item {

    CountableItem(int barCode, String description, double price) {

        super(barCode, description, price);
    }


    @Override
    double getPrice() { return getUnitPrice(); }

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