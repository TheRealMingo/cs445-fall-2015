import exceptions.CategoryListingMustHaveListingException;

/**
 * Created by Anthony on 10/9/2015.
 */
public class CategoryListing {
    public CategoryListing()throws CategoryListingMustHaveListingException{
        throw new CategoryListingMustHaveListingException();
    }
}
