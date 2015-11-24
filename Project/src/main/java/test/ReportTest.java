package test;

import sad.entities.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by Anthony on 11/17/2015.
 */
public class ReportTest {
    private Advertiser adv0 = new Advertiser("Bob", "", "Bill", "Jr.", "bob@business.net", "Business.net", "(773)324-9094", "Jan 03, 2012");
    private Advertiser adv1 = new Advertiser("David", "Paul", "Jean", "", "jean@heroes.org", "Heroes.org", "(662)546-0967", "Feb 29, 2011");
    private Advertiser adv2 = new Advertiser("Carl", "Bubba", "Jones", "IV", "carl@carl.com", "Carls Cars", "(445)939-0934", "Mar 20, 2010");
    private Advertiser adv3 = new Advertiser("Antonio", "Anthony", "Antony", "II", "ant@welovepeople.org", "Every Deserves Love LLC", "(556)890-9403", "Jun 5, 2009");
    private Advertiser adv4 = new Advertiser("Own", "Lloyd", "Dawg", "", "dawg@sad.com", "system.SAD: Special Advertising Directory", "(654)586-9843", "Apr 6, 2008");
    private Advertiser adv5 = new Advertiser("Advertiser", "", "1", "", "advertiser@advertiser1.com", "Advertiser1.com", "(111)111-1111", "Oct 30, 2015");
    private Advertiser adv6 = new Advertiser("Advertiser", "", "2", "", "advertiser@advertiser2.com", "Advertiser2.com", "(222)222-2222", "Sep 30, 2015");
    private Advertiser adv7 = new Advertiser("Advertiser", "", "3", "", "advertiser@advertiser3.com", "Advertiser3.com", "(333)333-3333", "Jul 30, 2015");
    private Advertiser adv8 = new Advertiser("Advertiser", "", "4", "", "advertiser@advertiser4.com", "Advertiser4.com", "(444)444-4444", "Jun 30, 2015");
    private Advertiser adv9 = new Advertiser("Advertiser", "", "5", "", "advertiser@advertiser5.com", "Advertiser5.com", "(555)555-5555", "May 30, 2015");
    private Advertiser adv10 = new Advertiser("Advertiser", "", "6", "", "advertiser@advertiser6.com", "Advertiser6.com", "(666)666-6666", "Apr 30, 2015");

    private Listing list0 = new Listing(adv0, "This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private Listing list1 = new Listing(adv1, "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2099", 540.87);
    private Listing list2 = new Listing(adv2, "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);
    private Listing list3 = new Listing(adv3, "This is a place for anyone who wants to be loved", "your heart", "www.welovepeople.org", "Nov 10, 2015", "Dec 10, 2083", 100.10);
    private Listing list4 = new Listing(adv4, "This is system.SAD", "system.SAD", "www.sad.com", "Nov 15, 2000", "Dec 19, 2060", 0.00);

    private CategoryListing clist0 = new CategoryListing(adv0, new Category("General") ,"This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private CategoryListing clist1 = new CategoryListing(adv1, new Category("Mythology"), "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2070", 540.87);
    private CategoryListing clist2 = new CategoryListing(adv2, new Category("Automobiles"), "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);
    private CategoryListing clist3 = new CategoryListing(adv3, new Category("Counseling"), "This is a place for anyone who wants to be loved", "your heart", "www.welovepeople.org", "Nov 10, 2015", "Dec 10, 2050", 100.10);
    private CategoryListing clist4 = new CategoryListing(adv4, new Category("Advertising"), "This is system.SAD", "system.SAD", "www.sad.com", "Nov 15, 2000", "Dec 19, 2060", 0.00);

    private HomeFeaturedListing hlist0 = new HomeFeaturedListing(adv0, "This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private HomeFeaturedListing hlist1 = new HomeFeaturedListing(adv1, "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2075", 540.87);
    private HomeFeaturedListing hlist2 = new HomeFeaturedListing(adv2, "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);

    private AdvertiserArray aa = new AdvertiserArray();
    private ListingArray la = new ListingArray();

    /*Get the active listings and then by sort by lisitngs type and category*/
    @Test
    public void testRetrieveAllActiveListings(){
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

        Listing[] theActiveListings = Report.getActiveListings(la);
        Listing[] expectedListings = {list1, list3, list4, clist1, clist3, clist4, hlist1};

        assertArrayEquals("Active Listings should be able to be retrieved", expectedListings, theActiveListings);
    }

    @Test
    public void testRetrieveOfCustomersInTheLastMonths(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);
        aa.addAdvertiser(adv5);
        aa.addAdvertiser(adv6);
        aa.addAdvertiser(adv7);
        aa.addAdvertiser(adv8);
        aa.addAdvertiser(adv9);
        aa.addAdvertiser(adv10);

        Advertiser[] advertisersInLastMonthExpected = {adv5};
        Advertiser[] theAdvertisersInLastMonth = Report.getAdvertisersFromLastMonth(aa);

        Advertiser[] advertisersInLast3MonthsExpected = {adv5, adv6};
        Advertiser[] theAdvertisersInLast3Months = Report.getAdvertisersFromLastThreeMonths(aa);

        Advertiser[] advertisersInLast6MonthsExpected = {adv5, adv6, adv7, adv8, adv9};
        Advertiser[] theAdvertisersInLast6Months = Report.getAdvertisersFromLastSixMonths(aa);

        Advertiser[] advertisersInLast9MonthsExpected = {adv5, adv6, adv7, adv8, adv9, adv10};
        Advertiser[] theAdvertisersInLast9Months = Report.getAdvertisersFromLastNineMonths(aa);

        Advertiser[] advertisersInLast12MonthsExpected = {adv5, adv6, adv7, adv8, adv9, adv10};
        Advertiser[] theAdvertisersInLast12Months = Report.getAdvertisersFromLastTwelveMonths(aa);

        assertArrayEquals("Advertisers in last month should be retrived", advertisersInLastMonthExpected, theAdvertisersInLastMonth);
        assertArrayEquals("Advertisers in three months should be retrived", advertisersInLast3MonthsExpected, theAdvertisersInLast3Months);
        assertArrayEquals("Advertisers in six months should be retrived",advertisersInLast6MonthsExpected , theAdvertisersInLast6Months);
        assertArrayEquals("Advertisers in nine months should be retrived", advertisersInLast9MonthsExpected, theAdvertisersInLast9Months);
        assertArrayEquals("Advertisers in twelve months should be retrived", advertisersInLast12MonthsExpected, theAdvertisersInLast12Months);
    }
}
