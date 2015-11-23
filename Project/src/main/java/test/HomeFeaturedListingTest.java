package test;

import sad.entities.HomeFeaturedListing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Anthony on 11/3/2015.
 */
public class HomeFeaturedListingTest {
    @Test
    public void testHomeFeaturedCanBeConstructed(){
        HomeFeaturedListing hfl = new HomeFeaturedListing();
        assertNotNull("main.entities.HomeFeaturedListing should not be not", hfl);
    }
}
