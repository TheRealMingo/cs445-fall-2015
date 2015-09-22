package main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AntTest  {
    @Test
    public void testAntIsAnt(){
        Ant ant = new Ant("Hero");
        String name = ant.toString();
        assertEquals("Hero Ant", name);
    }
}
