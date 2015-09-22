package main;

import  static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ThingTest {
    @Test
    public void testThingHasName(){
        Thing thing = new Thing("Name");
        String name = thing.toString();
        assertEquals("Name", name);
    }

}
