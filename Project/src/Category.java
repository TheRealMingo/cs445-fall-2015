import exceptions.CategoryMustHaveGenreException;

/**
 * Created by Anthony on 10/9/2015.
 */
public class Category {
    String categoryGenre;
    Subcategory subcat; /*Change to array of subcategories because category should be able to have multiple subcategories*/

    public Category() throws CategoryMustHaveGenreException {
        throw new CategoryMustHaveGenreException();
    }

    public Category(String genre){
        categoryGenre = genre;
    }

    public Category(String genre, String subcategory){
        categoryGenre = genre;
        subcat = new Subcategory(subcategory);
    }

    public String obtainGenre(){
        return categoryGenre;
    }

    public void updateGenre(String newGenre){
        categoryGenre = newGenre;
    }

    public void giveSubcategory(String subcategory){
        subcat = new Subcategory(subcategory);
    }

    public String obtainSubcategory(){
        String subcategory = subcat.obtainGenre();
        return subcategory;
    }
}
