package sad.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoryListing extends Listing {
    private Category category;

    public CategoryListing(){
        super();
    }

    public CategoryListing(CategoryListing cl){
        this.setBusinessDescription(cl.getBusinessDescription());
        this.setImageLoc(cl.getImageLoc());
        this.setWebsiteLink(cl.getWebsiteLink());
        this.setStartDate(cl.getStartDate());
        this.setEndDate(cl.getEndDate());
        this.setPrice(cl.getPrice());
        this.setAdvertiser(cl.getAdvertiser());
        this.setCategory(cl.getCategoryGenre());
    }
    public CategoryListing(Category category){
        this.category = category;
    }

    public CategoryListing(Advertiser adv, Category category, String businessDescr, String imageLoc, String websiteLink, String startDate, String endDate, double price){
        super(adv, businessDescr, imageLoc, websiteLink, startDate, endDate, price);
        this.category = category;
    }

    public void setCategory(String s){
        /*Check main.entities.Category is an the main.entities.Category Data Structure*/
        category = new Category(s);
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }

    public String getCategoryGenre(){
        return category.getCategoryGenre();
    }


    @Override
    public boolean equalTo(Listing l){
        return false;
    }

    public boolean equalTo(CategoryListing cl){
        if(super.equalTo(cl) && category.equalsTo(cl.getCategory())){
            return true;
        }
        else{
            return false;
        }
    }
}
