package exceptions;

/**
 * Created by Anthony on 10/9/2015.
 */
public class CategoryMustHaveGenreException extends Exception {
    public CategoryMustHaveGenreException(){
        super("Category Must Have a Name");
    }
}
