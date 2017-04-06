package com.romanmarkunas.supermarket.items;

public abstract class Item {

    private final int barCode;
    private String description;
    private double unitPrice;


    Item(int barCode, String description, double price) {

        this.barCode = barCode;
        this.description = description;
        this.unitPrice = price;
    }


    public abstract double getPrice();


    public int getBarCode() { return this.barCode; }

    public String getDescription() { return this.description; }

    public double getUnitPrice() { return this.unitPrice; };


    @Override
    public String toString() { return (getDescription() + " " + getUnitPrice()); }
}
