package main;

/**
 * Created by Anthony on 9/21/2015.
 */
public class Ant extends Creature {
    public Ant(String name){
        super(name);
    }

    public void move(){
        System.out.println(toString() + " is crawling around.");
    } 
}
