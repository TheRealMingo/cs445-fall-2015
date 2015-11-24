package sad.resources;

import sad.entities.CategoryListing;
import sad.entities.HomeFeaturedListing;
import sad.entities.Listing;
import system.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Anthony on 11/23/2015.
 */
@Path("listings")
public class ListingResource {
    @GET
    @Path("sort/businessname")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsSortedByBusinessName(){
        //TODO: Test
        Main.system.sortListingsByBusinessName();
        return Main.system.getListings();
    }

    @GET
    @Path("sort/lastname")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsSortedByLastName(){
        //TODO: Test
        Main.system.sortListingsByLastName();
        return Main.system.getListings();
    }

    @GET
    @Path("sort/profitable")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsSortedByMostProfitable(){
        Main.system.sortListingsByMostProfitable();
        return Main.system.getListings();
    }

    @GET
    @Path("sort/mostrecent")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsSortedByStartDate(){
        Main.system.sortListingsByStartDate();
        return Main.system.getListings();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListings(){return Main.system.getListings();}

    @GET
    @Path("homefeaturedlistings")
    @Produces(MediaType.APPLICATION_JSON)
    public HomeFeaturedListing[] getHomeFeaturedListings(){
        return Main.system.getHomeFeaturedListings();
    }

    @GET
    @Path("categorylistings")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryListing[] getCategoryListings(){return Main.system.getCategoryListings();}


    @GET
    @Path("categorylistings/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryListing[] getCategoryListingsOf(@PathParam("category") String category){
        return Main.system.getCategoryListingsOf(category);
    }

    @GET
    @Path("listing/for/{advertiserid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing createListingForAdv(@PathParam("advertiserid") String id, Listing listing){
        Main.system.addListingWithAdv(Integer.parseInt(id), listing);
        return listing;
    }

    @POST
    @Path("listing")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Listing createListing(Listing listing){
        Main.system.addListing(listing);
        return listing;
    }

    @POST
    @Path("categorylisting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryListing createCategoryListing(CategoryListing categoryListing){
        Main.system.addListing(categoryListing);
        return categoryListing;
    }

    @POST
    @Path("homefeaturedlisting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HomeFeaturedListing createHomeFeaturedListing(HomeFeaturedListing homeFeaturedListing){
        Main.system.addListing(homeFeaturedListing);
        return homeFeaturedListing;
    }
}
