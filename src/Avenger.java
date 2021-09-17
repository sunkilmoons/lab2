/**
 * This class represents an Avenger, it inherits from
 * @author cassidybaskerville qwz007
 * UTSA CS 3443 - Lab 2
 * Fall 2021
 * @see Person
 */
public class Avenger extends Person {

    private String alias;

    private String gender;

    private String height;

    private double weight;

    private String currentLocation;

    private boolean hasPowers;

    /**
     * @param name the name of the avenger
     * @param alias their superhero nickname
     * @param gender their gender
     * @param height their height
     * @param weight their width
     * @param currentLocation their current location
     * @param hasPowers if they don't have powers, they have special abilities
     */
    public Avenger(String name, String alias, String gender, String height, double weight, String currentLocation, boolean hasPowers) {
        super(name);
        this.alias = alias;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.currentLocation = currentLocation;
        this.hasPowers = hasPowers;
    }

    @Override
    public String toString() {
        return String.format(" - %s (%s)%n   Special Abilities: %s%n   %s, %s, %slbs%n   Current Location: %s",
                name,
                alias,
                hasPowers ? "Yes" : "No",
                gender,
                height,
                weight,
                currentLocation
                );
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isHasPowers() {
        return hasPowers;
    }

    public void setHasPowers(boolean hasPowers) {
        this.hasPowers = hasPowers;
    }
}
