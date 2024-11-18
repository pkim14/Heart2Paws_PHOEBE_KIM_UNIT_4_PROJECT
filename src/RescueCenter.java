import java.util.ArrayList;
import java.util.Random;

public class RescueCenter {
    private final ArrayList<Animal> animalList;
    private int foodSupply;
    private int medicalSupply;

    public RescueCenter(int foodSupply, int medicalSupply) {
        this.foodSupply = foodSupply;
        this.medicalSupply = medicalSupply;
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

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

    // get a list of recovered animals
    public ArrayList<Animal> getRecoveredAnimals() {
        ArrayList<Animal> recovered = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.isRecovered()) {
                recovered.add(animal);
            }
        }
        return recovered;
    }

    // replenish food/medical supplies
    public void replenishSupplies(String supplyType, int amount) {
        if (supplyType.equals("food")) {
            foodSupply += amount;
        }
        else if (supplyType.equals("medical")) {
            medicalSupply += amount;
        }
    }

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

    // getter methods for supplies
    public int getFoodSupply() {
        return foodSupply;
    }

    public int getMedicalSupply() {
        return medicalSupply;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }
}
