package sad.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Anthony on 11/3/2015.
 */

@XmlRootElement
public class Advertiser {
    private String fname;
    private String mname;
    private String lname;
    private String suffix;
    private String emailAddr;
    private String businessName;
    private String phoneNumber;
    private String startDate;
    private static int num_of_adv = 0;
    private boolean idSet = false;
    private int id;
    private ArrayList<String> socialMedia = new ArrayList<String>();
    private ArrayList<Listing> theListings = new ArrayList<Listing>();
    /*Format of Social Media {"Facebook:something", "Linkedin:somethingElse", ... } */
    public Advertiser(){
        fname = "";
        mname = "";
        lname = "";
        suffix = "";
        emailAddr = "";
        businessName = "";
        phoneNumber = "";
        startDate = "";
        id = num_of_adv++;
        idSet = true;
    }
    public Advertiser(Advertiser adv){
        this.fname = adv.getFname();
        this.mname = adv.getMname();
        this.lname = adv.getLname();
        this.suffix = adv.getSuffix();
        this.emailAddr = adv.getEmailAddr();
        this.businessName = adv.getBusinessName();
        this.phoneNumber = adv.getPhoneNumber();
        this.startDate = adv.getStartDate();
        String[] socialMediaArray = adv.getAllSocialMedia().clone();
        String[] socialMediaCopy = new String[socialMediaArray.length];
        for(int i = 0; i < socialMediaArray.length; i++){
            socialMediaCopy[i] = new String(socialMediaArray[i]);
            socialMedia.add(socialMediaCopy[i]);
        }
        Listing[] theListingArray = adv.getListings().clone();
        Listing[] theListingCopy = new Listing[theListingArray.length];

        for(int i = 0; i < theListingArray.length; i++){
            theListingCopy[i] = new Listing(theListingArray[i]);
            theListings.add(theListingCopy[i]);
        }
        id = num_of_adv++;
        idSet = true;
    }
    public Advertiser(String fname, String mname, String lname, String suffix, String emailAddr, String businessName, String phoneNumber, String startDate){
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.suffix = suffix;
        this.emailAddr = emailAddr;
        this.businessName = businessName;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        id = num_of_adv++;
        idSet = true;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setBusinessName(String businessName){
        this.businessName = businessName;
    }
    public void setEmailAddr(String emailAddr){
        this.emailAddr = emailAddr;
    }
    public void setFname(String fname){
        this.fname = fname;
    }
    public void setMname(String mname){
        this.mname = mname;
    }
    public void setLname(String lname){
        this.lname = lname;
    }
    public void setSuffix(String suffix){
        this.suffix = suffix;
    }
    public void setId(int id){
        if(!idSet){
            this.id = id;
        }
    }
    public void setSocialMedia(String outlet, String content){
        int i = 0;
        for(i = 0; i < socialMedia.size(); i++){
            String theOutlet = socialMedia.get(i).split(":")[0];
            if(theOutlet.equals(outlet)){
                socialMedia.set(i, outlet + ":" + content);
            }
        }
    }
    public void setStartDate(String startDate){
        this.startDate = startDate;  //have to validate format
    }
    public void setStartDate(GregorianCalendar startDate){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        date.setCalendar(startDate);
        this.startDate = date.format(startDate.getTimeInMillis());
    }
    public void setStartDate(int year, int month, int day){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        GregorianCalendar calenderDate = new GregorianCalendar(year, month-1, day);
        date.setCalendar(calenderDate);
        this.startDate = date.format(calenderDate.getTimeInMillis());
    }
    public void setSocialMedia(ArrayList<String> socialMedia){this.socialMedia = socialMedia;}
    public void giveListing(Listing listing){
        theListings.add(listing);
    }
    public void giveListing(CategoryListing listing){
        theListings.add(listing);
    }
    public void giveListing(HomeFeaturedListing listing){
        theListings.add(listing);
    }
    public void addSocialMedia(String outlet, String content){
       socialMedia.add(outlet + ":" + content);
    }

    public int getId(){
        return  id;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getBusinessName(){
        return businessName;
    }
    public String getEmailAddr(){
        return emailAddr;
    }
    public String getFname(){
        return fname;
    }
    public String getMname(){
        return mname;
    }
    public String getLname(){
        return lname;
    }
    public String getSuffix(){
        return suffix;
    }
    public String getFullName(){
        return (fname + (mname != "" ? " " + mname + " " : " ") + lname + (suffix != "" ? " " + suffix + " " : "")).trim();
    }
    public ArrayList<String> getSocialMedia(){return socialMedia;}
    public String[] getAllSocialMedia(){
        String[] theSocialMedia = new String[socialMedia.size()];
        for(int i = 0; i < theSocialMedia.length; i++){
            theSocialMedia[i] = socialMedia.get(i);
        }
        return theSocialMedia;
    }
    public String getSocialMediaContent(String outlet){
        for(int i = 0; i < socialMedia.size(); i++){
            String currSocialMedia = socialMedia.get(i);
            String[] outletContent = currSocialMedia.split(":");
            String currOutlet = outletContent[0].toLowerCase();
            String currContent = outletContent[1];
            if(outlet.toLowerCase().equals(currOutlet)) {
                return currContent;
            }
        }
        return null;
    }
    public Listing[] getListings(){
        Listing[] theListingsArray = new Listing[theListings.size()];
        for(int i = 0; i < theListingsArray.length; i++) {
            theListingsArray[i] = theListings.get(i);
        }
        return theListingsArray;
    }
    public String getStartDate(){
        return startDate;
    }

    public boolean equalsTo(Advertiser adv){
        if(phoneNumber.equals(adv.getPhoneNumber()) &&
                businessName.equals(adv.getBusinessName()) &&
                 fname.equals(adv.getFname()) &&
                    mname.equals(adv.getMname()) &&
                        lname.equals(adv.getLname()) &&
                            suffix.equals(adv.getSuffix()) &&
                              emailAddr.equals(adv.getEmailAddr()) &&
                                startDate.equals(adv.getStartDate())){
            return true;
        }
        else{
            return false;
        }
    }
}
