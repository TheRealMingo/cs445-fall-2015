package sad.resources;

import sad.entities.Advertiser;
import sad.entities.Listing;
import system.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("advertisers")
public class AdvertiserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Advertiser[] getAdvertisers(){return Main.system.getAdvertisers();}

    @GET
    @Path("/searchid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Advertiser getAdvertiserByID(@PathParam("id")String id){
        return Main.system.getAdvertiserByID(Integer.parseInt(id));
    }

    @GET
    @Path("/listings/searchid/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsByAdvertisersID(@PathParam("id")String id){
        return Main.system.getListingsByAdvertisersID(Integer.parseInt(id));
    }

    @GET
    @Path("/listings/searchemail/{emailaddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsByAdvertisersEmailAddress(@PathParam("emailaddress") String emailaddress){
        //TODO: Test
        return Main.system.getListingsByAdvertisersEmailAddress(emailaddress);
    }

    @GET
    @Path("/listings/searchlastname/{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsByAdvertisersLastName(@PathParam("lastname") String lastname){
        //TODO: Test
        return Main.system.getListingsByAdvertisersLastName(lastname);
    }

    @GET
    @Path("/listings/searchphonenumber/{phonenumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsByAdvertisersPhoneNumber(@PathParam("phonenumber") String phonenumber){
        //TODO: Test
        return Main.system.getListingsByAdvertisersPhoneNumber(phonenumber);
    }

    @GET
    @Path("/listings/searchsocialmedia/{outlet}/{content}")
    @Produces(MediaType.APPLICATION_JSON)
    public Listing[] getListingsByAdvertisersSocialMedia(@PathParam("outlet") String outlet, @PathParam("content") String content){
        //TODO: Test
        return Main.system.getListingsByAdvertisersSocialMedia(outlet, content);
    }

    @POST
    @Path("advertiser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Advertiser createAdvertiser(Advertiser advertiser){
        Main.system.addAdvertiser(advertiser);
        return advertiser;
    }

    @PUT
    @Path("advertiser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Advertiser updateAdvertiser(@PathParam("id") String id, Advertiser advertiser){
        Main.system.updateAdvertiserTo(Integer.parseInt(id), advertiser);
        return Main.system.getAdvertiserByID(Integer.parseInt(id));
    }

}
