package sad.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anthony on 11/13/2015.
 */
public class SortListing {
    public static void sortByAdvertisersLastName(ListingArray listings) {
        String currLastName;
        for (int i = 0; i < listings.getTotalNumOfListing(); i++) {
            currLastName = listings.getListing(i).obtainAdvertiserLastName();
            for (int j = 0; j < listings.getTotalNumOfListing(); j++) {
                if (currLastName.compareTo(listings.getListing(j).obtainAdvertiserLastName()) < 0) {
                    Listing temp = listings.getListing(i);
                    listings.replace(i, listings.getListing(j));
                    listings.replace(j, temp);
                }
            }

        }
    }
    public static void sortByBusinessName(ListingArray listings){
        String currBusiness;
        for (int i = 0; i < listings.getTotalNumOfListing(); i++) {
            currBusiness = listings.getListing(i).obtainAdvertiserBusinessName();
            for (int j = 0; j < listings.getTotalNumOfListing(); j++) {
                if (currBusiness.compareTo(listings.getListing(j).obtainAdvertiserBusinessName()) < 0) {
                    Listing temp = listings.getListing(i);
                    listings.replace(i, listings.getListing(j));
                    listings.replace(j, temp);
                }
            }

        }
    }
    public static void sortByMostRecentStartDate(ListingArray listings){
        DateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        Date[] dates = new Date[listings.getTotalNumOfListing()];

        for(int i = 0; i < listings.getTotalNumOfListing(); i++){
            try {
                dates[i] = dateFormatter.parse(listings.getListing(i).obtainStartDate());
            }
            catch(java.text.ParseException pe){
                System.out.println("Cause: " + pe.getCause() + "\nMessage: " + pe.getMessage());
            }
        }

        Date currentDate;
        for (int i = 0; i < listings.getTotalNumOfListing(); i++) {
            currentDate = dates[i];
            for (int j = 0; j < listings.getTotalNumOfListing(); j++) {
                if (currentDate.compareTo(dates[j]) < 0) {
                    //The dates and objects are in the same location respectively so sorting them together works
                    Date tempDate = dates[i];
                    dates[i] = dates[j];
                    dates[j] = tempDate;

                    Listing temp = listings.getListing(i);
                    listings.replace(i, listings.getListing(j));
                    listings.replace(j, temp);
                }
            }
        }
    }
    public static void sortByMostProfittable(ListingArray listings){
        DateFormat dateFormatter = new SimpleDateFormat("MMM dd,yyyy");
        double[] profits = new double[listings.getTotalNumOfListing()];
        for(int i = 0; i < listings.getTotalNumOfListing(); i++){
            try {
                Date dateStart = dateFormatter.parse(listings.getListing(i).obtainStartDate());
                Date dateEnd = dateFormatter.parse(listings.getListing(i).obtainEndDate());
                profits[i] = (dateEnd.getTime() - dateStart.getTime()) * listings.getListing(i).obtainPrice();
            }
            catch(java.text.ParseException pe){
                System.out.println("Cause: " + pe.getCause() + "\nMessage: " + pe.getMessage());
            }
        }

        double profit;
        for (int i = 0; i < listings.getTotalNumOfListing(); i++) {
            profit = profits[i];
            for (int j = 0; j < listings.getTotalNumOfListing(); j++) {
                if (profit < profits[j]) {
                    //The dates and objects are in the same location respectively so sorting them together works
                    double tempProfit = profits[i];
                    profits[i] = profits[j];
                    profits[j] = tempProfit;

                    Listing temp = listings.getListing(i);
                    listings.replace(i, listings.getListing(j));
                    listings.replace(j, temp);
                }
            }
        }
    }
}

