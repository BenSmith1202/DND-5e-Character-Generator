import java.io.FileNotFoundException;

public class nameGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("DWARF NAMES:");
        for (int i = 0; i < 25; i++) {
            System.out.println(PlayerCharacter.getDwarfName());
        }
        System.out.println("\n\n\n");
        System.out.println("HUMAN NAMES:");
        for (int i = 0; i < 25; i++) {
            System.out.println(PlayerCharacter.getHumanName());
        }
        System.out.println("\n\n\n");
        System.out.println("ELF NAMES:");
        for (int i = 0; i < 25; i++) {
            System.out.println(PlayerCharacter.getElfName());
        }

        PlayerCharacter p1 = new PlayerCharacter(1, PlayerCharacter.getHumanName());
        p1.printSheet();


    }
}
