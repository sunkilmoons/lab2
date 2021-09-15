/**
 * This class enforces Person attributes onto inheriting classes of type Person
 * @author cassidybaskerville qwz007
 * UTSA CS 3443 - Lab 2
 * Fall 2021
 */
public abstract class Person {

    protected String name;

    /**
     * @param name name of the person
     */
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
