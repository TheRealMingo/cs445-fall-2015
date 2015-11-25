package sad.persistence;

import sad.entities.Advertiser;

import java.io.*;
import java.nio.file.Paths;
/**
 * Created by Anthony on 11/24/2015.
 */
public class AdvertiserWriter {
    private OutputStream file;
    private OutputStream buffer;
    private ObjectOutput output;

    public AdvertiserWriter(){

    }


    public void writeAdvertiser(Advertiser adv){
        try{
            file = new FileOutputStream(Paths.get("").toAbsolutePath().toString()+ "\\advertisers.ser");
            buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);
            output.writeObject(adv);
            output.flush();
        }
        catch(Exception e){
            System.out.println("Error occured in writing advertiser to file:");
            System.out.println("Cause: " + e.getCause() + " Message: " + e.getMessage());
        }
    }



}
