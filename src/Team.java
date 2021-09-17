import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This class represents a team of avengers
 * @author cassidybaskerville qwz007
 * UTSA CS 3443 - Lab 2
 * Fall 2021
 * @see Avenger
 */
public class Team {

    private String name;

    private ArrayList<Avenger> avengers;

    /**
     * @param name of the team
     */
    public Team(String name) {
        this.name = name;
        this.avengers = new ArrayList<Avenger>();
    }


    /**
     * @param filePath the path to the file to load
     * @throws Exception - if file cannot be found or read, throws an exception
     */
    public void loadAvengers(String filePath) throws Exception {
        File file = new File(filePath);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] tokens = line.split(",");

            if (tokens.length != 8) {
                scanner.close();
                throw new Exception(String.format("%s is not readable", line));
            }

            addAvenger(
                    new Avenger(
                            tokens[0],
                            tokens[1],
                            tokens[2],
                            String.format("%s'%s\"", tokens[3], tokens[4]),
                            Double.parseDouble(tokens[5]),
                            tokens[7],
                            tokens[6].compareToIgnoreCase("T") == 0
                    )
            );
        }

        scanner.close();
    }


    /**
     * This method adds an avenger to the array list
     * @param avenger the avenger to add
     */
    public void addAvenger(Avenger avenger) {
        avengers.add(avenger);
    }

    @Override
    public String toString() {
        return String.format("Team %s:%n%s%n",
                name,
                avengers.stream()
                        .map(Avenger::toString)
                        .collect(Collectors.joining("\n\n"))
                );
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return list of avengers
     */
    public List<Avenger> getAvengers() {
        return avengers;
    }

    /**
     * @param avengers to set in array list
     */
    public void setAvengers(List<Avenger> avengers) {
        this.avengers = new ArrayList<>(avengers);
    }
}
