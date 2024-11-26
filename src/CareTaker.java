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
     * Provides care to an animal in the rescue center with a specified care amount
     *
     * @param center represents the RescueCenter where the animal is located
     * @param careType represents the type of care to provide
     * @param animal represents the specific animal receiving care
     * @param careAmount represents the quantity of care that is provided
     * @return true if at least unit of care was provided, false otherwise
     */
    public boolean careForAnimal(RescueCenter center, String careType, Animal animal, int careAmount) {
        // check if caretaker has enough energy for the requested care amount
        if (energy >= careAmount) {
            int successfulCares = 0;

            for (int i = 0; i < careAmount; i++) {
                if (center.provideCare(careType, animal)) {
                    successfulCares++;
                    energy--;
                } else {
                    // stop if no more supplies or animal can't receive more care
                    break;
                }
            }

            // return true if at least some care was provided
            return successfulCares > 0;
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

