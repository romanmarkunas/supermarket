package com.romanmarkunas;

import java.util.Objects;

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



}
