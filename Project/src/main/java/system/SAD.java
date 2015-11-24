package system;

import sad.entities.*;
import sad.persistence.AdvertiserWriter;

import java.util.ArrayList;

/**
 * Created by Anthony on 11/22/2015.
 */
public class SAD {
    private static AdvertiserArray advertisers = new AdvertiserArray();
    private static CategoryArray categories = new CategoryArray();
    private static ListingArray listings = new ListingArray();
    private static AdvertiserWriter advertiserwriter = new AdvertiserWriter();
    private static SAD sad = new SAD();

    private SAD(){}

    public static SAD getInstance(){
        return sad;
    }

    /**------------------------------------------------------------------------------------
     * ------------------------------------------------------------------------------------
     * ----------------------------- CATEGORY SECTION ------------------------------------
     * ------------------------------------------------------------------------------------
     * -------------------------------------------------------------------------------------
     * **/
    public static void addCategory(Category c){
        categories.addCategory(c);
    }
    public static void deleteCategory(Category c){
       for(int i = 0; i < categories.getTotalNumOfCategories(); i++){
           if(categories.getCategory(i).equalsTo(c)){
               categories.removeCategoryAtPos(i);
           }
       }
    }
    public static void deleteCategory(String c){
        int deletePos = -1;

        Category currCategory = new Category();
        for(int i = 0; i < categories.getTotalNumOfCategories(); i++){
            currCategory = categories.getCategory(i);
            if(currCategory.getCategoryGenre().equals(c)){
                deletePos = i;
                break;
            }
        }

        if(deletePos != -1){
            categories.removeCategoryAtPos(deletePos);
        }
    }
    public static Category[] getCategories(){
        return categories.obtainAllCategories();
    }

    /**------------------------------------------------------------------------------------
     * ------------------------------------------------------------------------------------
     * ------------------------------- LISTING SECTION ------------------------------------
     * ------------------------------------------------------------------------------------
     * -------------------------------------------------------------------------------------
     * **/

    public static Listing[] getListings(){
        return listings.getAllListings();
    }

    public static void addListing(Listing l){
       listings.addListing(l);
    }

    public static void addListing(HomeFeaturedListing hfl){listings.addListing(hfl);}

    public static void addListing(CategoryListing cl){
        Category currCategory;
        for(int i = 0; i < categories.getTotalNumOfCategories(); i++){
            currCategory = categories.getCategory(i);
            if(currCategory.getCategoryGenre().equals(cl.getCategory().getCategoryGenre())){
                listings.addListing(cl);
                break;
            }
        }
    }


    public static CategoryListing[] getCategoryListings() {
        return listings.getCategoryListings();
    }

    public static CategoryListing[] getCategoryListingsOf(String category) {
        ListingArray theListings = new ListingArray();
        CategoryListing currCategoryListing;
        for(int i = 0; i < listings.getCategoryListings().length; i++){
            currCategoryListing = (CategoryListing)listings.getListing(i);
            if(currCategoryListing.getCategoryGenre().equals(category)){
                theListings.addListing(currCategoryListing);
            }
        }
        return theListings.getCategoryListings();
    }

    public static HomeFeaturedListing[] getHomeFeaturedListings() {
        return listings.getHomeFeaturedListings();
    }

    public static void addListingWithAdv(int id, Listing listing) {
        //TODO: Make sure id exists before adding listing
        Advertiser theAdv = SearchAdvertisers.searchByID(advertisers, id);
        listing.setAdvertiser(theAdv);
        listings.addListing(listing);
    }

    public static void sortListingsByBusinessName() {
        SortListing.sortByBusinessName(listings);
    }

    public static void sortListingsByStartDate() {
        SortListing.sortByMostRecentStartDate(listings);
    }

    public static void sortListingsByMostProfitable() {
        SortListing.sortByMostProfittable(listings);
    }

