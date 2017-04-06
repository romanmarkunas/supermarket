package com.romanmarkunas.supermarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Purchase {

    private Double subtotal = null;
    private List<PromotionStrategy> promotions;
    private Double totalDiscount;
    private Map<String, Double> discountList;


    Purchase() {

        promotions = new ArrayList<>();
    }


    void addPromotion(PromotionStrategy promotion) {

        // TODO - override equals in PromotionStrategy to ensure no duplicates are inserted
        if (!promotions.contains(promotion)) {

            promotions.add(promotion);
        }
    }

    void evaluate(Basket basket) {

        this.discountList = new HashMap<>();

        Map<Item, Integer> items = basket.getItems();

        this.subtotal = calculateSubtotal(items);
        this.totalDiscount = calculateDiscount(items);
    }

    Double getSubtotal() { return this.subtotal; }

    Double getDiscount() { return this.totalDiscount; }

    Double getTotal() { return (this.subtotal - this.totalDiscount); }

    Map<String, Double> getDiscountList() { return new HashMap<>(discountList); }


    private double calculateSubtotal(Map<Item, Integer> items) {

        double subtotal = 0.0;


        for (Item item : items.keySet()) {

            subtotal += item.getPrice() * items.get(item);
        }

        return subtotal;
    }

    private double calculateDiscount(Map<Item, Integer> items) {

        Map<Integer, Map<Item, Integer>> itemsGroupedByBarcodes = new HashMap<>();

        for (Item item : items.keySet()) {

            int barcode = item.getBarCode();

            if (!itemsGroupedByBarcodes.containsKey(barcode)) {

                Map<Item, Integer> temp = new HashMap<>();
                temp.put(item, items.get(item));

                itemsGroupedByBarcodes.put(barcode, temp);
            }
            else {
                itemsGroupedByBarcodes.get(barcode).put(item, items.get(item));
            }
        }


        double discount = 0.0;

        for (Integer barcode : itemsGroupedByBarcodes.keySet()) {

            for (PromotionStrategy ps : promotions) {

                double temp = ps.calculateDisoount(itemsGroupedByBarcodes.get(barcode));

                if (temp > 0.001) {

                    discount += temp;
                    this.discountList.put(ps.getName(), temp);
                }
            }
        }

        return discount;
    }
}
