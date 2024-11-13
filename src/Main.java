import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RescueCenter rescueCenter = new RescueCenter(10, 5);
        CareTaker careTaker = new CareTaker("Ivan", 10);

        Animal dog = new Animal("Dog", 50, new String [] {"food", "medical"});
        Animal bunny = new Animal("Bunny", 30, new String[] {"food"});
        rescueCenter.addAnimal(dog);
        rescueCenter.addAnimal(bunny);

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);

            rescueCenter.simulateDay();

            System.out.println("Food supply: " + rescueCenter.getFoodSupply());
            System.out.println("Medical supply: " + rescueCenter.getMedicalSupply());
            System.out.println("Caretaker energy: " + careTaker.getEnergy());

            System.out.println("Animals in the rescue center: ");
            int index = 1;
            for (Animal animal : rescueCenter.getAnimalList()) {
                System.out.println(index + ". " + animal.getSpecies() + " - Health: " + animal.getHealthStatus());
                index ++;
            }

            // user input to choose an animal to care for
            System.out.println("Choose an animal to care for (enter number): ");
            int animalChoice = s.nextInt() -1;

            if (animalChoice < 0 || animalChoice >= rescueCenter.getAnimalList().size()) {
                System.out.println("Invalid choice. Skipping care for today.");
                continue;
            }

            Animal selectedAnimal = rescueCenter.getAnimalList().get(animalChoice);

            System.out.println("Choose care type (1 fod food, 2 for medical): ");
            int careTypeChoice = s.nextInt();
            String careType = (careTypeChoice == 1) ? "food" : "medical";
            }

            for (Animal animal : rescueCenter.getAnimalList()) {
                careTaker.careForAnimal(rescueCenter, "food", dog);
                careTaker.careForAnimal(rescueCenter, "medical", bunny);
            }

            ArrayList<Animal> recoveredAnimals = rescueCenter.getRecoveredAnimals();
            for (Animal animal : recoveredAnimals) {
                System.out.println(animal.getSpecies() + " has recovered and can be released!");
                rescueCenter.getAnimalList().remove(animal);
            }
            careTaker.rest();
        }
        }
    }
