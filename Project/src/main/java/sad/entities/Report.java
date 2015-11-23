package sad.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anthony on 11/17/2015.
 */
public class Report {
    private static double month = 2.628e9;
    public static Listing[] getActiveListings(ListingArray theListings){
        DateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        Date today = new Date();
        Date[] startDates = new Date[theListings.getTotalNumOfListing()];
        Date[] endDates = new Date[theListings.getTotalNumOfListing()];

        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            try {
                startDates[i] = dateFormatter.parse(theListings.getListing(i).obtainStartDate());
                endDates[i] = dateFormatter.parse(theListings.getListing(i).obtainEndDate());
            }
            catch(java.text.ParseException pe){
                System.out.println("Cause: " + pe.getCause() + "\nMessage: " + pe.getMessage());
            }
        }

        int count = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            if((startDates[i].before(today) || startDates[i].equals(today)) && endDates[i].after(today) ){
                ++count;
            }
        }

        Listing[] lists = new Listing[count];

        count = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            if((startDates[i].before(today) || startDates[i].equals(today)) && endDates[i].after(today) ){
                lists[count++] = theListings.getListing(i);
            }
        }
        return lists;
    }

    private static Advertiser[] getAdvertisersFromNMonths(AdvertiserArray theAdvertisers, final int N){
        DateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        Date today = new Date();
        Date[] startDates = new Date[theAdvertisers.totalAmountofAdvertisers()];
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            try {
                startDates[i] = dateFormatter.parse(theAdvertisers.getAdvertiser(i).obtainStartDate());
            }
            catch(java.text.ParseException pe){
                System.out.println("Cause: " + pe.getCause() + "\nMessage: " + pe.getMessage());
            }
        }
        int count = 0;
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            if((startDates[i].getTime() >= (today.getTime()-N*month))){
                ++count;
            }
        }

        Advertiser[] advertisers = new Advertiser[count];

        count = 0;
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            if((startDates[i].getTime() >= (today.getTime()-N*month))){
                advertisers[count++] = theAdvertisers.getAdvertiser(i);
            }
        }
        return advertisers;
    }

    public static Advertiser[] getAdvertisersFromLastMonth(AdvertiserArray theAdvertisers){
        return getAdvertisersFromNMonths(theAdvertisers, 1);
    }


    public static Advertiser[] getAdvertisersFromLastThreeMonths(AdvertiserArray theAdvertisers){
        return getAdvertisersFromNMonths(theAdvertisers, 3);
    }

    public static Advertiser[] getAdvertisersFromLastSixMonths(AdvertiserArray theAdvertisers){
        return getAdvertisersFromNMonths(theAdvertisers, 6);
    }

    public static Advertiser[] getAdvertisersFromLastNineMonths(AdvertiserArray theAdvertisers){
        return getAdvertisersFromNMonths(theAdvertisers, 9);
    }

    public static Advertiser[] getAdvertisersFromLastTwelveMonths(AdvertiserArray theAdvertisers){
        return getAdvertisersFromNMonths(theAdvertisers, 12);
    }
}
