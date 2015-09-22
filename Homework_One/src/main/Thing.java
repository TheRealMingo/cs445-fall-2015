package main;

/**
 * Created by Anthony on 9/21/2015.
 */
public class Thing {
    private String name;

    public Thing(String name){
        this.name = name;
    }

    public String toString(){
       if(getClass().getSimpleName().equals("Thing")) {
           return name;
       }
        return name + " " + getClass().getSimpleName();
    }
}
