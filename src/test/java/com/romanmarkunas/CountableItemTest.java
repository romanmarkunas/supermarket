package com.romanmarkunas;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountableItemTest {

    @Test
    public void create() {

        Item testItem = new CountableItem(10, "Beans", 0.50);

        assertEquals(10, testItem.getBarCode());
        assertEquals(0.50, testItem.getUnitPrice(), 0.001);
        assertTrue("Beans".equals(testItem.getDescription()));
        assertEquals(0.50, testItem.getPrice(), 0.001);
    }
}
