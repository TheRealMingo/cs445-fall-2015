package sad.entities;

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
