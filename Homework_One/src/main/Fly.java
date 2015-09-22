package main;

/**
 * Created by Anthony on 9/21/2015.
 */
public class Fly extends Creature {
    public Fly(String name){
        super(name);
    }

    public void eat(Thing aThing){
        if(!aThing.getClass().getSimpleName().equals("main.Thing")) {
            System.out.println(toString() + " won't eat a "  + aThing.toString());
        }
        else{
            super.eat(aThing);
        }
    }

    public void move(){
        System.out.println(toString() + " is buzzing around in flight.");
    }
}
