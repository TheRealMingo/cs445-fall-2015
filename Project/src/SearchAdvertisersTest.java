import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Anthony on 11/15/2015.
 */
public class SearchAdvertisersTest {
    private Advertiser adv0 = new Advertiser("Bob", "", "Bill", "Jr.", "bob@business.net", "Business.net", "(773)324-9094", "Jan 03, 2012");
    private Advertiser adv1 = new Advertiser("David", "Paul", "Jean", "", "jean@heroes.org", "Heroes.org", "(662)546-0967", "Feb 29, 2011");
    private Advertiser adv2 = new Advertiser("Carl", "Bubba", "Jones", "IV", "carl@carl.com", "Carls Cars", "(445)939-0934", "Mar 20, 2010");
    private Advertiser adv3 = new Advertiser("Antonio", "Anthony", "Antony", "II", "ant@welovepeople.org", "Every Deserves Love LLC", "(556)890-9403", "Jun 5, 2009");
    private Advertiser adv4 = new Advertiser("Own", "Lloyd", "Dawg", "", "dawg@sad.com", "SAD: Special Advertising Directory", "(654)586-9843", "Apr 6, 2008");

    private Listing list0 = new Listing(adv0, "This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private Listing list1 = new Listing(adv1, "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2017", 540.87);
    private Listing list2 = new Listing(adv2, "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);
    private Listing list3 = new Listing(adv3, "This is a place for anyone who wants to be loved", "your heart", "www.welovepeople.org", "Nov 10, 2015", "Dec 10, 2015", 100.10);
    private Listing list4 = new Listing(adv4, "This is SAD", "SAD", "www.sad.com", "Nov 15, 2000", "Dec 19, 2060", 0.00);

    private CategoryListing clist0 = new CategoryListing(adv0, new Category("General") ,"This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private CategoryListing clist1 = new CategoryListing(adv1, new Category("Mythology"), "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2017", 540.87);
    private CategoryListing clist2 = new CategoryListing(adv2, new Category("Automobiles"), "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);
    private CategoryListing clist3 = new CategoryListing(adv3, new Category("Counseling"), "This is a place for anyone who wants to be loved", "your heart", "www.welovepeople.org", "Nov 10, 2015", "Dec 10, 2015", 100.10);
    private CategoryListing clist4 = new CategoryListing(adv4, new Category("Advertising"), "This is SAD", "SAD", "www.sad.com", "Nov 15, 2000", "Dec 19, 2060", 0.00);

    private HomeFeaturedListing hlist0 = new HomeFeaturedListing(adv0, "This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private HomeFeaturedListing hlist1 = new HomeFeaturedListing(adv1, "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2017", 540.87);
    private HomeFeaturedListing hlist2 = new HomeFeaturedListing(adv2, "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);

    private AdvertiserArray aa = new AdvertiserArray();
    private ListingArray la = new ListingArray();

    @Test
    public void testCanSearchAdvertiserByEmailAddress(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);
        la.addListing(clist0);
        la.addListing(clist1);
        la.addListing(clist2);
        la.addListing(clist3);
        la.addListing(clist4);
        la.addListing(hlist0);
        la.addListing(hlist1);
        la.addListing(hlist2);

        Listing[] theListings = SearchAdvertisers.searchByEmailAddress(aa, la, "carl@carl.com");
        Listing[] expected = {list2, clist2, hlist2};

        assertArrayEquals("Can Obtain Listings from Searching Advertiser\'s By Email", expected, theListings);
    }

    @Test
    public void testCanSearchAdvertiserByLastName(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);
        la.addListing(clist0);
        la.addListing(clist1);
        la.addListing(clist2);
        la.addListing(clist3);
        la.addListing(clist4);
        la.addListing(hlist0);
        la.addListing(hlist1);
        la.addListing(hlist2);

        Listing[] theListings = SearchAdvertisers.searchByLastName(aa, la, "Bill");
        Listing[] expected = {list0, clist0, hlist0};

        assertArrayEquals("Can Obtain Listings from Searching By Advertiser\'s Last Name", expected, theListings);
    }

    @Test
    public void testCanSearchAdvertiserByBusinessName(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);
        la.addListing(clist0);
        la.addListing(clist1);
        la.addListing(clist2);
        la.addListing(clist3);
        la.addListing(clist4);
        la.addListing(hlist0);
        la.addListing(hlist1);
        la.addListing(hlist2);

        Listing[] theListings = SearchAdvertisers.searchByBusinessName(aa, la, "Heroes.org");
        Listing[] expected = {list1, clist1, hlist1};

        assertArrayEquals("Can Obtain Listings from Searching By Advertiser\'s Last Name", expected, theListings);
    }

    @Test
    public void testCanSearchAdvertiserByPhoneNumber(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);
        la.addListing(clist0);
        la.addListing(clist1);
        la.addListing(clist2);
        la.addListing(clist3);
        la.addListing(clist4);
        la.addListing(hlist0);
        la.addListing(hlist1);
        la.addListing(hlist2);

        Listing[] theListings = SearchAdvertisers.searchByPhoneNumber(aa, la, "(654)586-9843");
        Listing[] expected = {list4, clist4};

        assertArrayEquals("Can Obtain Listings from Searching By Advertiser\'s Phone Number", expected, theListings);
    }

    @Test
    public void testCanSearchBySocialMedia(){
        /*
        *
    private Advertiser adv0 = new Advertiser("Bob", "", "Bill", "Jr.", "bob@business.net", "Business.net", "(773)324-9094", "Jan 03, 2012");
    private Advertiser adv1 = new Advertiser("David", "Paul", "Jean", "", "jean@heroes.org", "Heroes.org", "(662)546-0967", "Feb 29, 2011");
    private Advertiser adv2 = new Advertiser("Carl", "Bubba", "Jones", "IV", "carl@carl.com", "Carls Cars", "(445)939-0934", "Mar 20, 2010");
    private Advertiser adv3 = new Advertiser("Antonio", "Anthony", "Antony", "II", "ant@welovepeople.org", "Every Deserves Love LLC", "(556)890-9403", "Jun 5, 2009");
    private Advertiser adv4 = new Advertiser("Own", "Lloyd", "Dawg", "", "dawg@sad.com", "SAD: Special Advertising Directory", "(654)586-9843", "Apr 6, 2008");
        *
        * */
        adv0.addSocialMedia("Facebook", "Business.net Profile");
        adv0.addSocialMedia("Twitter", "Business.net Twitter Page");
        adv0.addSocialMedia("LinkedIn", "Bob Bill Jr.");
        aa.addAdvertiser(adv0);

        adv1.addSocialMedia("Facebook", "Heroes.org Profile");
        adv1.addSocialMedia("Twitter", "Heroes.org Twitter Page");
        adv1.addSocialMedia("LinkedIn", "David Paul Jean");
        aa.addAdvertiser(adv1);

        adv2.addSocialMedia("Facebook", "Carls Cars Profile");
        adv2.addSocialMedia("Twitter", "Carls Cars Twitter Page");
        adv2.addSocialMedia("LinkedIn", "Carl Bubba Jones IV");
        aa.addAdvertiser(adv2);

        adv3.addSocialMedia("Facebook", "Every One Deserves Love LLC Profile");
        adv3.addSocialMedia("Twitter", "Every One Deserves Love Twitter Page");
        adv3.addSocialMedia("LinkedIn", "Antonio Anthony Antony II");
        aa.addAdvertiser(adv3);

        adv4.addSocialMedia("Facebook", "SAD: Special Advertising Directory Profile");
        adv4.addSocialMedia("Twitter", "SAD: Special Advertising Directory Twitter Page");
        adv4.addSocialMedia("LinkedIn", "Own Lloyd Dawg");
        aa.addAdvertiser(adv4);

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);
        la.addListing(clist0);
        la.addListing(clist1);
        la.addListing(clist2);
        la.addListing(clist3);
        la.addListing(clist4);
        la.addListing(hlist0);
        la.addListing(hlist1);
        la.addListing(hlist2);

        Listing[] facebookTest = SearchAdvertisers.searchBySocialMedia(aa, la, "Facebook", "Business.net Profile");
        Listing[] twitterTest = SearchAdvertisers.searchBySocialMedia(aa, la, "Twitter", "Heroes.org Twitter Page");
        Listing[] linkedinTest = SearchAdvertisers.searchBySocialMedia(aa, la, "LinkedIn", "Antonio Anthony Antony II");

        Listing[] facebookExpected = {list0, clist0, hlist0};
        Listing[] twitterExpected = {list1, clist1, hlist1};
        Listing[] linkedinExpected = {list3, clist3};

        assertArrayEquals("Can Search By Facebook", facebookExpected ,facebookTest);
        assertArrayEquals("Can Search By Twitter",  twitterExpected ,twitterTest);
        assertArrayEquals("Can Search By LinkedIn",linkedinExpected ,linkedinTest);
    }

    @Test
    public void testNullIsReturnedWhenNeeded(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);
        la.addListing(clist0);
        la.addListing(clist1);
        la.addListing(clist2);
        la.addListing(clist3);
        la.addListing(clist4);
        la.addListing(hlist0);
        la.addListing(hlist1);
        la.addListing(hlist2);

        Listing[] emailAddressTest = SearchAdvertisers.searchByEmailAddress(aa, la, "a@a.com");
        Listing[] lastNameTest = SearchAdvertisers.searchByLastName(aa, la, "Davidson");
        Listing[] businessNameTest = SearchAdvertisers.searchByBusinessName(aa, la, "Business");
        Listing[] phoneNumberTest = SearchAdvertisers.searchByPhoneNumber(aa, la, "(123)123-123");

        assertNull("Email address method returns null when needed.", emailAddressTest);
        assertNull("Last name method returns null when needed.", lastNameTest);
        assertNull("Business name method returns null when needed.", businessNameTest);
        assertNull("Phone number method returns null when needed.", phoneNumberTest);

    }
}
