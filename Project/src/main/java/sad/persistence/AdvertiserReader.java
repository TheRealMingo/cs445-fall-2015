package sad.persistence;

import sad.entities.Advertiser;

import java.io.*;
import java.nio.file.Paths;

/**
 * Created by Anthony on 11/24/2015.
 */
public class AdvertiserReader {
    public static InputStream file;
    public static InputStream buffer;
    public static ObjectInput input;

    public AdvertiserReader(){
        try{
            file = new FileInputStream(Paths.get("").toAbsolutePath().toString() + "\\advertisers.ser");
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
        }
        catch(Exception e){
            System.out.println("Error occured in AdvertiserReader constructor:");
            System.out.println("Cause: " + e.getCause() + " Message: " + e.getMessage());
        }
    }

    public void readAdvertisers(){
        Advertiser[] advertisers;
    }
}
