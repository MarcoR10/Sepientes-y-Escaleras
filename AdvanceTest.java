package Test;

import domain.Advance;
import domain.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;

public class AdvanceTest {
    private Advance advance;

    @Before
    public void setUp() {
        advance = new Advance(5);
    }

    @Test
    public void getNearestItem() {
        HashMap<String, Item> items = new HashMap<>();
        items.put("item1", new Item(6, 30, true));
        items.put("item2", new Item(8, 20, false));
        items.put("item3", new Item(12, 17, true));

        int[] expected = {1, 2, 10};
        Assert.assertFalse(Arrays.toString(expected), false);
    }
}