import java.io.FileNotFoundException;

/**
 * @author Ben Smith, David Olinger
 * Generates many versions of various randomly generated aspects of characters
 */
public class RandomGeneratorTester {
    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 0; i < 10; i++) {
            PlayerCharacter test = new PlayerCharacter(1, "Random","Random","Random");
            test.printSheet();
        }
        System.out.println("\n\n\n\n\n\n\n\n");

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

        System.out.println("\n\n\n\n\n");
        System.out.println("LOCATIONS:\n");

        for (int i = 0; i < 30; i++) {
            System.out.println(RandomNameGenerator.getPlaceName());
        }

        System.out.println("\n\n\n\n\n");
        System.out.println("BACK STORIES:\n");
        PlayerCharacter p1 = new PlayerCharacter(1, "Random","Random","Random");
        PlayerCharacter p2 = new PlayerCharacter(1, "Random","Random","Random");
        PlayerCharacter p3 = new PlayerCharacter(1, "Random","Random","Random");
        System.out.println("----------------------------");
        System.out.println(RandomBackgroundGenerator.getBackstory(p1));
        System.out.println("----------------------------");
        System.out.println(RandomBackgroundGenerator.getBackstory(p2));
        System.out.println("----------------------------");
        System.out.println(RandomBackgroundGenerator.getBackstory(p3));
        System.out.println("----------------------------");
        RandomBackgroundGenerator.testEntity(10);

        System.out.println(PlayerCharacter.rollDice(1, 10));
    }
}
