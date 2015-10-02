import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
}
