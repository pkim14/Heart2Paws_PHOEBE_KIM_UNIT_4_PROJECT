public class CareTaker {
    private String name;
    private int energy;

    public CareTaker(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

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


    public void rest() {
        energy += 5;
    }

    public int getEnergy() {
        return energy;
    }
}

