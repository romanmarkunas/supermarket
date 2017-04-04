package com.romanmarkunas;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void create() {

        Item testItem = new Item(10, "Beans", 0.50);

        assertEquals(10, testItem.getBarCode());
        assertEquals(0.50, testItem.getPrice(), 0.001);
        assertTrue("Beans".equals(testItem.getDescription()));
    }
}
