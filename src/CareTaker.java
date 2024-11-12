public class CareTaker {
    private String name;
    private int energy;

    public CareTaker(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public boolean careForAnimal(RescueCenter center, String careType, Animal animal) {
        if (energy > 0) {
            center.provideCare(careType, animal);
            energy--;
            return true;
        }
        else {
//            System.out.println(name + " is too tired to care for animals right now.");
            return false;
        }
    }

    public void rest() {
        energy += 5;
        System.out.println(name + " has rested and regained energy.");
    }

    public int getEnergy() {
        return energy;
    }
}
