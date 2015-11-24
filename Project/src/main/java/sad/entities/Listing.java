package sad.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@XmlRootElement
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
        this.businessDescr = new String(l.getBusinessDescription());
        this.imageLoc = new String(l.getImageLoc());
        this.websiteLink = new String(l.getWebsiteLink());
        this.startDate = new String(l.getStartDate());
        this.endDate = new String(l.getEndDate());
        this.price = l.getPrice();
        this.adv = l.getAdvertiser();
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

    public void setAdvertiser(Advertiser adv){
        this.adv = adv;
    }
    public void setBusinessDescription(String description){
        businessDescr =  new String(description);
    }
    public void setImageLoc(String location){
        imageLoc = new String(location);
    }
    public void setWebsiteLink(String link){
        websiteLink = new String(link);
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setStartDate(GregorianCalendar startDate){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        date.setCalendar(startDate);
        this.startDate = date.format(startDate.getTimeInMillis());
    }

    public void setStartDate(int year, int month, int day){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        GregorianCalendar calendarDate = new GregorianCalendar(year, month-1, day);
        date.setCalendar(calendarDate);
        this.startDate = date.format(calendarDate.getTimeInMillis());
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setEndDate(GregorianCalendar endDate){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        date.setCalendar(endDate);
        this.endDate = date.format(endDate.getTimeInMillis());
    }

    public void setEndDate(int year, int month, int day){
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
        GregorianCalendar calendarDate = new GregorianCalendar(year, month-1, day);
        date.setCalendar(calendarDate);
        this.endDate = date.format(calendarDate.getTimeInMillis());
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public String getBusinessDescription(){
        return businessDescr;
    }

    public String getImageLoc(){
        return imageLoc;
    }

    public String getWebsiteLink(){
        return websiteLink;
    }

    public double getPrice(){
        return price;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public Advertiser getAdvertiser(){ return adv;}

    public String getAdvertiserFirstName(){ return adv.getFname(); }
    public String getAdvertiserMiddleName(){ return adv.getMname(); }
    public String getAdvertiserLastName(){return adv.getLname(); }
    public String getAdvertiserSuffix(){return adv.getSuffix(); }
    public String getAdvertiserFullName(){return adv.getFullName(); }
    public String getAdvertiserBusinessName(){return adv.getBusinessName();}

    public boolean equalTo(Listing l){
        if(this.getBusinessDescription().equals(l.getBusinessDescription()) &&
                this.getEndDate().equals(l.getEndDate()) &&
                    this.getStartDate().equals(l.getStartDate()) &&
                        this.getImageLoc().equals(l.getImageLoc()) &&
                            this.price == l.getPrice()){
            return true;
        }
        return false;
    }


}
