public abstract class Creature extends Thing{
    private Thing eatenThing;
    public Creature(String name){
        super(name);
    }

    public void eat(Thing aThing){
        eatenThing = aThing;
    }

    public abstract void move();

    public void whatDidYouEat(){
        if(eatenThing == null){
          System.out.println(this.toString() + " has had nothing to eat");
        }
        else {
            System.out.println(this.toString() + " has eaten a " + eatenThing.getClass().getSimpleName());
        }
    }
}
