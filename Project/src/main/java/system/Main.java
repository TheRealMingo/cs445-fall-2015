package system;

/**
 * Created by Anthony on 11/22/2015.
 */
public class Main {
    public static SAD system;
    public static void main(){
        System.out.println("Initializing system.SAD ...");
        system = SAD.getInstance();
        System.out.println("Initialized system.SAD \u0001 \n Special Advertising Directory Online");
    }
}
