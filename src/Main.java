import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RescueCenter rescueCenter = new RescueCenter(10, 5);
        CareTaker careTaker = new CareTaker("Ivan", 10);

        Animal dog = new Animal("Dog", 50, new String[] {"food", "medical"});
        Animal bunny = new Animal("Bunny", 30, new String[] {"food", "medical"});
        Animal snake = new Animal("Snake", 75, new String[] {"food", "medical"});
        Animal parrot = new Animal("Parrot", 64, new String[] {"food", "medical"});

        rescueCenter.addAnimal(dog);
        rescueCenter.addAnimal(bunny);
        rescueCenter.addAnimal(snake);
        rescueCenter.addAnimal(parrot);

        boolean continueSimulation = true;

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);

            rescueCenter.simulateDay();

            System.out.println("Food supply: " + rescueCenter.getFoodSupply());
            System.out.println("Medical supply: " + rescueCenter.getMedicalSupply());
            System.out.println("Caretaker energy: " + careTaker.getEnergy());

            System.out.println("Animals in the Rescue Center: ");
            ArrayList<Animal> animals = rescueCenter.getAnimalList();
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                System.out.println(i + 1 + "." + animal.getSpecies() + " (Health: " + animal.getHealthStatus() + ", Recovery Progress: " + animal.getRecoveryProgress() + ")");
            }

            if (animals.isEmpty()) {
                System.out.println("No animals remain in the Rescue Center.");
                break; // may need to change
            }

            System.out.println("Enter the number of the animal you want to care for, or 0 to skip: ");
            int animalChoice = s.nextInt();
            if (animalChoice > 0 && animalChoice <= animals.size()) {
                Animal chosenAnimal = animals.get(animalChoice - 1);

                System.out.println("Choose care type: 1 for Food, 2 for Medical");
                int careChoice = s.nextInt();
                String careType = careChoice == 1 ? "food" : "medical";

                boolean success = careTaker.careForAnimal(rescueCenter, careType, chosenAnimal);
                if (success) {
                    System.out.println("Provided " + careType + " care to " + chosenAnimal.getSpecies() + ".");
                } else {
                    System.out.println("Could not provide " + careType + " care (either no supplies or caretaker is out of energy).");
                }
            }
            else {
                    System.out.println("No care was provided to animals today.");
            }


            System.out.println("Would you like to replenish supplies? Enter 'yes' to replenish or 'no' to continue.");
            String replenishChoice = s.next();

            if (replenishChoice.equalsIgnoreCase("yes")) {
                System.out.println("Choose supply to replenish: 1 for Food, 2 for Medical");
                int supplyChoice = s.nextInt();
                String supplyType = supplyChoice == 1 ? " food" : "medical";
                System.out.println("Enter amount to replenish: ");
                int amount = s.nextInt();

                rescueCenter.replenishSupplies(supplyType, amount);
                System.out.println(supplyType + " supply replenished by " + amount + ".");
                System.out.println("------------------------------------------------------------------------------------");

            }
            else {
                System.out.println("Do you want to continue the simulation? Enter 'yes' or 'no'.");
                String continueChoice = s.next();

                if (!continueChoice.equalsIgnoreCase("yes")) {
                    continueSimulation = false;
                    System.out.println("Ending simulation.");
                    System.out.println("------------------------------------------------------------------------------------");
                }
                else {
                    continueSimulation = true;
                }
            }

            ArrayList<Animal> recoveredAnimals = rescueCenter.getRecoveredAnimals();
            for (Animal animal : recoveredAnimals) {
                System.out.println(animal.getSpecies() + " has recovered and can be released!");
                rescueCenter.getAnimalList().remove(animal);
                System.out.println("------------------------------------------------------------------------------------");

            }
            careTaker.rest();
        }
        s.close();
        }
    }
