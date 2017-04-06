package com.romanmarkunas.supermarket.purchase;

import com.romanmarkunas.supermarket.items.CountableItem;
import com.romanmarkunas.supermarket.items.Item;
import com.romanmarkunas.supermarket.items.WeightableItem;
import com.romanmarkunas.supermarket.purchase.Basket;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BasketTest {

    private Basket testBasket;
    private Item testItem1;
    private Item testItem2;
    private Item testItem3;


    @Before
    public void setup() {

        testBasket = new Basket();

        testItem1 = new CountableItem(10, "Beans", 0.50);
        testItem2 = new WeightableItem(11, "Oranges", 1.99, 0.300);
        testItem3 = new CountableItem(12, "Coke", 0.70);
    }

    @Test
    public void add() {

        testBasket.add(testItem1);
        testBasket.add(testItem1);
        testBasket.add(testItem2);
        testBasket.add(testItem2);
        testBasket.add(testItem3);
        Item mustBeSeparateKey = new WeightableItem(11, "Oranges", 1.99, 0.200);
        testBasket.add(mustBeSeparateKey);

        Map<Item, Integer> expectedContent = new HashMap<>();
        expectedContent.put(testItem1, 2);
        expectedContent.put(testItem2, 2);
        expectedContent.put(testItem3, 1);
        expectedContent.put(mustBeSeparateKey, 1);

        assertEquals(expectedContent, testBasket.getItems());
    }
}
