package sad.entities;

/**
 * Created by Anthony on 11/15/2015.
 */
public class SearchListings {
    public static Listing[] searchByAdvertisersEmailAddress(AdvertiserArray theAdvertisers, ListingArray theListings, String emailAddress){
        Advertiser theAdvertiser = new Advertiser();
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            if(theAdvertisers.getAdvertiser(i).obtainEmailAddress().equals(emailAddress)){
                theAdvertiser = theAdvertisers.getAdvertiser(i);
                break;
            }
        }

        if(theAdvertiser.equalsTo(new Advertiser())){
            return null;
        }

        int num_of_listings_for_adv = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                ++num_of_listings_for_adv;
            }
        }

        Listing[] listings = new Listing[num_of_listings_for_adv];
        int listingIndex = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                listings[listingIndex++] = theListings.getListing(i);
            }
        }
        return listings;
    }

    public static Listing[] searchByAdvertisersLastName(AdvertiserArray theAdvertisers, ListingArray theListings, String lastname){
        Advertiser theAdvertiser = new Advertiser();
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            if(theAdvertisers.getAdvertiser(i).obtainLastName().equals(lastname)){
                theAdvertiser = theAdvertisers.getAdvertiser(i);
                break;
            }
        }

        if(theAdvertiser.equalsTo(new Advertiser())){
            return null;
        }

        int num_of_listings_for_adv = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                ++num_of_listings_for_adv;
            }
        }

        Listing[] listings = new Listing[num_of_listings_for_adv];
        int listingIndex = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                listings[listingIndex++] = theListings.getListing(i);
            }
        }
        return listings;
    }

    public static Listing[] searchByAdvertisersBusinessName(AdvertiserArray theAdvertisers, ListingArray theListings, String businessName){
        Advertiser theAdvertiser = new Advertiser();
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            if(theAdvertisers.getAdvertiser(i).obtainBusinessName().equals(businessName)){
                theAdvertiser = theAdvertisers.getAdvertiser(i);
                break;
            }
        }

        if(theAdvertiser.equalsTo(new Advertiser())){
            return null;
        }

        int num_of_listings_for_adv = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                ++num_of_listings_for_adv;
            }
        }

        Listing[] listings = new Listing[num_of_listings_for_adv];
        int listingIndex = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                listings[listingIndex++] = theListings.getListing(i);
            }
        }
        return listings;
    }

    public static Listing[] searchByAdvertisersPhoneNumber(AdvertiserArray theAdvertisers, ListingArray theListings, String phoneNumber){
        Advertiser theAdvertiser = new Advertiser();
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            if(theAdvertisers.getAdvertiser(i).obtainPhoneNumber().equals(phoneNumber)){
                theAdvertiser = theAdvertisers.getAdvertiser(i);
                break;
            }
        }

        if(theAdvertiser.equalsTo(new Advertiser())){
            return null;
        }

        int num_of_listings_for_adv = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                ++num_of_listings_for_adv;
            }
        }

        Listing[] listings = new Listing[num_of_listings_for_adv];
        int listingIndex = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                listings[listingIndex++] = theListings.getListing(i);
            }
        }
        return listings;
    }

    public static Listing[] searchByAdvertisersSocialMedia(AdvertiserArray theAdvertisers, ListingArray theListings, String outlet, String content){
        Advertiser theAdvertiser = new Advertiser();
        for(int i = 0; i < theAdvertisers.totalAmountofAdvertisers(); i++){
            String socialMediaContent = theAdvertisers.getAdvertiser(i).obtainSocialMediaContent(outlet);
            if(socialMediaContent.equals(content) ){
                theAdvertiser = theAdvertisers.getAdvertiser(i);
                break;
            }
        }

        if(theAdvertiser.equalsTo(new Advertiser())){
            return null;
        }

        int num_of_listings_for_adv = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                ++num_of_listings_for_adv;
            }
        }

        Listing[] listings = new Listing[num_of_listings_for_adv];
        int listingIndex = 0;
        for(int i = 0; i < theListings.getTotalNumOfListing(); i++){
            Advertiser currentAdv = theListings.getListing(i).obtainAdvertiser();
            if(currentAdv.equalsTo(theAdvertiser)){
                listings[listingIndex++] = theListings.getListing(i);
            }
        }
        return listings;
    }

}
