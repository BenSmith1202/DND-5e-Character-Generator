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
        String s = scnr.next();

            if (s.equals("createRandom")) {
                String race = "";
                boolean firstTime = true;
                while (!race.equals("dwarf") && !race.equals("elf") && !race.equals("human")){
                    if (firstTime) {
                        System.out.println("Please enter one of the following character races: dwarf, elf, or human");
                        firstTime = false;
                    } else System.out.println("That doesn't work, Please enter one of the following: dwarf, elf, or human");
                    race = scnr.next(); // maybe fix this its not correct
                }
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
            }

            if (s.equals("createFile")) {
                System.out.println("Please enter the file name you wish to create a character from");
                PlayerCharacter p1 = new PlayerCharacter(scnr.next());
                p1.printSheet();
                done = true;
            }
        }



    }
}
