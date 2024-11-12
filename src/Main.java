import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RescueCenter rescueCenter = new RescueCenter(10, 5);
        CareTaker careTaker = new CareTaker("Ivan", 10);

        Animal dog = new Animal("Dog", 50, new String [] {"food", "medical"});
        Animal bunny = new Animal("Bunny", 30, new String[] {"food"});
        rescueCenter.addAnimal(dog);
        rescueCenter.addAnimal(bunny);

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);

            careTaker.careForAnimal(rescueCenter, "food", dog);
            careTaker.careForAnimal(rescueCenter, "medical", bunny);

            ArrayList<Animal> recoveredAnimals = rescueCenter.getRecoverAnimals();
            for (Animal animal : recoveredAnimals) {
                System.out.println(animal.getSpecies() + " has recovered and can be released!");
            }
            careTaker.rest();
        }
        }
    }
