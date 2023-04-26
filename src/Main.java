import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * This class will be a interactive thingy that will promt the user to make a character and do stuffm
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        boolean done = false;
        while (!done) {
        System.out.println("Choose one of the options by typing in the given string:\n" +
                "createRandom\ncreateFile");

        Scanner scnr = new Scanner(System.in);

            if (scnr.next().equals("createRandom")) {
                System.out.println("Please enter the characters race");
                String race = scnr.next();
                System.out.println("Please enter the characters level");
                int level = scnr.nextInt();
                String name = "";
                if (race.equals("dwarf")) {
                    name = PlayerCharacter.getDwarfName();
                } else if (race.equals("elf")) {
                    name = PlayerCharacter.getElfName();
                } else if (race.equals("human")) {
                    name = PlayerCharacter.getHumanName();
                }
                PlayerCharacter p1 = new PlayerCharacter(level, name);
                p1.printSheet();
                done = true;
            } else if (scnr.next().equals("createFile")) {

            }
        }



    }
}
