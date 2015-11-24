package test;

import sad.entities.*;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by Anthony on 11/3/2015.
 */
public class AdvertiserTest {
    @Test
    public void testAdvertiserCanHaveFirstNameMiddleNameAndLastName(){
        Advertiser adv = new Advertiser();
        adv.setFname("King");
        adv.setMname("James");
        adv.setLname("The");
        adv.setSuffix("Fourth");
        String firstname = adv.getFname();
        String middlename = adv.getMname();
        String lastname = adv.getLname();
        String suffix = adv.getSuffix();
        String fullname = firstname + " "  + middlename + " " + lastname + " " + suffix;
        assertEquals("main.entities.Advertiser has first, middle, last name, and suffix", "King James The Fourth", fullname);
        assertEquals("main.entities.Advertiser has full name", "King James The Fourth", adv.getFullName());
    }

    @Test
    public void testAdvertiserCanOnlyHaveFirstAndLastName(){
        Advertiser adv = new Advertiser();
        adv.setFname("King");
        adv.setLname("James");
        String firstname = adv.getFname();
        String lastname = adv.getLname();
        String fullname = firstname + " " + lastname;
        assertEquals("main.entities.Advertiser has first and last name", "King James", fullname);
        assertEquals("main.entities.Advertiser has full name with just first and last name", "King James", adv.getFullName());
    }

    @Test
    public void testAdvertiserCanHaveAnEmailAddress(){
        Advertiser adv = new Advertiser();
        adv.setEmailAddr("email@email.com");
        String email = adv.getEmailAddr();
        assertEquals("main.entities.Advertiser has an email address", "email@email.com", email);
    }

    @Test
    public void testAdvertiserCanHaveABusinessName(){
        Advertiser adv = new Advertiser();
        adv.setBusinessName("Personal Business");
        String business = adv.getBusinessName();
        assertEquals("main.entities.Advertiser has a business", "Personal Business", business);
    }

    @Test
    public void testAdvertiserCanHaveAPhoneNumber(){
        Advertiser adv = new Advertiser();
        adv.setPhoneNumber("(123)456-7890");
        String phoneNumber = adv.getPhoneNumber();
        assertEquals("main.entities.Advertiser has a phone number", "(123)456-7890", phoneNumber);
    }

    @Test
    public void testAdvertiserCanHaveASocialMediaAccount(){
        Advertiser adv = new Advertiser();
        adv.addSocialMedia("Facebook", "www.facebook.com/profile=king%20james");
        String socialMedia = adv.getAllSocialMedia()[0];
        assertEquals("main.entities.Advertiser have a social media account", "Facebook:www.facebook.com/profile=king%20james", socialMedia);
    }

    @Test
    public void testAdvertiserCanHaveMultipleMediaAccounts(){
        Advertiser adv = new Advertiser();
        adv.addSocialMedia("Facebook", "www.facebook.com/profile=king%20james");
        adv.addSocialMedia("LinkedIn", "www.linkedin.com/profile=king%20james");
        adv.addSocialMedia("Twitter", "www.twitter.com/profile=king%20james");
        String[] expected = {"Facebook:www.facebook.com/profile=king%20james", "LinkedIn:www.linkedin.com/profile=king%20james", "Twitter:www.twitter.com/profile=king%20james"};
        assertArrayEquals("main.entities.Advertiser can have multiple social media accounts", expected, adv.getAllSocialMedia());
    }

    /*CREATE A TEST FOR IF A SOCIAL MEDIA DOESN'T EXIST*/
    @Test
    public void testAdvertiserCanUpdateASocialMediaAccount(){
        Advertiser adv = new Advertiser();
        adv.addSocialMedia("Facebook", "www.facebook.com/profile=king%20james");
        adv.addSocialMedia("LinkedIn", "www.linkedin.com/profile=king%20james");
        adv.addSocialMedia("Twitter", "www.twitter.com/profile=king%20james");
        adv.setSocialMedia("Facebook", "www.facebook.com/profile=king%20james%20V");
        String[] expected = {"Facebook:www.facebook.com/profile=king%20james%20V", "LinkedIn:www.linkedin.com/profile=king%20james", "Twitter:www.twitter.com/profile=king%20james"};
        assertArrayEquals("main.entities.Advertiser\'s Social Media Information can be updated", expected, adv.getAllSocialMedia());
    }

