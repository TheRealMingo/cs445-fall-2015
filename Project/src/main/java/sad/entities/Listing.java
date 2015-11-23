package sad.entities;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Listing {
    private Advertiser adv = null;
    private String businessDescr = "";
    private String imageLoc = "";
    private String websiteLink = "";
    private String startDate = "";
    private String endDate = "";
    private double price = 0.00;

    public Listing(){

    }

    public Listing(Listing l){
        this.businessDescr = new String(l.obtainBusinessDescription());
        this.imageLoc = new String(l.obtainImageLoc());
        this.websiteLink = new String(l.obtainWebsiteLink());
        this.startDate = new String(l.obtainStartDate());
        this.endDate = new String(l.obtainEndDate());
        this.price = l.obtainPrice();
        this.adv = l.obtainAdvertiser();
    }

    public Listing(Advertiser adv, String businessDescr, String imageLoc, String websiteLink, String startDate, String endDate, double price){
        this.adv = adv;
        this.businessDescr = new String(businessDescr);
        this.imageLoc = new String(imageLoc);
        this.websiteLink = new String(websiteLink);
        this.startDate = new String(startDate);
        this.endDate = new String(endDate);
        this.price = price;
    }

    public void updateAdvertiser(Advertiser adv){
        this.adv = adv;
    }
    public void updateBusinessDescription(String description){
        businessDescr =  new String(description);
    }

    public void updateImageLoc(String location){
        imageLoc = new String(location);
    }

    public void updateWebsiteLink(String link){
        websiteLink = new String(link);
    }

    public void updatePrice(double price){
        this.price = price;
    }

    public void updateStartDate(GregorianCalendar startDate){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        date.setCalendar(startDate);
        this.startDate = date.format(startDate.getTimeInMillis());
    }

    public void updateStartDate(int year, int month, int day){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        GregorianCalendar calendarDate = new GregorianCalendar(year, month-1, day);
        date.setCalendar(calendarDate);
        this.startDate = date.format(calendarDate.getTimeInMillis());
    }

    public void updateStartDate(String startDate){
        this.startDate = startDate;
    }

    public void updateEndDate(GregorianCalendar endDate){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        date.setCalendar(endDate);
        this.endDate = date.format(endDate.getTimeInMillis());
    }

    public void updateEndDate(int year, int month, int day){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        GregorianCalendar calendarDate = new GregorianCalendar(year, month-1, day);
        date.setCalendar(calendarDate);
        this.endDate = date.format(calendarDate.getTimeInMillis());
    }

    public void updateEndDate(String endDate){
        this.endDate = endDate;
    }

    public String obtainBusinessDescription(){
        return businessDescr;
    }

    public String obtainImageLoc(){
        return imageLoc;
    }

    public String obtainWebsiteLink(){
        return websiteLink;
    }

    public double obtainPrice(){
        return price;
    }

    public String obtainStartDate(){
        return startDate;
    }

    public String obtainEndDate(){
        return endDate;
    }

    public Advertiser obtainAdvertiser(){ return adv;}

    public String obtainAdvertiserFirstName(){ return adv.obtainFirstName(); }
    public String obtainAdvertiserMiddleName(){ return adv.obtainMiddleName(); }
    public String obtainAdvertiserLastName(){return adv.obtainLastName(); }
    public String obtainAdvertiserSuffix(){return adv.obtainSuffix(); }
    public String obtainAdvertiserFullName(){return adv.obtainFullName(); }
    public String obtainAdvertiserBusinessName(){return adv.obtainBusinessName();}

    public boolean equalTo(Listing l){
        if(this.obtainBusinessDescription().equals(l.obtainBusinessDescription()) &&
                this.obtainEndDate().equals(l.obtainEndDate()) &&
                    this.obtainStartDate().equals(l.obtainStartDate()) &&
                        this.obtainImageLoc().equals(l.obtainImageLoc()) &&
                            this.price == l.obtainPrice()){
            return true;
        }
        return false;
    }

}
