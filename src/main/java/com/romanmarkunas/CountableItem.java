package com.romanmarkunas;

class CountableItem extends Item {

    CountableItem(int barCode, String description, double price) {

        super(barCode, description, price);
    }


    @Override
    double getPrice() { return getUnitPrice(); }
}
