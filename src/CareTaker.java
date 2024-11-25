/**
 * Represents a caretaker responsible for providing care to animals in the rescue center
 */
public class CareTaker {
    private final String name;
    private int energy;

    /**
     * Constructs a caretaker with a name & initial energy level
     *
     * @param name represents the name of the caretaker
     * @param energy represents the initial energy level of the caretaker
     */
    public CareTaker(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    /**
     * Provides care to an animal if the caretaker has energy
     *
     * @param center represents the rescue center where care is being provided
     * @param careType represents the type of care to be given (food or medical)
     * @param animal represents the animal receiving care
     * @return true if care is successfully provided, false otherwise
     */
    public boolean careForAnimal(RescueCenter center, String careType, Animal animal) {
        if (energy > 0) {
            boolean success = center.provideCare(careType, animal);
            if (success) {
                energy--;
                return true;
            }
        }
        return false;
    }

    /**
     * Allows the caretaker to rest & regain energy
     */
    public void rest() {
        energy += 5;
    }

    /**
     * Gets the current energy level of the caretaker
     *
     * @return current energy level
     */
    public int getEnergy() {
        return energy;
    }
}

