/**
 * Created by Anthony on 11/9/2015.
 */
public class AdvertiserArray {
    private Advertiser[] advertisers = new Advertiser[100];
    private int advertiserIndex = 0;
    private int num_of_adv = 0;

    public void sortAdvertiserByLastName(){
        String currLastName;
        for(int i = 0; i < num_of_adv; i++){
            currLastName = advertisers[i].obtainLastName();
            for(int j = i; j < num_of_adv; j++){
                if(currLastName.compareTo(advertisers[j].obtainLastName()) > 0){
                    Advertiser temp = advertisers[i];
                    advertisers[i] = advertisers[j];
                    advertisers[j] = temp;
                }
            }
        }
    }

    private void increaseCapacity(){
       Advertiser[] temp = new Advertiser[num_of_adv + 100];
        for(int i = 0; i < num_of_adv; i++){
            temp[i] = advertisers[i];
        }
        advertisers = temp;
    }

    public void addAdvertiser(Advertiser adv){
        if(num_of_adv == advertisers.length){
            increaseCapacity();
        }
        advertisers[advertiserIndex++] = adv;
        ++num_of_adv;
        sortAdvertiserByLastName();
    }

    public int totalAmountofAdvertisers(){
        return num_of_adv;
    }

    public Advertiser[] obtainAdvertisers(){
        Advertiser[] theAdvertisers = new Advertiser[num_of_adv];
        for(int i = 0; i < num_of_adv; i++){
            theAdvertisers[i] = new Advertiser(advertisers[i]);
        }
        return theAdvertisers;
    }

}
