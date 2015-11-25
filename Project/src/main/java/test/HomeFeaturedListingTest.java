package test;

import sad.entities.HomeFeaturedListing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HomeFeaturedListingTest {
    @Test
    public void testHomeFeaturedCanBeConstructed(){
        HomeFeaturedListing hfl = new HomeFeaturedListing();
        assertNotNull("main.entities.HomeFeaturedListing should not be not", hfl);
    }
}
