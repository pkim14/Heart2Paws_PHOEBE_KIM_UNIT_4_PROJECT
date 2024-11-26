import java.util.Random;

/**
 * Represents an animal in the rescue center with health status & care needs
 */
public class Animal {
    private final String species;
    private int healthStatus;
    private final String[] careNeeds;
    private double recoveryProgress;

    /**
     * Constructs an animal with species, initial health, & care requirements
     *
     * @param species represents the type/species of the animal
     * @param healthStatus represents the initial health status of the animal
     * @param careNeeds is an array of care types the animal requires
     */
    public Animal(String species, int healthStatus, String[] careNeeds) {     // String [] = declares the parameter as an array
        this.species = species;
        this.healthStatus = healthStatus;
        this.careNeeds = careNeeds;
        this.recoveryProgress = 0.0;
    }

    /**
     * Provides care to the animal based on its care needs
     *
     * @param careType represents the type of care being provided
     * @return true if care is successfully received, false otherwise
     */
    public boolean receiveCare(String careType) {
        if (careType.equals("food") && healthStatus < 100) {
            healthStatus += 10;
            recoveryProgress += 5;

            // ensure health doesn't exceed 100
            healthStatus = Math.min(healthStatus, 100);
            recoveryProgress = Math.min(recoveryProgress, 100);

            return true;

        } else if (careType.equals("medical") && healthStatus < 100) {
            healthStatus += 15;
            recoveryProgress += 10;

            // ensure health doesn't exceed 100
            healthStatus = Math.min(healthStatus, 100);
            recoveryProgress = Math.min(recoveryProgress, 100);

            return true;
        }
        return false;
    }

    /**
     * Checks if the animal has fully recovered
     *
     * @return true if recovery progress reaches the threshold, false otherwise
     */
    public boolean isRecovered() {
        return recoveryProgress >= 50.0 && healthStatus == 100;
    }

    /**
     * Updates the animal's health status, potentially decreasing health
     */
    public void updateHealth() {
        Random random = new Random();
        if (healthStatus < 80 && random.nextInt(10) < 3) {
            healthStatus -= 5;
            if (healthStatus < 0) healthStatus = 0;
        }
    }

    // Getter methods
    /**
     * Gets the species of the animal
     *
     * @return the animal's species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the current health status of the animal
     *
     * @return current health status
     */
    public int getHealthStatus() {
        return healthStatus;
    }

    /**
     * Gets the current recovery progress of the animal
     *
     * @return recovery progress value
     */
    public double getRecoveryProgress() {
        return recoveryProgress;
    }
}
