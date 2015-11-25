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
        return Main.system.getListingsOfCategoryAndSubcategories(catNsubcat);
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("category") String category){
        Main.system.deleteCategory(category);
        return Response.ok().build();
    }

    @PUT
    @Path("category/{category}/{subcategory}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category giveCategorySubcategory(@PathParam("category") String category, @PathParam("subcategory") String subcategory){
        Category[] categories = Main.system.getCategories();
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
