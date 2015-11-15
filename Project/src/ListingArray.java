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

    public CategoryListing[] getCategoryListings(){
        int count = 0;
        for(int i = 0; i < theListingIndex; i++){
            if(theListing[i].getClass().getSimpleName().equals("CategoryListing")){
                count++;
            }
        }
        CategoryListing[] categoryListing = new CategoryListing[count];
        count = 0;
        for(int i = 0; i < theListingIndex; i++) {
            if (theListing[i].getClass().getSimpleName().equals("CategoryListing")) {
                categoryListing[count++] = (CategoryListing)theListing[i];
            }
        }
        return categoryListing;
    }

    public HomeFeaturedListing[] getHomeFeaturedListings() {
        int count = 0;
        for(int i = 0; i < theListingIndex; i++){
            if(theListing[i].getClass().getSimpleName().equals("HomeFeaturedListing")){
                count++;
            }
        }
        HomeFeaturedListing[] homeFeaturedListing = new HomeFeaturedListing[count];
        count = 0;
        for (int i = 0; i < theListingIndex; i++) {
            if (theListing[i].getClass().getSimpleName().equals("HomeFeaturedListing")) {
                homeFeaturedListing[count++] = (HomeFeaturedListing)theListing[i];
            }
        }
        return homeFeaturedListing;
    }

    public Listing getListing(int pos){
            if(pos >= 0 && pos <= num_of_listing){
                return theListing[pos];
            }
            else{
                return null;
            }
    }

    public void replace(int pos, Listing listing){
        if(pos >= 0 && pos <= num_of_listing) {
            theListing[pos] = listing;
        }
    }

    public Listing[] getAllListings(){
        Listing[] temp = new Listing[theListingIndex];
        String className = "";
        for(int i = 0; i < theListingIndex; i++){
            className = theListing[i].getClass().getSimpleName();
            switch(className) {
                case "CategoryListing":
                    temp[i] = (CategoryListing)new CategoryListing((CategoryListing)theListing[i]);
                    break;

                case "HomeFeaturedListing":
                    temp[i] = (HomeFeaturedListing)new HomeFeaturedListing((HomeFeaturedListing)theListing[i]);
                    break;

                case "Listing":
                    temp[i] = new Listing(theListing[i]);
                    break;
            }
        }
        return temp;
    }
}
