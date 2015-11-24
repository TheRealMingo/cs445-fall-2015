package sad.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Category {
    private String categoryGenre;
    private ArrayList<Subcategory> subcat = new ArrayList<Subcategory>(); /*Change to array of subcategories because category should be able to have multiple subcategories*/

    public Category(){}

    public Category(String genre){
        categoryGenre = genre;
    }

    public Category(String genre, String subcategory){
        categoryGenre = genre;
        subcat.add(new Subcategory(this, subcategory));
    }

    public String getCategoryGenre(){
        return categoryGenre;
    }

    public void setCategoryGenre(String categoryGenre){
        this.categoryGenre = categoryGenre;
    }

    public ArrayList<Subcategory> getSubcat(){
        return subcat;
    }

    public void setSubcat(ArrayList<Subcategory> subcat){
        this.subcat = subcat;
    }

    public void giveSubcategory(String subcategory){
        subcat.add(new Subcategory(this, subcategory));
    }

    public String[] obtainSubcategoriesNames(){
        int amountOfSubCategories = subcat.size();
        String[] subcategories = new String[amountOfSubCategories];
        for(int i = 0; i < amountOfSubCategories; i++) {
           subcategories[i] = subcat.get(i).getCategoryGenre();
        }
        return subcategories;
    }

    public boolean equalsTo(Category c){
        if(this.getCategoryGenre().equals(c.getCategoryGenre())){
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
