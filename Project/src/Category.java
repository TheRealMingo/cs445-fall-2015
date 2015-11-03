import exceptions.CategoryMustHaveGenreException;

import java.util.ArrayList;

/**
 * Created by Anthony on 10/9/2015.
 */
public class Category {
    private String categoryGenre;
    private ArrayList<Subcategory> subcat = new ArrayList<Subcategory>(); /*Change to array of subcategories because category should be able to have multiple subcategories*/

    public Category() throws CategoryMustHaveGenreException {
        throw new CategoryMustHaveGenreException();
    }

    public Category(String genre){
        categoryGenre = genre;
    }

    public Category(String genre, String subcategory){
        categoryGenre = genre;
        subcat.add(new Subcategory(this, subcategory));
    }

    public String obtainGenre(){
        return categoryGenre;
    }

    public void updateGenre(String newGenre){
        categoryGenre = newGenre;
    }

    public void giveSubcategory(String subcategory){
        subcat.add(new Subcategory(this, subcategory));
    }

    public String[] obtainSubcategoriesNames(){
        int amountOfSubCategories = subcat.size();
        String[] subcategories = new String[amountOfSubCategories];
        for(int i = 0; i < amountOfSubCategories; i++) {
           subcategories[i] = subcat.get(i).obtainGenre();
        }
        return subcategories;
    }

    /*Might change so order doesn't matter*/
    public boolean equalsTo(Category c){
        if(this.obtainGenre().equals(c.obtainGenre())){
            if(this.obtainSubcategoriesNames().length != c.obtainSubcategoriesNames().length){
                return false;
            }
            else {
                for (int i = 0; i < this.obtainSubcategoriesNames().length; i++) {
                    if (this.obtainSubcategoriesNames()[i] != c.obtainSubcategoriesNames()[i]){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
