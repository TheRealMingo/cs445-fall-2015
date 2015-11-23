package system;

import sad.entities.AdvertiserArray;
import sad.entities.Category;
import sad.entities.CategoryArray;
import sad.entities.ListingArray;

/**
 * Created by Anthony on 11/22/2015.
 */
public class SAD {
    private static AdvertiserArray advertisers = new AdvertiserArray();
    private static CategoryArray categories = new CategoryArray();
    private static ListingArray listings = new ListingArray();
    private static SAD sad = new SAD();

    private SAD(){}

    public static SAD getInstance(){
        return sad;
    }

    public static void addCategory(Category c){
        categories.addCategory(c);
    }

    public static void deleteCategory(Category c){
       for(int i = 0; i < categories.getTotalNumOfCategories(); i++){
           if(categories.getCategory(i).equalsTo(c)){
               categories.removeCategoryAtPos(i);
           }
       }
    }

    public static void deleteCategory(String c){
        int deletePos = -1;

        Category currCategory = new Category();
        for(int i = 0; i < categories.getTotalNumOfCategories(); i++){
            currCategory = categories.getCategory(i);
            if(currCategory.getCategoryGenre().equals(c)){
                deletePos = i;
                break;
            }
        }

        if(deletePos != -1){
            categories.removeCategoryAtPos(deletePos);
        }
    }
    public static Category[] getCategories(){
        return categories.obtainAllCategories();
    }




}
