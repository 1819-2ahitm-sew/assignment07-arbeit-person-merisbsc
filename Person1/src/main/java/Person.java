import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Person {

    static int counter = 0;

    public static void main(String[] args) {
        String filename = "personen.csv";
        String readFile = readFile(filename);
        String[] names = new String[counter];
        String[] finNames = new String[names.length * 2];
        names = readFile.split("\n");


        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].replace(";", " ");
        }

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }


    }

    public static String readFile(String filename) {

        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
                counter++;
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return sb.toString();
    }

}
