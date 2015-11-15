/**
 * Created by Anthony on 10/9/2015.
 */
public class CategoryListing extends Listing {
    private Category category;

    public CategoryListing(){
        super();
    }

    public CategoryListing(CategoryListing cl){
        this.updateBusinessDescription(cl.obtainBusinessDescription());
        this.updateImageLoc(cl.obtainImageLoc());
        this.updateWebsiteLink(cl.obtainWebsiteLink());
        this.updateStartDate(cl.obtainStartDate());
        this.updateEndDate(cl.obtainEndDate());
        this.updatePrice(cl.obtainPrice());
        this.updateAdvertiser(cl.obtainAdvertiser());
        this.updateCategory(cl.obtainCategoryGenre());
    }
    public CategoryListing(Category category){
        this.category = category;
    }

    public CategoryListing(Advertiser adv, Category category, String businessDescr, String imageLoc, String websiteLink, String startDate, String endDate, double price){
        super(adv, businessDescr, imageLoc, websiteLink, startDate, endDate, price);
        this.category = category;
    }

    public void updateCategory(String s){
        /*Check Category is an the Category Data Structure*/
        category = new Category(s);
    }

    public Category obtainCategory(){
        return category;
    }

    public String obtainCategoryGenre(){
        return category.obtainGenre();
    }


    @Override
    public boolean equalTo(Listing l){
        return false;
    }

    public boolean equalTo(CategoryListing cl){
        if(super.equalTo(cl) && category.equalsTo(cl.obtainCategory())){
            return true;
        }
        else{
            return false;
        }
    }
}
