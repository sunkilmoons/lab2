import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void loadAvengers(String fileName) throws Exception {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] tokens = line.split(",");

            if (tokens.length != 8) throw new Exception(String.format("%s is not readable", line));

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Avenger> getAvengers() {
        return avengers;
    }

    public void setAvengers(ArrayList<Avenger> avengers) {
        this.avengers = avengers;
    }
}
