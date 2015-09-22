package main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BatTest {
    @Test
    public void testBatIsBat(){
        Bat bat = new Bat("Huge");
        String name = bat.toString();
        assertEquals("Huge Bat", name);
    }
}
