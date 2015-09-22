package main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FlyTest {
    @Test
    public void testFlyIsFly(){
        Fly fly = new Fly("Big");
        String name = fly.toString();
        assertEquals("Big main.Fly", name);
    }
}
