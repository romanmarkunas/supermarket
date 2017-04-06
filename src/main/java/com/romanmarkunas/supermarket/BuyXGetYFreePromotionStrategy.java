package com.romanmarkunas.supermarket;

import java.util.Map;

public class BuyXGetYFreePromotionStrategy extends PromotionStrategy {

    private final int applicableBarcode;
    private final int xItems;
    private final double yFreeItems;


    public BuyXGetYFreePromotionStrategy(String name, int applicableBarcode, int xItems, double yFreeItems) {

        super(name);
        this.applicableBarcode = applicableBarcode;
        this.xItems = xItems;
        this.yFreeItems = yFreeItems;
    }


    @Override
    double calculateDiscount(Map<Item, Integer> sameBarcodeItems) {

        // TODO - this duplicate code must be refactored, probably into protected method in parent class
        if (sameBarcodeItems == null || sameBarcodeItems.isEmpty()) {

            return 0.0;
        }

        boolean firstKey = true;

        int totalItems = 0;
        double itemUnitPrice = 0.0;
        int barcode = 0;

        for (Item item : sameBarcodeItems.keySet()) {

            if (item == null) continue;

            if (item.getClass() != CountableItem.class) {

                return 0.0;
            }

            if (sameBarcodeItems.keySet().size() > 1) {

                throw new IllegalArgumentException("Promotion °\"" + this.getName() + "\" applied to multiple barcodes");
            }

            if (firstKey) {

                firstKey = false;
                itemUnitPrice = item.getUnitPrice();
                barcode = item.getBarCode();

                if (barcode != this.applicableBarcode) {

                    return 0.0;
                }
            }

            totalItems += sameBarcodeItems.get(item);
        }

        double fullPrice = totalItems * itemUnitPrice;
        double discountedPrice = (totalItems - (totalItems / xItems) * yFreeItems) * itemUnitPrice;

        return fullPrice - discountedPrice;
    }
}
