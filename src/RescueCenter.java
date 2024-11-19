import java.util.ArrayList;
import java.util.Random;

/**
 * RescueCenter class represents a Rescue Center for animals, managing their care, supplies, & recovery
 */
public class RescueCenter {
    private final ArrayList<Animal> animalList;
    private int foodSupply;
    private int medicalSupply;

    /**
     * Constructor for the RescueCenter class. This creates a new instance of the Rescue Center given the below parameters.
     *
     * @param foodSupply represents the intital quantity of food supplies
     * @param medicalSupply represents the initial quantity of medical supplies
     */
    public RescueCenter(int foodSupply, int medicalSupply) {
        this.foodSupply = foodSupply;
        this.medicalSupply = medicalSupply;
        this.animalList = new ArrayList<>();
    }

    /**
     * Adds an animal to the rescue center's animal list
     *
     * @param animal represents the animal to be added to the center
     */
    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    /**
     * Provides care to an animal based on the specified care type
     *
     * @param careType represents the type of care (food or medical)
     * @param animal represents the animal receiving care
     * @return True if care is successfully provided, false otherwise
     */
    public boolean provideCare(String careType, Animal animal) {
        if (careType.equalsIgnoreCase("food") && foodSupply > 0) {
            if (animal.receiveCare("food")) {
                foodSupply--;
                return true;
            }
        } else if (careType.equalsIgnoreCase("medical") && medicalSupply > 0) {
            if (animal.receiveCare("medical")){
                medicalSupply--;
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a list of animals that have fully recovered
     *
     * @return list of recovered animals
     */
    public ArrayList<Animal> getRecoveredAnimals() {
        ArrayList<Animal> recovered = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.isRecovered()) {
                recovered.add(animal);
            }
        }
        return recovered;
    }

    /**
     * Replenishes food or medical supplies by a specified amount
     *
     * @param supplyType represents the type of supply to replenish (food or medical)
     * @param amount represents the quantity of supplies to add
     */
    public void replenishSupplies(String supplyType, int amount) {
        if (supplyType.equals("food")) {
            foodSupply += amount;
        }
        else if (supplyType.equals("medical")) {
            medicalSupply += amount;
        }
    }

    /**
     * Simulate a day at the rescue center, updating animal health & potentially reducing supplies
     */
    public void simulateDay(){
        Random random = new Random();
        for (Animal animal : animalList) {
            animal.updateHealth();

            if (random.nextInt(10) < 2) {
                foodSupply = Math.max(0, foodSupply -1);
                medicalSupply = Math.max(0, medicalSupply - 1);
            }
        }

    }

    // Getter methods
    /**
     * Gets the current food supply
     *
     * @return the current food supply quantity
     */
    public int getFoodSupply() {
        return foodSupply;
    }

    /**
     * Gets the current medical supply
     *
     * @return the current medical supply quantity
     */
    public int getMedicalSupply() {
        return medicalSupply;
    }

    /**
     * Gets the list of animals in the rescue center
     *
     * @return list of animals
     */
    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }
}
