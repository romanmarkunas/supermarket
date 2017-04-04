package com.romanmarkunas;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void create() {

        Item testItem = new Item(10, "Beans", 0.50, true);

        assertEquals(10, testItem.getBarCode());
        assertEquals(0.50, testItem.getPrice(), 0.001);
        assertTrue("Beans".equals(testItem.getDescription()));
        assertTrue(testItem.isCountable());

        testItem =  new Item(12, "Oranges", 1.99, false);

        assertEquals(12, testItem.getBarCode());
        assertEquals(1.99, testItem.getPrice(), 0.001);
        assertTrue("Oranges".equals(testItem.getDescription()));
        assertFalse(testItem.isCountable());
    }
}
