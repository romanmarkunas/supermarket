package com.romanmarkunas.supermarket.purchase;

import com.romanmarkunas.supermarket.items.CountableItem;
import com.romanmarkunas.supermarket.items.Item;
import com.romanmarkunas.supermarket.items.WeightableItem;
import com.romanmarkunas.supermarket.promotions.PromotionStrategy;
import com.romanmarkunas.supermarket.promotions.XForYPricePromotionStrategy;
import com.romanmarkunas.supermarket.purchase.Basket;
import com.romanmarkunas.supermarket.purchase.Purchase;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PurchaseTest {

    private Purchase testPurchase;

    private Basket basketMock;
    private PromotionStrategy promotion1;

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

        promotion1 = mock(XForYPricePromotionStrategy.class);
        when(promotion1.getName()).thenReturn("Super promo");

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
        assertEquals(testPurchase.getTotal(), testPurchase.getSubtotal(), 0.001);
    }

    @Test
    public void promotion() {

        HashMap<String, Double> expectedPromotionList = new HashMap<>();

        testPurchase.addPromotion(promotion1);
        items.put(testItem1, 1);

        when(promotion1.calculateDiscount(any())).thenReturn(0.0);

        testPurchase.evaluate(basketMock);
        assertEquals(testPurchase.getSubtotal(), testPurchase.getTotal() , 0.001);
        assertEquals(0.0, testPurchase.getDiscount() , 0.001);

        expectedPromotionList.put("Super promo", 0.40);
        when(promotion1.calculateDiscount(any())).thenReturn(0.40);

        testPurchase.evaluate(basketMock);
        assertEquals(testPurchase.getSubtotal() - 0.40, testPurchase.getTotal() , 0.001);
        assertEquals(0.40, testPurchase.getDiscount() , 0.001);
        assertEquals(expectedPromotionList, testPurchase.getDiscountList());
    }
}
