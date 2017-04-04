package com.romanmarkunas;

class Item {

    private final int barCode;
    private String description;
    private double price;
    private boolean isCountable;


    Item(int barCode, String description, double price, boolean isCountable) {

        this.barCode = barCode;
        this.description = description;
        this.price = price;
        this.isCountable = isCountable;
    }


    int getBarCode() { return this.barCode; }

    double getPrice() { return this.price; }

    String getDescription() { return this.description; }

    boolean isCountable() { return this.isCountable; }
}
