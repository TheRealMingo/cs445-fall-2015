/**
 * Created by Anthony on 9/21/2015.
 */
public class TestCreature {
    static int THING_COUNT = 10;
    static int CREATURE_COUNT = 4;
    public static void main(String[] args){
        Thing[] arrayOfThings = new Thing[THING_COUNT];
        Creature[] arrayOfCreatures = new Creature[CREATURE_COUNT];
        arrayOfThings[0] = new Thing("Dr. Suess");
        arrayOfThings[1] = new Thing("Thing 1");
        arrayOfThings[2] = new Thing("Thing 2");
        arrayOfThings[3] = new Thing("Blue Fish");
        arrayOfThings[4] = new Thing("Red Fish");
        arrayOfThings[5] = new Tiger("Tony");
        arrayOfThings[6] = new Tiger("Mufasta");
        arrayOfThings[7] = new Tiger("Simba");
        arrayOfThings[8] = new Tiger("Kimbo");
        arrayOfThings[9] = new Tiger("Roar");

        arrayOfCreatures[0] = new Tiger("Tigerman");
        arrayOfCreatures[1] = new Ant("Antman");
        arrayOfCreatures[2] = new Bat("Batman");
        arrayOfCreatures[3] = new Fly("Flyman");
        System.out.println("Things: \n");
        for(int i = 0; i < arrayOfThings.length; i++){
            System.out.println(arrayOfThings[i]);
        }
        System.out.println("\nCreatures: \n");
        for(int i = 0; i < arrayOfCreatures.length; i++){
            System.out.println(arrayOfCreatures[i]);
            arrayOfCreatures[i].move();
            System.out.println();
        }
    }
}
