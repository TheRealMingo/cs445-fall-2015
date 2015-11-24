package sad.resources;

import system.Main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Anthony on 11/24/2015.
 */
@Path("report")
public class ReportResource {
    //TODO: TEST 
    @GET
    @Path("activelistings")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllActiveListingsReport(){
        return Main.system.reportActiveListings();
    }


    @GET
    @Path("customersamount/1month")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalAmountOfCustomersLastMonth(){
        return Main.system.reportCustomersLastMonth();
    }

    //TODO: 3month - 9month
    @GET
    @Path("customersamount/3month")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalAmountOfCustomersLast3Months(){
        return null; //Main.system.reportCustomersLast3Months
    }

    @GET
    @Path("customersamount/6month")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalAmountOfCustomersLast6Months(){
        return null; //Main.system.reportCustomersLast6Months
    }

    @GET
    @Path("customersamount/9month")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalAmountOfCustomersLast9Months(){
        return null; //Main.system.reportCustomersLast9Months
    }

    @GET
    @Path("customersamount/12month")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalAmountOfCustomersLast12Months(){
        return null; //Main.system.reportCustomersLast12Months
    }
}
