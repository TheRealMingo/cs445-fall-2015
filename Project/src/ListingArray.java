import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by Anthony on 11/9/2015.
 */
public class ListingArray {
    private Listing[] theListing = new Listing[100];
    private int num_of_listing = 0;
    private int theListingIndex = 0;

    private void increaseCapacity(){
        Listing[] temp = new Listing[num_of_listing + 100];
        for(int i = 0; i < num_of_listing; i++){
            temp[i] = theListing[i];
        }
        theListing = temp;
    }

    public void addListing(Listing listing){
        if(theListingIndex == num_of_listing) {
            increaseCapacity();
        }
        theListing[theListingIndex++] = listing; //might get rid of new Listing _ check if necessary
        ++num_of_listing;
    }

    public int getTotalNumOfListing(){
        return num_of_listing;
    }

    public Listing[] getRegularListings(){
        int count = 0;
        for(int i = 0; i < theListingIndex; i++){
            if (theListing[i].getClass().getSimpleName().equals("Listing")) {
                count++;
            }
        }

        Listing[] regularListing = new Listing[count];
        count = 0;
        for(int i = 0; i < theListingIndex; i++) {
            if (theListing[i].getClass().getSimpleName().equals("Listing")) {
                regularListing[count++] = theListing[i];
            }
        }
        return regularListing;
    }

    public Listing[] getCategoryListings(){
        int count = 0;
        for(int i = 0; i < theListingIndex; i++){
            if(theListing[i].getClass().getSimpleName().equals("CategoryListing")){
                count++;
            }
        }
        Listing[] categoryListing = new Listing[count];
        count = 0;
        for(int i = 0; i < theListingIndex; i++) {
            if (theListing[i].getClass().getSimpleName().equals("CategoryListing")) {
                categoryListing[count++] = theListing[i];
            }
        }
        return categoryListing;
    }

    public Listing[] getHomeFeaturedListings() {
        int count = 0;
        for(int i = 0; i < theListingIndex; i++){
            if(theListing[i].getClass().getSimpleName().equals("HomeFeaturedListing")){
                count++;
            }
        }
        Listing[] homeFeaturedListing = new Listing[count];
        count = 0;
        for (int i = 0; i < theListingIndex; i++) {
            if (theListing[i].getClass().getSimpleName().equals("HomeFeaturedListing")) {
                homeFeaturedListing[count++] = theListing[i];
            }
        }
        return homeFeaturedListing;
    }
}
