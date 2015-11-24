package test;

import sad.entities.Advertiser;
import sad.entities.AdvertiserArray;
import sad.entities.SearchAdvertisers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchAdvertisersTest {
    private Advertiser adv0 = new Advertiser("Bob", "", "Bill", "Jr.", "bob@business.net", "Business.net", "(773)324-9094", "Jan 03, 2012");
    private Advertiser adv1 = new Advertiser("David", "Paul", "Jean", "", "jean@heroes.org", "Heroes.org", "(662)546-0967", "Feb 29, 2011");
    private Advertiser adv2 = new Advertiser("Carl", "Bubba", "Jones", "IV", "carl@carl.com", "Carls Cars", "(445)939-0934", "Mar 20, 2010");
    private Advertiser adv3 = new Advertiser("Antonio", "Anthony", "Antony", "II", "ant@welovepeople.org", "Every Deserves Love LLC", "(556)890-9403", "Jun 5, 2009");
    private Advertiser adv4 = new Advertiser("Own", "Lloyd", "Dawg", "", "dawg@sad.com", "system.SAD: Special Advertising Directory", "(654)586-9843", "Apr 6, 2008");

    private AdvertiserArray aa = new AdvertiserArray();
    @Test
    public void canSearchByAdvertisersID(){
        aa.addAdvertiser(adv0);
        aa.addAdvertiser(adv1);
        aa.addAdvertiser(adv2);
        aa.addAdvertiser(adv3);
        aa.addAdvertiser(adv4);

        Advertiser expected = adv2;
        Advertiser actual = SearchAdvertisers.searchByID(aa, adv2.getId());

        assertEquals("Can search advertisers by id", expected, actual);
    }
}
