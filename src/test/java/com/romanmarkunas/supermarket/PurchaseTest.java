package com.romanmarkunas.supermarket;

import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PurchaseTest {

    private Purchase testPurchase;

    private Basket basketMock;

    Map<Item, Integer> items;
    private Item testItem1;
    private Item testItem2;
    private Item testItem3;
    private Item testItem4;


    @Before
    public void setup() {

        items = new HashMap<>();
        testItem1 = new CountableItem(10, "Beans", 0.50);
        testItem2 = new WeightableItem(11, "Oranges", 1.99, 0.300);
        testItem3 = new CountableItem(12, "Coke", 0.70);
        testItem4 = new WeightableItem(11, "Oranges", 1.99, 0.200);

        basketMock = mock(Basket.class);
        when(basketMock.getItems()).thenReturn(items);

        testPurchase = new Purchase();
    }


    @Test
    public void subtotal() {

        items.put(testItem1, 3);
        items.put(testItem2, 2);
        items.put(testItem4, 1);

        testPurchase.evaluate(basketMock);
        verify(basketMock).getItems();

        assertEquals(3 * 0.50 + 1.99 * (0.300 * 2 + 0.200), testPurchase.getSubtotal(), 0.001);
    }
}
