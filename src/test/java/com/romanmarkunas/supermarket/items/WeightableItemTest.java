package com.romanmarkunas.supermarket.items;

import com.romanmarkunas.supermarket.items.Item;
import com.romanmarkunas.supermarket.items.WeightableItem;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeightableItemTest {

    @Test
    public void create() {

        Item testItem = new WeightableItem(11, "Oranges", 1.99, 0.300);

        assertEquals(11, testItem.getBarCode());
        assertEquals(1.99, testItem.getUnitPrice(), 0.001);
        assertTrue("Oranges".equals(testItem.getDescription()));
        assertEquals(0.300 * 1.99, testItem.getPrice(), 0.001);
        assertEquals(0.300, ((WeightableItem)testItem).getWeight(), 0.001);
    }
}
