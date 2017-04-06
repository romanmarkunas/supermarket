package com.romanmarkunas.supermarket.promotions;

import com.romanmarkunas.supermarket.items.CountableItem;
import com.romanmarkunas.supermarket.items.Item;
import com.romanmarkunas.supermarket.items.WeightableItem;
import com.romanmarkunas.supermarket.promotions.XForYPricePromotionStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class XForYPricePromotionStrategyTest {

    private XForYPricePromotionStrategy testPromotion;
    private Map<Item, Integer> itemsToEvaluate;
    private Item testItem1;
    private Item testItem2;
    private Item testItem3;
    private Item testItem4;


    @Before
    public void setup() {

        testPromotion = new XForYPricePromotionStrategy("Coke 2 for 1", 12, 2, 1.0);

        itemsToEvaluate = new HashMap<>();
        testItem1 = new CountableItem(10, "Beans", 0.50);
        testItem2 = new WeightableItem(11, "Oranges", 1.99, 0.300);
        testItem3 = new CountableItem(12, "Coke", 0.70);
        testItem4 = new WeightableItem(11, "Oranges", 1.99, 0.200);
    }


    @Test
    public void getName() {

        assertTrue("Coke 2 for 1".equals(testPromotion.getName()));
    }

    @Test
    public void noDiscount() {

        itemsToEvaluate.put(testItem3, 1);
        assertEquals(0.0, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);
    }

    @Test
    public void discount() {

        itemsToEvaluate.put(testItem3, 2);
        assertEquals(0.40, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);

        itemsToEvaluate.put(testItem3, 3);
        assertEquals(0.40, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);
    }

    @Test
    public void nullKey() {

        itemsToEvaluate.put(null, 3);
        assertEquals(0.00, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);
    }

    @Test
    public void emptyMap() {

        assertEquals(0.00, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);
    }

    @Test
    public void nullItems() {

        assertEquals(0.00, testPromotion.calculateDiscount(null), 0.001);
    }

    @Test
    public void wrongItemType() {

        itemsToEvaluate.put(testItem2, 1);
        assertEquals(0.00, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);
    }

    @Test(expected=IllegalArgumentException.class)
    public void multipleBarcodes() {

        itemsToEvaluate.put(testItem3, 1);
        itemsToEvaluate.put(testItem1, 1);
        assertEquals(0.00, testPromotion.calculateDiscount(itemsToEvaluate), 0.001);
    }
}
