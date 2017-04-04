package com.romanmarkunas;

class Item {

    private final int barCode;
    private String description;
    private double price;


    Item(int barCode, String description, double price) {

        this.barCode = barCode;
        this.description = description;
        this.price = price;
    }


    int getBarCode() { return this.barCode; }

    double getPrice() { return this.price; }

    String getDescription() { return this.description; }
}
