package com.romanmarkunas.supermarket;

abstract class Item {

    private final int barCode;
    private String description;
    private double unitPrice;


    Item(int barCode, String description, double price) {

        this.barCode = barCode;
        this.description = description;
        this.unitPrice = price;
    }


    abstract double getPrice();


    int getBarCode() { return this.barCode; }

    String getDescription() { return this.description; }

    double getUnitPrice() { return this.unitPrice; };


    @Override
    public String toString() { return (getDescription() + " " + getUnitPrice()); }
}
