package sad.entities;

/**
 * Created by Anthony on 11/22/2015.
 */
public class SearchAdvertisers {
    public static Advertiser searchByID(AdvertiserArray theAdvertiserArray, int id){
        for(int i = 0; i < theAdvertiserArray.totalAmountofAdvertisers(); i++){
            if(theAdvertiserArray.getAdvertiser(i).getId() == id){
                return theAdvertiserArray.getAdvertiser(i);
            }
        }
        return null;
    }
}
