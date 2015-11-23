package test;

import sad.entities.Advertiser;
import sad.entities.AdvertiserArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by Anthony on 11/9/2015.
 */
public class AdvertisersArrayTest {
    private Advertiser adv0 = new Advertiser("Bob", "", "Bill", "Jr.", "bob@business.net", "Business.net", "(773)324-9094", "Jan 03, 2012");
    private Advertiser adv1 = new Advertiser("David", "Paul", "Jean", "", "jean@heroes.org", "Heroes.org", "(662)546-0967", "Feb 29, 2011");
    private Advertiser adv2 = new Advertiser("Carl", "Bubba", "Jones", "IV", "carl@carl.com", "Carls Cars", "(445)939-0934", "Mar 20, 2010");
    private Advertiser adv3 = new Advertiser("Antonio", "Anthony", "Antony", "II", "ant@welovepeople.org", "Every Deserves Love LLC", "(556)890-9403", "Jun 5, 2009");
    private Advertiser adv4 = new Advertiser("Own", "Lloyd", "Dawg", "", "dawg@sad.com", "system.SAD: Special Advertising Directory", "(654)586-9843", "Apr 6, 2008");

    @Test
    public void testAdvertiserArrayHasAdvertisers(){
        AdvertiserArray advertisers = new AdvertiserArray();

        advertisers.addAdvertiser(adv0);
        advertisers.addAdvertiser(adv1);
        advertisers.addAdvertiser(adv2);
        advertisers.addAdvertiser(adv3);
        advertisers.addAdvertiser(adv4);

        assertEquals("main.entities.Advertiser has more than 0 advertiser", 5, advertisers.totalAmountofAdvertisers());
    }

    @Test
    public void testAdvertisersAreAddedInAlphabeticalOrderByLastName(){
        AdvertiserArray advertisers = new AdvertiserArray();

        advertisers.addAdvertiser(adv0);
        advertisers.addAdvertiser(adv1);
        advertisers.addAdvertiser(adv2);
        advertisers.addAdvertiser(adv3);
        advertisers.addAdvertiser(adv4);

        String[] sortedByLastName = new String[]{"Antony", "Bill", "Dawg", "Jean", "Jones"};

        Advertiser[] advs = advertisers.obtainAdvertisers();
        String[] result = new String[]{advs[0].obtainLastName(), advs[1].obtainLastName(), advs[2].obtainLastName(), advs[3].obtainLastName(), advs[4].obtainLastName()};
        assertArrayEquals("Advertisers are added in alphabetical order by last name", sortedByLastName, result);
    }

    @Test
    public void testAdvertiserArrayCanHaveOver100Elements(){
        AdvertiserArray advertiserArray = new AdvertiserArray();

        for(int i = 0; i < 300; i++){
            advertiserArray.addAdvertiser(new Advertiser());
        }

        assertEquals("main.entities.Advertiser has over 100 elements", 300, advertiserArray.totalAmountofAdvertisers());
    }


}
