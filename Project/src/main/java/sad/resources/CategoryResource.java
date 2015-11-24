package sad.resources;

import sad.entities.Category;
import sad.entities.CategoryListing;
import sad.entities.Listing;
import system.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Anthony on 11/22/2015.
 */

@Path("categories")
public class CategoryResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category[] getCategories(){
        return Main.system.getCategories();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listings/{category: .*}")
    public CategoryListing[] getListingsWithCategory(@PathParam("category")List<PathSegment> categories){
        String[] catNsubcat = new String[categories.size()];
        for(int i = 0; i < categories.size();i++){
            catNsubcat[i] = categories.get(i).getPath();
        }
        Main.system.getListingsOfCategoryAndSubcategories(catNsubcat);
        return null;
    }

    @POST
    @Path("category")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category createCategory(Category category){
        Main.system.addCategory(category);
        return category;
    }

    @DELETE
    @Path("remove/{category}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("category") String category){
        Main.system.deleteCategory(category);
        return Response.ok().build();
    }

    @POST
    @Path("category/{category}/{subcategory}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category giveCategorySubcategory(@PathParam("category") String category, @PathParam("subcategory") String subcategory){
        Category[] categories = Main.system.getCategories();
        /*
        TODO: Use a breadth first search to search the subcategories to see if a subcategory (which is a category) needs to be the one to have the subcategory append to it
        */
        Category currCategory = new Category();
        for(int i = 0; i < categories.length; i++){
            currCategory = categories[i];
            if(currCategory.getCategoryGenre().equals(category)){
                currCategory.giveSubcategory(subcategory);
                break;
            }
        }
        return currCategory;
    }

}
