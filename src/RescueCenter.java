import java.util.ArrayList;

public class RescueCenter {
    private ArrayList<Animal> animalList;
    private int foodSupply;
    private int medicalSupply;

    public RescueCenter(int foodSupply, int medicalSupply) {
        this.foodSupply = foodSupply;
        this.medicalSupply = medicalSupply;
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
        System.out.println("Added " + animal.getSpecies() + " the rescue center.");
    }

    public void provideCare(String careType, Animal animal) {
        if(careType.equals("food") && foodSupply > 0) {
            animal.receiveCare("food");
            foodSupply --;
        }
        else if(careType.equals("medicine") && medicalSupply > 0) {
            animal.receiveCare("medicine");
            medicalSupply --;
        }
        else {
            System.out.println("Not enough supplies for " + careType + ".");
        }
    }

    // add a method here
}
