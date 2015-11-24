package test;

import sad.entities.Advertiser;
import sad.entities.Listing;
import org.junit.Test;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ListingTests {
    @Test
    public void testListingCanGiveBusinessDescription(){
        Listing listing = new Listing();
        listing.setBusinessDescription("This is a business description.");
        String businessDescription = listing.getBusinessDescription();
        assertEquals("Can give listing a business description.", "This is a business description.", businessDescription);
    }

    @Test
    public void testListingCanGiveImageLoc(){
        Listing listing = new Listing();
        String location = "C:\\Users\\Public\\Images\\animal.jpg";
        listing.setImageLoc(location);
        String listLocation = listing.getImageLoc();
        assertEquals("Can give listing a image location.", "C:\\Users\\Public\\Images\\animal.jpg", listLocation);
    }

    @Test
    public void testListingCanGiveWebsiteLink(){
        Listing listing = new Listing();
        String websiteLink = "http://www.advertiser.com/";
        listing.setWebsiteLink(websiteLink);
        String listWebsiteLink = listing.getWebsiteLink();
        assertEquals("Can give listing a website link.", "http://www.advertiser.com/", listWebsiteLink);
    }

    @Test
    public void testListingCanGivePrice(){
        Listing listing = new Listing();
        double price = 12.50;
        listing.setPrice(price);
        double listPrice = listing.getPrice();
        assertEquals("Can give listing a price.", 12.50, listPrice,0.001);
    }

    @Test
    public void testListingCanGiveStartDate(){
        Listing listing = new Listing();
        listing.setStartDate(new GregorianCalendar(2001, 0, 2));
        String startDate = listing.getStartDate();
        assertEquals("Can give listing a start date (with Gregorian Calendar class)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testListingCanGiveStartDate2(){
        Listing listing = new Listing();
        listing.setStartDate(2001, 1, 2);
        String startDate = listing.getStartDate();
        assertEquals("Can give listing a start date (with 3 integers)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testListingCanGiveStartDate3(){
        Listing listing = new Listing();
        listing.setStartDate("Jan 02, 2001");
        String startDate = listing.getStartDate();
        assertEquals("Can give listing a start date (with String)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testListingCanGiveEndDate(){
        Listing listing = new Listing();
        listing.setEndDate(new GregorianCalendar(2001, 11, 31));
        String endDate = listing.getEndDate();
        assertEquals("Can give listing an end date (with Gregorian Calendar class)", "Dec 31, 2001", endDate);
    }

    @Test
    public void testListingCanGiveEndDate2(){
        Listing listing = new Listing();
        listing.setEndDate(2001, 12, 31);
        String endDate = listing.getEndDate();
        assertEquals("Can give listing an end date (with 3 integers)", "Dec 31, 2001", endDate);
    }


    @Test
    public void testListingCanGiveEndDate3(){
        Listing listing = new Listing();
        listing.setEndDate("Dec 31, 2001");
        String startDate = listing.getEndDate();
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
        adv.setFname("Bob");
        adv.setMname("The");
        adv.setLname("Builder");
        adv.setSuffix("IV");
        adv.setBusinessName("Bob\'s Buildings");

        Listing theListing = new Listing(adv, "This is a listing", "C:\\images\\image.jpg", "http://www.business.com/", "Jan 01, 2014", "Jan 01, 2015", 30.25);
        assertEquals("Can get advertiser\'s first name from listing", "Bob".trim(), theListing.getAdvertiserFirstName());
        assertEquals("Can get advertiser\'s middle name from listing", "The".trim(), theListing.getAdvertiserMiddleName());
        assertEquals("Can get advertiser\'s last name from listing", "Builder".trim(), theListing.getAdvertiserLastName());
        assertEquals("Can get advertiser\'s suffix from listing", "IV".trim(), theListing.getAdvertiserSuffix());
        assertEquals("Can get advertiser\'s  full name from listing", "Bob The Builder IV".trim(), theListing.getAdvertiserFullName());
        assertEquals("Can get advertiser\'s business name", "Bob\'s Buildings".trim(), theListing.getAdvertiserBusinessName());
    }
}
