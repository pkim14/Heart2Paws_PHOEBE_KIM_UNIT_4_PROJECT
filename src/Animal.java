import java.util.Random;

public class Animal {
    private final String species;
    private int healthStatus;
    private final String [] careNeeds;
    private double recoveryProgress;

    // first constructor
    // String [] = declares the parameter as an array
    public Animal(String species, int healthStatus, String [] careNeeds){
        this.species = species;
        this.healthStatus = healthStatus;
        this.careNeeds = careNeeds;
        this.recoveryProgress = 0.0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ;
    }

    // first method
    public boolean receiveCare(String careType){
        for(String need : careNeeds) {
            if(need.equalsIgnoreCase(careType)) {
                healthStatus += 10;
                recoveryProgress += 0.2;
                return true;
            }
//                    return true;
                }
        return false;
    }

    // second method
    public boolean isRecovered() {
        return recoveryProgress >= 5.0;
    }

    // third method
    public void updateHealth() {
        Random random = new Random();
        if (random.nextBoolean()) {
            healthStatus -= 5;
            if (healthStatus < 0) healthStatus = 0;
        }
    }

    // getter methods
    // fourth method
    public String getSpecies() {
        return species;
    }

    // fifth method
    public int getHealthStatus() {
        return healthStatus;
    }

    // sixth method
    public double getRecoveryProgress() {
        return recoveryProgress;
    }
}