    public static void sortListingsByLastName() {
        SortListing.sortByAdvertisersLastName(listings);
    }
    public static CategoryListing[] getListingsOfCategoryAndSubcategories(String[] catNsubcat) {
        Category[] theCategories = categories.obtainAllCategories();
        CategoryListing[] categoryListings = getCategoryListings();

        for(int i = 0; i < catNsubcat.length; i++){
            String currCategory = catNsubcat[i];
            int count = 0;
            CategoryListing[] temp = new CategoryListing[categoryListings.length];
            for(int j = 0; j < categoryListings.length; j++){
                Category theCategory = categoryListings[j].getCategory();
                if(i > 0){
                    for(int k = 0; k < i; k++){
                        if(theCategory.getSubcat().size() > 0) {
                            theCategory = theCategory.getSubcat().get(i - 1);
                        }
                    }
                }
                if(categoryListings[j] != null && theCategory.getCategoryGenre().equals(currCategory)){
                    temp[count++] = categoryListings[j];
                }
            }
            categoryListings = temp;
        }
        int totalNotNullInCategoryListings = 0;
        for(int i = 0; i < categoryListings.length; i++){
            if(categoryListings[i] != null)
                totalNotNullInCategoryListings++;
        }

        CategoryListing[] temp = new CategoryListing[totalNotNullInCategoryListings];
        for(int i = 0; i < temp.length; i++){
            temp[i] = categoryListings[i];
        }
        categoryListings = temp;
        return categoryListings;
    }
    /**------------------------------------------------------------------------------------
     * ------------------------------------------------------------------------------------
     * ------------------------------- ADVERTISER SECTION ---------------------------------
     * ------------------------------------------------------------------------------------
     * ------------------------------------------------------------------------------------
     * **/

    public static Advertiser[] getAdvertisers() {
        return advertisers.obtainAdvertisers();
    }

    public static void addAdvertiser(Advertiser advertiser) {

        advertisers.addAdvertiser(advertiser);
        advertiserwriter.writeAdvertiser(advertiser);
    }

    public static Listing[] getListingsByAdvertisersEmailAddress(String emailaddress) {
        return SearchListings.searchByAdvertisersEmailAddress(advertisers, listings, emailaddress);
    }

    public static Listing[] getListingsByAdvertisersID(int id) {
        return SearchListings.searchByAdvertisersID(advertisers, listings, id);
    }

    public static Listing[] getListingsByAdvertisersLastName(String lastname) {
        return SearchListings.searchByAdvertisersLastName(advertisers, listings, lastname);
    }

    public static Listing[] getListingsByAdvertisersPhoneNumber(String phonenumber) {
        return SearchListings.searchByAdvertisersPhoneNumber(advertisers, listings, phonenumber);
    }

    public static Listing[] getListingsByAdvertisersSocialMedia(String outlet, String content) {
        return SearchListings.searchByAdvertisersSocialMedia(advertisers, listings, outlet, content);
    }

    public static Advertiser getAdvertiserByID(int id) {
        return SearchAdvertisers.searchByID(advertisers, id);
    }

    /**------------------------------------------------------------------------------------
     * ------------------------------------------------------------------------------------
     * ----------------------------------- REPORT SECTION ---------------------------------
     * ------------------------------------------------------------------------------------
     * ------------------------------------------------------------------------------------
     * **/
    public static String reportCustomersLastMonth() {
        Advertiser[] advertisersArray = Report.getAdvertisersFromLastMonth(advertisers);
        return (advertisersArray.length + " new customers were added last month.");
    }

    public static String reportCustomersLast3Months() {
        Advertiser[] advertisersArray  = Report.getAdvertisersFromLastThreeMonths(advertisers);
        return (advertisersArray.length + " new customers were added in the last 3 months.");
    }

    public static String reportCustomersLast6Months() {
        Advertiser[] advertisersArray  = Report.getAdvertisersFromLastSixMonths(advertisers);
        return (advertisersArray.length + " new customers were added in the last 6 months.");
    }

    public static String reportCustomersLast9Months() {
        Advertiser[] advertisersArray  = Report.getAdvertisersFromLastNineMonths(advertisers);
        return (advertisersArray.length + " new customers were added in the last 9 months.");
    }

    public static String reportCustomersLast12Months() {
        Advertiser[] advertisersArray  = Report.getAdvertisersFromLastTwelveMonths(advertisers);
        return (advertisersArray.length + " new customers were added in the last 12 months.");
    }

    public static String reportActiveListings() {
        Listing[] listingsArray = Report.getActiveListings(listings);
        int amount_of_regular_listings = 0;
        int amount_of_homefeatured_listings = 0;
        int amount_of_category_listings = 0;
        String type;
        for(int i = 0; i < listingsArray.length; i++){
            type = listingsArray[i].getClass().getSimpleName();
            switch (type){
                case "Listing":
                    amount_of_regular_listings++;
                    break;

                case "HomeFeaturedListing":
                    amount_of_homefeatured_listings++;
                    break;

                case "CategoryListing":
                    amount_of_category_listings++;
                    break;
            }
        }
        //TODO: Count the number of different categories for the category listings and add it to the string that is being returned
        return amount_of_regular_listings + " active regular listings\n" + amount_of_homefeatured_listings + " active home-featured listings\n" + amount_of_category_listings + " active category listings\n";
    }
}
