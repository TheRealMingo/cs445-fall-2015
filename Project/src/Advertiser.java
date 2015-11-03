import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
    private String startDate;
    private ArrayList<String> socialMedia = new ArrayList<String>();
    private ArrayList<Listing> theListings = new ArrayList<Listing>();
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
    public void updateSocialMedia(String outlet, String content){
        int i = 0;
        for(i = 0; i < socialMedia.size(); i++){
            String theOutlet = socialMedia.get(i).split(":")[0];
            if(theOutlet.equals(outlet)){
                socialMedia.set(i, outlet + ":" + content);
            }
        }
    }
    public void updateStartDate(String startDate){
        this.startDate = startDate;  //have to validate format
    }
    public void updateStartDate(GregorianCalendar startDate){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        date.setCalendar(startDate);
        this.startDate = date.format(startDate.getTimeInMillis());
    }
    public void updateStartDate(int year, int month, int day){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        GregorianCalendar calenderDate = new GregorianCalendar(year, month-1, day);
        date.setCalendar(calenderDate);
        this.startDate = date.format(calenderDate.getTimeInMillis());
    }
    public void giveListing(Listing listing){
        theListings.add(listing);
    }
    public void addSocialMedia(String outlet, String content){
       socialMedia.add(outlet + ":" + content);
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
    public String[] obtainAllSocialMedia(){
        String[] theSocialMedia = new String[socialMedia.size()];
        for(int i = 0; i < theSocialMedia.length; i++){
            theSocialMedia[i] = socialMedia.get(i);
        }
        return theSocialMedia;
    }
    public Listing[] obtainListings(){
        Listing[] theListingsArray = new Listing[theListings.size()];
        for(int i = 0; i < theListingsArray.length; i++) {
            theListingsArray[i] = theListings.get(i);
        }
        return theListingsArray;
    }
    public String obtainStartDate(){
        return startDate;
    }

}
