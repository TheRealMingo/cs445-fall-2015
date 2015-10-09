package exceptions;

/**
 * Created by Anthony on 10/9/2015.
 */
public class SubCategoryMustHaveGenreException extends Exception {
    public SubCategoryMustHaveGenreException(){
        super("Subcategory must have genre");
    }
}
