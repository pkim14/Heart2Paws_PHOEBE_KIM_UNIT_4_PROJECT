import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RescueCenter rescueCenter = new RescueCenter(10, 5);
        CareTaker careTaker = new CareTaker("Ivan", 10);

        Animal dog = new Animal("Dog", 50, new String[]{"food", "medical"});
        Animal bunny = new Animal("Bunny", 30, new String[]{"food", "medical"});
        Animal snake = new Animal("Snake", 75, new String[]{"food", "medical"});
        Animal parrot = new Animal("Parrot", 64, new String[]{"food", "medical"});

        rescueCenter.addAnimal(dog);
        rescueCenter.addAnimal(bunny);
        rescueCenter.addAnimal(snake);
        rescueCenter.addAnimal(parrot);

        boolean continueSimulation = true;

        for (int day = 1; day <= 5 && continueSimulation; day++) {
            System.out.println("-----------------------------------");
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
                break;
            }

            System.out.println("Enter the number of the animal you want to care for, or 0 to skip: ");
            int animalChoice = s.nextInt();
            if (animalChoice > 0 && animalChoice <= animals.size()) {
                Animal chosenAnimal = animals.get(animalChoice - 1);

                System.out.println("Choose care type: 1 for Food, 2 for Medical");
                int careChoice = s.nextInt();

                while (careChoice != 1 && careChoice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    careChoice = s.nextInt();
                }
                // if careChoice is 1, it returns "food"
                // if careChoice is NOT 1, it returns "medical"
                String careType = careChoice == 1 ? "food" : "medical";

                System.out.println("How much care would like to provide? (Enter an amount): ");
                int careAmount = s.nextInt();

                // check if request care amount exceeds available supplies
                int availableSupplies = careChoice == 1 ? rescueCenter.getFoodSupply() : rescueCenter.getMedicalSupply();

                if (careAmount > availableSupplies) {
                    System.out.println("Not enough supplies. Maximum care amount is " + availableSupplies);
                    careAmount = availableSupplies;
                }

                boolean success = careTaker.careForAnimal(rescueCenter, careType, chosenAnimal, careAmount);

            } else {
                System.out.println("No care was provided to animals today.");
            }

            System.out.println("Would you like to replenish supplies? Enter 'yes' to replenish or 'no' to continue.");
            String replenishChoice = s.next();

            if (replenishChoice.equalsIgnoreCase("yes")) {
                System.out.println("Choose supply to replenish: 1 for Food, 2 for Medical");
                int supplyChoice = s.nextInt();
                if (supplyChoice != 1 && supplyChoice != 2) {
                    // stop the method's execution && will continue till the choice the is valid
                    throw new IllegalArgumentException("Invalid supply choice. Must be 1 or 2");
                }
                String supplyType = supplyChoice == 1 ? "food" : "medical";
                System.out.println("Enter amount to replenish: ");
                int amount = s.nextInt();

                if (rescueCenter.canReplenishSupplies(supplyType, amount)) {
                    rescueCenter.replenishSupplies(supplyType, amount);
                    System.out.println(supplyType + " supply replenished by " + amount + ".");
                } else {
                    System.out.println("Invalid supply replenishment.");
                }
            } else {
                System.out.println("Do you want to continue the simulation? Enter 'yes' or 'no'.");
                String continueChoice = s.next();

                if (!continueChoice.equalsIgnoreCase("yes")) {
                    continueSimulation = false;
                    System.out.println("Ending simulation.");
                }
            }

            ArrayList<Animal> recoveredAnimals = rescueCenter.getRecoveredAnimals();
            // iterates through the list of recovered animals
            for (Animal animal : recoveredAnimals) {
                System.out.println(animal.getSpecies() + " has recovered and can be released!");
                rescueCenter.getAnimalList().remove(animal);
            }
            careTaker.rest();
        }
        s.close();
    }
}
