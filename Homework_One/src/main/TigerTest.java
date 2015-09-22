package main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TigerTest {
    @Test
    public void testTigerIsATiger(){
        Tiger tiger = new Tiger("Matt");
        String name = tiger.toString();
        assertEquals("Matt main.Tiger", name);
    }
}
