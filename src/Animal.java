public class Animal {
    private String species;
    private int healthStatus;
    private String [] careNeeds;
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
    public void receiveCare(String careType){
        for(String need : careNeeds) {
            if(need.equalsIgnoreCase(careType)) {
                healthStatus += 10;
                recoveryProgress += 0.1;
                System.out.println(species + " received " + careType + " care. Health: " + healthStatus);
            }
        }
    }

    // second method
    public boolean isRecovered() {
        return recoveryProgress >= 1.0;
    }

    // third method
    public void updateHealth() {
        healthStatus -= 5;
        if (healthStatus < 0) healthStatus = 0;
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