    @Test
    public void testAdvertiserHasAStartDate(){
        Advertiser adv = new Advertiser();
        adv.setStartDate("Jan 02, 2001");
        String startDate = adv.getStartDate();
        assertEquals("main.entities.Advertiser\'s have start date (with String)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testAdvertiserHasAStartDate2(){
        Advertiser adv = new Advertiser();
        adv.setStartDate(new GregorianCalendar(2001, 0, 2));
        String startDate = adv.getStartDate();
        assertEquals("main.entities.Advertiser\'s have start date (with Gregorian Calender)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testAdvertiserHasAStartDate3(){
        Advertiser adv = new Advertiser();
        adv.setStartDate(2001, 1, 2);
        String startDate = adv.getStartDate();
        assertEquals("main.entities.Advertiser\'s have start date (with 3 integers)", "Jan 02, 2001", startDate);
    }

    @Test
    public void testAdvertiserHasAListing(){
        Advertiser adv = new Advertiser();
        Listing listing = new Listing();
        listing.setBusinessDescription("This is one of my listing");
        adv.giveListing(listing);
        Listing theListing = adv.getListings()[0];

        Listing expected = new Listing();
        expected.setBusinessDescription("This is one of my listing");

        boolean listingBool = expected.equalTo(theListing);
        assertTrue("main.entities.Advertiser\'s have a list", listingBool);
    }

    @Test
    public void testAdvertiserHaveManyListing(){
        Advertiser adv = new Advertiser();

        Listing listing = new Listing();
        listing.setBusinessDescription("This is main.entities.Listing 0");

        Listing listing1 = new Listing();
        listing1.setBusinessDescription("This is main.entities.Listing 1");

        Listing listing2 = new Listing();
        listing2.setBusinessDescription("This is main.entities.Listing 2");

        adv.giveListing(listing);
        adv.giveListing(listing1);
        adv.giveListing(listing2);

        Listing expected = new Listing();
        expected.setBusinessDescription("This is main.entities.Listing 0");

        Listing expected1 = new Listing();
        expected1.setBusinessDescription("This is main.entities.Listing 1");

        Listing expected2 = new Listing();
        expected2.setBusinessDescription("This is main.entities.Listing 2");

        Listing[] advListing = adv.getListings();

        boolean expectedVsList = (expected.equalTo(advListing[0])) && (expected1.equalTo(advListing[1])) && (expected2.equalTo(advListing[2])) &&  (advListing.length == 3);

        assertTrue("main.entities.Advertiser has more than one listing", expectedVsList);

    }

    /*Test for different types of listing*/
    @Test
    public void testAdvertiserHaveManyDifferentTypesOfListing(){
        Advertiser adv = new Advertiser();

        CategoryListing listing = new CategoryListing(new Category("History"));
        listing.setBusinessDescription("A category listing");

        HomeFeaturedListing listing1 = new HomeFeaturedListing();
        listing1.setBusinessDescription("A home featured listing");

        Listing listing2 = new Listing();
        listing2.setBusinessDescription("A regular listing");

        adv.giveListing(listing);
        adv.giveListing(listing1);
        adv.giveListing(listing2);

        CategoryListing expected = new CategoryListing(new Category("History"));
        expected.setBusinessDescription("A category listing");

        HomeFeaturedListing expected1 = new HomeFeaturedListing();
        expected1.setBusinessDescription("A home featured listing");

        Listing expected2 = new Listing();
        expected2.setBusinessDescription("A regular listing");

        Listing[] advListing = adv.getListings();

        boolean expectedVsList = (expected.equalTo((CategoryListing)advListing[0])) && (expected1.equalTo((HomeFeaturedListing)advListing[1])) && (expected2.equalTo(advListing[2])); //might change to be more efficient

        assertTrue("main.entities.Advertiser has more than one listing and they are of different types", expectedVsList);
        assertTrue("main.entities.Category main.entities.Listing remained a category listing", advListing[0] instanceof CategoryListing);
        assertTrue("Home-featured main.entities.Listing remained a home featured listing", advListing[1] instanceof HomeFeaturedListing);
        assertTrue("Listitng is just a listing", advListing[2] instanceof  Listing);
    }

    @Test
    public void testAdvertisersHaveDifferentIDs(){
        Advertiser adv = new Advertiser();
        Advertiser adv1 = new Advertiser();
        Advertiser adv2 = new Advertiser();

        int advID = adv.getId();
        int adv1ID = adv1.getId();
        int adv2ID = adv2.getId();

        assertNotEquals("IDs are not equal", advID, adv1ID);
        assertNotEquals("IDs are not equal", advID, adv2ID);
        assertNotEquals("IDs are not equals", adv1ID, adv2ID);
    }
}
