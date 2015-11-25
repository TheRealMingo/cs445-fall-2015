package sad.persistence;

import sad.entities.Advertiser;
import sad.entities.AdvertiserArray;

import java.io.*;
import java.nio.file.Paths;

/**
 * Created by Anthony on 11/24/2015.
 */
public class AdvertiserReader {
    public InputStream file;
    public InputStream buffer;
    public ObjectInput input;

    public AdvertiserReader(){

    }

    public Advertiser[] readAdvertisers(){
        AdvertiserArray advertisers = new AdvertiserArray();
        try {
            file = new FileInputStream(Paths.get("").toAbsolutePath().toString() + "\\advertisers.ser");
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            Advertiser anAdvertiser = (Advertiser)input.readObject();
            while(anAdvertiser != null){
                advertisers.addAdvertiser(anAdvertiser);
                anAdvertiser = (Advertiser)input.readObject();
            }
        }
        catch(Exception e){
            System.out.println("Error occured while reading file");
            System.out.println("Cause: " + e.getCause() + " Messsage: " + e.getMessage());
        }
        return advertisers.obtainAdvertisers();
    }
}
