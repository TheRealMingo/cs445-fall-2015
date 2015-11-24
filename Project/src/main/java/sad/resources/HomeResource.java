package sad.resources;

import sad.entities.Category;
import sad.entities.HomeFeaturedListing;
import system.Main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Anthony on 11/24/2015.
 */
@Path("/")
public class HomeResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HomeFeaturedListing[] getHomeFeaturedListings(){
        return Main.system.getHomeFeaturedListings();
    }
}
