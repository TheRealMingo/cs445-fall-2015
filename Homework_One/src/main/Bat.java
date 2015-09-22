package main;

/**
 * Created by Anthony on 9/21/2015.
 */
public class Bat extends Creature implements Flyer{
    public Bat(String name){
        super(name);
    }

    public void eat(Thing aThing){
        if(!aThing.getClass().getSimpleName().equals("main.Creature")){
            if(!aThing.getClass().getSimpleName().equals("main.Thing")){

            }
            else if(aThing.getClass().getSimpleName().equals("main.Thing")){
                System.out.println(toString() + " won't eat a " +aThing.toString());
            }
        }
        else {
            super.eat(aThing);
        }
    }
    public void fly(){
        System.out.println(toString() + " is swooping through the dark.");
    }

    public void move(){
        fly();
    };
}
