import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Anthony on 11/3/2015.
 */
public class AdvertiserTest {
    @Test
    public void testAdvertiserCanHaveFirstNameMiddleNameAndLastName(){
        Advertiser adv = new Advertiser();
        adv.updateFirstName("King");
        adv.updateMiddleName("James");
        adv.updateLastName("The");
        adv.updateSuffix("Fourth");
        String firstname = adv.obtainFirstName();
        String middlename = adv.obtainMiddleName();
        String lastname = adv.obtainLastName();
        String suffix = adv.obtainSuffix();
        String fullname = firstname + " "  + middlename + " " + lastname + " " + suffix;
        assertEquals("Advertiser has first, middle, last name, and suffix", "King James The Fourth", fullname);
        assertEquals("Advertiser has full name", "King James The Fourth", adv.obtainFullName());
    }

    @Test
    public void testAdvertiserCanOnlyHaveFirstAndLastName(){
        Advertiser adv = new Advertiser();
        adv.updateFirstName("King");
        adv.updateLastName("James");
        String firstname = adv.obtainFirstName();
        String lastname = adv.obtainLastName();
        String fullname = firstname + " " + lastname;
        assertEquals("Advertiser has first and last name", "King James", fullname);
        assertEquals("Advertiser has full name with just first and last name", "King James", adv.obtainFullName());
    }

    @Test
    public void testAdvertiserCanHaveAnEmailAddress(){
        Advertiser adv = new Advertiser();
        adv.updateEmailAddress("email@email.com");
        String email = adv.obtainEmailAddress();
        assertEquals("Advertiser has an email address", "email@email.com", email);
    }

    @Test
    public void testAdvertiserCanHaveABusinessName(){
        Advertiser adv = new Advertiser();
        adv.updateBusinessName("Personal Business");
        String business = adv.obtainBusinessName();
        assertEquals("Advertiser has a business", "Personal Business", business);
    }

    @Test
    public void testAdvertiserCanHaveAPhoneNumber(){
        Advertiser adv = new Advertiser();
        adv.updatePhoneNumber("(123)456-7890");
        String phoneNumber = adv.obtainPhoneNumber();
        assertEquals("Advertiser has a phone number", "(123)456-7890", phoneNumber);
    }
}
