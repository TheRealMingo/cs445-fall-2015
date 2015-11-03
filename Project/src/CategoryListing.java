/**
 * Created by Anthony on 10/9/2015.
 */
public class CategoryListing extends Listing {
    private Category category;

    public CategoryListing(){
        super();
    }

    public CategoryListing(Category category){
        this.category = category;
    }

    public CategoryListing(Category category, String businessDescr, String imageLoc, String websiteLink, String startDate, String endDate, double price){
        super(businessDescr, imageLoc, websiteLink, startDate, endDate, price);
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
}
