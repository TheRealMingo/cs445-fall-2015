import org.junit.Test;

import static org.junit.Assert.*;

public class SortListingTest {
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

    private ListingArray la = new ListingArray();

    @Test
    public void testListArraySortedByAdvertiserNameForRegularListing(){
        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);

        SortListing.sortByAdvertisersLastName(la);

        Listing[] theListings = la.getAllListings();

        String[] expectedSortedLastNames = {"Antony", "Bill", "Dawg", "Jean", "Jones"};

        String[] actualSortedLastNames = {theListings[0].obtainAdvertiserLastName(), theListings[1].obtainAdvertiserLastName(), theListings[2].obtainAdvertiserLastName(), theListings[3].obtainAdvertiserLastName(), theListings[4].obtainAdvertiserLastName()};

        assertArrayEquals("Listings of same type can be sorted by Advertiser\'s Last Name", expectedSortedLastNames, actualSortedLastNames);
    }

    @Test
    public void testListArraySortedByAdvertiserNameForDifferentListingTypes(){
        la.addListing(list0);
        la.addListing(clist1);
        la.addListing(hlist2);
        la.addListing(clist3);
        la.addListing(list4);


        SortListing.sortByAdvertisersLastName(la);

        Listing[] theListings = la.getAllListings();

        String[] expectedSortedLastNames = {"Antony", "Bill", "Dawg", "Jean", "Jones"};

        String[] actualSortedLastNames = {theListings[0].obtainAdvertiserLastName(), theListings[1].obtainAdvertiserLastName(), theListings[2].obtainAdvertiserLastName(), theListings[3].obtainAdvertiserLastName(), theListings[4].obtainAdvertiserLastName()};

        assertArrayEquals("Listings of different types can be sorted by Advertiser\'s Last Name", expectedSortedLastNames, actualSortedLastNames);
    }

    @Test
    public void testListArraySortedByAdvertiserNameWhenAdvertisersHaveSameName(){
        la.addListing(list0);
        la.addListing(list1);
        la.addListing(hlist0);
        la.addListing(clist1);
        la.addListing(clist0);

        SortListing.sortByAdvertisersLastName(la);

        Listing[] theListings = la.getAllListings();

        String[] expectedSortedLastNames = {"Bill", "Bill", "Bill", "Jean", "Jean"};

        String[] actualSortedLastNames = {theListings[0].obtainAdvertiserLastName(), theListings[1].obtainAdvertiserLastName(), theListings[2].obtainAdvertiserLastName(), theListings[3].obtainAdvertiserLastName(), theListings[4].obtainAdvertiserLastName()};

        assertArrayEquals("Listings of with same names can be sorted.", expectedSortedLastNames, actualSortedLastNames);
    }

    @Test
    public void testListArraySortedByMostRecentCreatedListing(){
        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);

        SortListing.sortByMostRecentStartDate(la);

        Listing[] theListings = la.getAllListings();

        String[] expectedSortedDates = {"Nov 15, 2000", "Jan 01, 2001", "Dec 10, 2012", "Jul 18, 2015", "Nov 10, 2015"};

        String[] actualSortedLastNames = {theListings[0].obtainStartDate(), theListings[1].obtainStartDate(), theListings[2].obtainStartDate(), theListings[3].obtainStartDate(), theListings[4].obtainStartDate()};

        assertArrayEquals("Listings can be sorted by start date", expectedSortedDates, actualSortedLastNames);
    }

    @Test
    public void testListArraySortedByMostProfittable(){
        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);

        SortListing.sortByMostProfittable(la);

        Listing[] theListings = la.getAllListings();
        Listing[] expectedSorted = {list4, list3, list0, list2, list1};
        Listing[] actualSorted = {theListings[0], theListings[1], theListings[2], theListings[3], theListings[4]};

        boolean allSame = true;
        for(int i = 0; i < expectedSorted.length; i++){
            if(!expectedSorted[i].equalTo(actualSorted[i])){
                allSame = false;
                break;
            }
        }
        assertTrue("Listings can be sorted by most profittable", allSame);
    }

    @Test
    public void testListArraySortedByBusinessName(){
        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);

        SortListing.sortByBusinessName(la);

        Listing[] theListings = la.getAllListings();

        String[] expectedSortedBusinessNames = {"Business.net", "Carls Cars", "Every Deserves Love LLC", "Heroes.org", "SAD: Special Advertising Directory"};
        String[] actualSortedBusinessNames = {theListings[0].obtainAdvertiserBusinessName(),
                theListings[1].obtainAdvertiserBusinessName(),
                theListings[2].obtainAdvertiserBusinessName(),
                theListings[3].obtainAdvertiserBusinessName(),
                theListings[4].obtainAdvertiserBusinessName()};

        assertArrayEquals("Listings can be sorted by business name", expectedSortedBusinessNames, actualSortedBusinessNames);
    }
    
}
