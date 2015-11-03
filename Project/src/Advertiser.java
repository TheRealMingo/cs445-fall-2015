/**
 * Created by Anthony on 11/3/2015.
 */
public class Advertiser {
    private String fname;
    private String mname;
    private String lname;
    private String suffix;
    private String emailAddr;
    private String businessName;
    private String phoneNumber;
    /*Format of Social Media {"Facebook:something", "Linkedin:somethingElse", ... } */

    public void updatePhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void updateBusinessName(String businessName){
        this.businessName = businessName;
    }

    public void updateEmailAddress(String emailAddr){
        this.emailAddr = emailAddr;
    }
    public void updateFirstName(String fname){
        this.fname = fname;
    }

    public void updateMiddleName(String mname){
        this.mname = mname;
    }

    public void updateLastName(String lname){
        this.lname = lname;
    }

    public void updateSuffix(String suffix){
        this.suffix = suffix;
    }

    public String obtainPhoneNumber(){
        return phoneNumber;
    }

    public String obtainBusinessName(){
        return businessName;
    }

    public String obtainEmailAddress(){
        return emailAddr;
    }

    public String obtainFirstName(){
        return fname;
    }

    public String obtainMiddleName(){
        return mname;
    }

    public String obtainLastName(){
        return lname;
    }

    public String obtainSuffix(){
        return suffix;
    }

    public String obtainFullName(){
        return (fname + (mname != null ? " " + mname + " " : " ") + lname + (suffix != null ? " " + suffix + " " : "")).trim();
    }
}
