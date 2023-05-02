import java.io.FileNotFoundException;

public class nameGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("DWARF NAMES:");
        for (int i = 0; i < 25; i++) {
            System.out.println(RandomNameGenerator.getDwarfName());
        }
        System.out.println("\n\n\n");
        System.out.println("HUMAN NAMES:");
        for (int i = 0; i < 25; i++) {
            System.out.println(RandomNameGenerator.getHumanName());
        }
        System.out.println("\n\n\n");
        System.out.println("ELF NAMES:");
        for (int i = 0; i < 25; i++) {
            System.out.println(RandomNameGenerator.getElfName());
        }

        PlayerCharacter p1 = new PlayerCharacter(1, RandomNameGenerator.getHumanName(),"Dwarf","Bard");
        p1.printSheet();
        PlayerCharacter p2 = new PlayerCharacter(5, RandomNameGenerator.getDwarfName(),"Dwarf","Bard");
        p2.printSheet();
        PlayerCharacter p3 = new PlayerCharacter(20, RandomNameGenerator.getElfName(),"Dwarf","Bard");
        p3.printSheet();


    }
}
