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

        PlayerCharacter p1 = new PlayerCharacter(1, RandomNameGenerator.getHumanName(),"Elf","Wizard");
        p1.printSheet();
        PlayerCharacter p2 = new PlayerCharacter(5, RandomNameGenerator.getDwarfName(),"Human","Bard");
        p2.printSheet();
        PlayerCharacter p3 = new PlayerCharacter(20, RandomNameGenerator.getElfName(),"Dwarf","Barbarian");
        p3.printSheet();
        for (int i = 0; i < 30; i++) {
            System.out.println(RandomNameGenerator.getPlaceName());
        }
        System.out.println("----------------------------");
        System.out.println(RandomBackgroundGenerator.getBackstory(p1));
        System.out.println("----------------------------");
        System.out.println(RandomBackgroundGenerator.getBackstory(p2));
        System.out.println("----------------------------");
        System.out.println(RandomBackgroundGenerator.getBackstory(p3));
        System.out.println("----------------------------");

    }
}
