package com.romanmarkunas.supermarket;

import com.romanmarkunas.supermarket.items.CountableItem;
import com.romanmarkunas.supermarket.items.Item;
import com.romanmarkunas.supermarket.items.WeightableItem;
import com.romanmarkunas.supermarket.promotions.BuyXGetYFreePromotionStrategy;
import com.romanmarkunas.supermarket.promotions.XForYPricePromotionStrategy;
import com.romanmarkunas.supermarket.purchase.Basket;
import com.romanmarkunas.supermarket.purchase.Purchase;

public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();

        Item beans = new CountableItem(10, "Beans", 0.50);
        Item coke = new CountableItem(12, "Coke", 0.70);
        Item oranges = new WeightableItem(11, "Oranges", 1.99, 0.200);

        basket.add(beans);
        basket.add(beans);
        basket.add(beans);
        basket.add(coke);
        basket.add(coke);
        basket.add(oranges);

        Purchase purchase = new Purchase();

        purchase.addPromotion(new XForYPricePromotionStrategy("Coke 2 for Pound", 12, 2, 1.0));
        purchase.addPromotion(new BuyXGetYFreePromotionStrategy("Beans 3 for 2", 10, 3, 1));

        purchase.evaluate(basket);

        System.out.println("Items brought for checkout:");
        System.out.println(basket.getItems());
        System.out.println("Subtotal:");
        System.out.println(purchase.getSubtotal());
        System.out.println("Savings:");
        System.out.println(purchase.getDiscountList());
        System.out.println("Total savings:" + purchase.getDiscount());
        System.out.println("Total:");
        System.out.println(purchase.getTotal());
    }
}
