import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Listing {
    private String businessDescr = "";
    private String imageLoc = "";
    private String websiteLink = "";
    private String startDate = "";
    private String endDate = "";
    private double price = 0.00;

    public Listing(){

    }

    public Listing(String businessDescr, String imageLoc, String websiteLink, String startDate, String endDate, double price){
        this.businessDescr = businessDescr;
        this.imageLoc = imageLoc;
        this.websiteLink = websiteLink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
    public void updateBusinessDescription(String description){
        businessDescr =  description;
    }

    public void updateImageLoc(String location){
        imageLoc = location;
    }

    public void updateWebsiteLink(String link){
        websiteLink = link;
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
