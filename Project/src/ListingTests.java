import org.junit.Test;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ListingTests {
    @Test
    public void testListingCanGiveBusinessDescription(){
        Listing listing = new Listing();
        listing.updateBusinessDescription("This is a business description.");
        String businessDescription = listing.obtainBusinessDescription();
        assertEquals("Can give listing a business description.", "This is a business description.", businessDescription);
    }

    @Test
    public void testListingCanGiveImageLoc(){
        Listing listing = new Listing();
        String location = "C:\\Users\\Public\\Images\\animal.jpg";
        listing.updateImageLoc(location);
        String listLocation = listing.obtainImageLoc();
        assertEquals("Can give listing a image location.", "C:\\Users\\Public\\Images\\animal.jpg", listLocation);
    }

    @Test
    public void testListingCanGiveWebsiteLink(){
        Listing listing = new Listing();
        String websiteLink = "http://www.advertiser.com/";
        listing.updateWebsiteLink(websiteLink);
        String listWebsiteLink = listing.obtainWebsiteLink();
        assertEquals("Can give listing a website link.", "http://www.advertiser.com/", listWebsiteLink);
    }

    @Test
    public void testListingCanGivePrice(){
        Listing listing = new Listing();
        double price = 12.50;
        listing.updatePrice(price);
        double listPrice = listing.obtainPrice();
        assertEquals("Can give listing a price.", 12.50, listPrice,0.001);
    }

    @Test
    public void testListingCanGiveStartDate(){
        Listing listing = new Listing();
        listing.updateStartDate(new GregorianCalendar(2001, 0, 2));
        String startDate = listing.obtainStartDate();
        assertEquals("Can give listing a start date (with Gregorian Calendar class)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testListingCanGiveStartDate2(){
        Listing listing = new Listing();
        listing.updateStartDate(2001, 1, 2);
        String startDate = listing.obtainStartDate();
        assertEquals("Can give listing a start date (with 3 integers)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testListingCanGiveStartDate3(){
        Listing listing = new Listing();
        listing.updateStartDate("Jan 02, 2001");
        String startDate = listing.obtainStartDate();
        assertEquals("Can give listing a start date (with String)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testListingCanGiveEndDate(){
        Listing listing = new Listing();
        listing.updateEndDate(new GregorianCalendar(2001, 11, 31));
        String endDate = listing.obtainEndDate();
        assertEquals("Can give listing an end date (with Gregorian Calendar class)", "Dec 31, 2001", endDate);
    }

    @Test
    public void testListingCanGiveEndDate2(){
        Listing listing = new Listing();
        listing.updateEndDate(2001, 12, 31);
        String endDate = listing.obtainEndDate();
        assertEquals("Can give listing an end date (with 3 integers)", "Dec 31, 2001", endDate);
    }


    @Test
    public void testListingCanGiveEndDate3(){
        Listing listing = new Listing();
        listing.updateEndDate("Dec 31, 2001");
        String startDate = listing.obtainEndDate();
        assertEquals("Can give listing an end date (with String)", "Dec 31, 2001", startDate);
    }

    @Test
    public void testListingAreEqual(){
        Listing listing = new Listing(new Advertiser(),"This is a listing", "C:\\images\\image.jpg", "http://www.business.com/", "Jan 01, 2014", "Jan 01, 2015", 30.25);
        Listing listing1 = new Listing(new Advertiser(), "This is a listing", "C:\\images\\image.jpg", "http://www.business.com/", "Jan 01, 2014", "Jan 01, 2015", 30.25);
        assertTrue("Listings should be equal", listing.equalTo(listing1));
    }

    @Test
    public void testListingAreNotEqual(){
        Listing listing = new Listing(new Advertiser(), "This is a listing", "C:\\images\\image.jpg", "http://www.business.com/", "Jan 01, 2014", "Jan 01, 2015", 30.25);
        Listing listing1 = new Listing(new Advertiser(), "This is another listing", "C:\\images\\image.jpg", "http://www.business.com/", "Jan 01, 2014", "Jan 01, 2015", 30.25);
        assertFalse("Listings should not be equal", listing.equalTo(listing1));
    }

    @Test
    public void testListingCanObtainAdvertisersNames(){
        Advertiser adv = new Advertiser();
        adv.updateFirstName("Bob");
        adv.updateMiddleName("The");
        adv.updateLastName("Builder");
        adv.updateSuffix("IV");
        adv.updateBusinessName("Bob\'s Buildings");

        Listing theListing = new Listing(adv, "This is a listing", "C:\\images\\image.jpg", "http://www.business.com/", "Jan 01, 2014", "Jan 01, 2015", 30.25);
        assertEquals("Can get advertiser\'s first name from listing", "Bob".trim(), theListing.obtainAdvertiserFirstName());
        assertEquals("Can get advertiser\'s middle name from listing", "The".trim(), theListing.obtainAdvertiserMiddleName());
        assertEquals("Can get advertiser\'s last name from listing", "Builder".trim(), theListing.obtainAdvertiserLastName());
        assertEquals("Can get advertiser\'s suffix from listing", "IV".trim(), theListing.obtainAdvertiserSuffix());
        assertEquals("Can get advertiser\'s  full name from listing", "Bob The Builder IV".trim(), theListing.obtainAdvertiserFullName());
        assertEquals("Can get advertiser\'s business name", "Bob\'s Buildings".trim(), theListing.obtainAdvertiserBusinessName());
    }
}
