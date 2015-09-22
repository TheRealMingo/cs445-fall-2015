/**
 * Created by Anthony on 9/21/2015.
 */
public class Tiger extends Creature {

    public Tiger(String name){
        super(name);
    }

    public void move(){
        System.out.println(this.toString() + " has just pounced.");
    }
}
