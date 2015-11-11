/**
 * Created by Anthony on 11/3/2015.
 */
public class HomeFeaturedListing extends Listing {
    public HomeFeaturedListing(){
        super();
    }

    public HomeFeaturedListing(Advertiser adv, String businessDescr, String imageLoc, String websiteLink, String startDate, String endDate, double price){
        super(adv, businessDescr, imageLoc, websiteLink, startDate, endDate, price);
    }
}
