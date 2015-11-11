import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by Anthony on 11/9/2015.
 */
public class ListingArrayTest {
    private Advertiser adv0 = new Advertiser("Bob", "", "Bill", "Jr.", "bob@business.net", "Business.net", "(773)324-9094", "Jan 03, 2012");
    private Advertiser adv1 = new Advertiser("David", "Paul", "Jean", "", "jean@heroes.org", "Heroes.org", "(662)546-0967", "Feb 29, 2011");
    private Advertiser adv2 = new Advertiser("Carl", "Bubba", "Jones", "IV", "carl@carl.com", "Carls Cars", "(445)939-0934", "Mar 20, 2010");
    private Advertiser adv3 = new Advertiser("Antonio", "Anthony", "Antony", "II", "ant@welovepeople.org", "Every Deserves Love LLC", "(556)890-9403", "Jun 5, 2009");
    private Advertiser adv4 = new Advertiser("Own", "Lloyd", "Dawg", "", "dawg@sad.com", "SAD: Special Advertising Directory", "(654)586-9843", "Apr 6, 2008");

    private Listing list0 = new Listing(adv0, "This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private Listing list1 = new Listing(adv1, "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2017", 540.87);
    private Listing list2 = new Listing(adv2, "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);
    private Listing list3 = new Listing(adv3, "This is a place for anyone who wants to be loved", "your heart", "www.welovepeople.org", "Nov 10, 2015", "Dec 10, 2015", 100.10);
    private Listing list4 = new Listing(adv4, "This is SAD", "SAD", "www.sad.com", "Nov 15, 2000", "Dec, 19, 2060", 0.00);

    private CategoryListing clist0 = new CategoryListing(adv0, new Category("General") ,"This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private CategoryListing clist1 = new CategoryListing(adv1, new Category("Mythology"), "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2017", 540.87);
    private CategoryListing clist2 = new CategoryListing(adv2, new Category("Automobiles"), "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);
    private CategoryListing clist3 = new CategoryListing(adv3, new Category("Counseling"), "This is a place for anyone who wants to be loved", "your heart", "www.welovepeople.org", "Nov 10, 2015", "Dec 10, 2015", 100.10);
    private CategoryListing clist4 = new CategoryListing(adv4, new Category("Advertising"), "This is SAD", "SAD", "www.sad.com", "Nov 15, 2000", "Dec, 19, 2060", 0.00);

    private HomeFeaturedListing hlist0 = new HomeFeaturedListing(adv0, "This is a business\'s business", "somewhere", "www.business.net","Jan 01, 2001", "Dec 01, 2001", 300.00);
    private HomeFeaturedListing hlist1 = new HomeFeaturedListing(adv1, "This a business for heroes", "thatPlace", "www.heroes.org", "Jul 18, 2015", "Jul 18, 2017", 540.87);
    private HomeFeaturedListing hlist2 = new HomeFeaturedListing(adv2, "This is a business about cars for cars", "garage", "www.carlscars.com", "Dec 10, 2012", "Dec 10, 2013", 839.93);

    @Test
    public void testListingArrayCanCountNumberOfListing(){
        ListingArray la = new ListingArray();

        la.addListing(list0);
        la.addListing(list1);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(list4);

        assertEquals("Listing correct counts the amount of Listings there is", 5, la.getTotalNumOfListing());
    }

    @Test
    public void testListingArrayCanHaveOver100Elements(){
        ListingArray la = new ListingArray();
        for(int i = 0; i < 300; i++){
            la.addListing(new Listing());
        }
        assertEquals("Listing can have over an hundred elements", 300, la.getTotalNumOfListing());
    }

    @Test
    public void testCanObtainCertainListingFromListingArray(){
        ListingArray la = new ListingArray();
        la.addListing(list0);
        la.addListing(clist0);
        la.addListing(hlist0);
        la.addListing(clist1);
        la.addListing(list1);
        la.addListing(hlist1);
        la.addListing(hlist2);
        la.addListing(list2);
        la.addListing(list3);
        la.addListing(clist3);
        la.addListing(clist2);
        la.addListing(list4);
        la.addListing(clist4);

        Listing[] regListing = la.getRegularListings();
        Listing[] categoryListing = la.getCategoryListings();
        Listing[] homeFeaturedListing = la.getHomeFeaturedListings();

        Listing[] expectedRegListing = {list0, list1, list2, list3, list4};
        Listing[] expectedCategoryListing = {clist0, clist1, clist2, clist3, clist4};
        Listing[] expectedHomeFeaturedListing = {hlist0, hlist1, hlist2};

        boolean regListingMatch = true;
        boolean categoryListingMatch = true;
        boolean homeFeaturedListingMatch = true;

        if(expectedRegListing.length != regListing.length){
            regListingMatch = false;
        }
        else{
            for(int i = 0; i < expectedRegListing.length; i++){
                if(!expectedRegListing[i].equalTo(regListing[i]) && !regListing[i].getClass().getSimpleName().equals("Listing")){
                    regListingMatch = false;
                    break;
                }
            }
        }

        if(expectedCategoryListing.length != categoryListing.length){
            categoryListingMatch = false;
        }
        else{
            for(int i = 0; i < expectedCategoryListing.length; i++){
                if(!expectedCategoryListing[i].equalTo(categoryListing[i]) && !categoryListing[i].getClass().getSimpleName().equals("CategoryListing")){
                    categoryListingMatch = false;
                    break;
                }
            }
        }

        if(expectedHomeFeaturedListing.length != homeFeaturedListing.length){
            homeFeaturedListingMatch = false;
        }
        else{
            for(int i = 0; i < expectedHomeFeaturedListing.length; i++){
                if(!expectedHomeFeaturedListing[i].equalTo(homeFeaturedListing[i]) && homeFeaturedListing[i].getClass().getSimpleName().equals("HomeFeaturedListing")){
                    homeFeaturedListingMatch = false;
                    break;
                }
            }
        }
        assertTrue("Can obtain just regular listing", regListingMatch);
        assertTrue("Can obtain category listing", categoryListingMatch);
        assertTrue("Can obtain home feature listing", homeFeaturedListingMatch);
    }

}
