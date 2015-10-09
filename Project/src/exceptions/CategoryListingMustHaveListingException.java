package exceptions;

/**
 * Created by Anthony on 10/9/2015.
 */
public class CategoryListingMustHaveListingException extends Exception {

    public CategoryListingMustHaveListingException(){
        super("Cannot initialize CategoryListing without a category");
    }
}
