import java.io.FileNotFoundException;

public class ThreeCharOptions {
    public static void main(String[] args) throws FileNotFoundException {
        String[] races = new String[]{"Elf", "Dwarf", "Human"};
        PlayerCharacter option1;
        switch (getRandom(races)){
            case "Elf" -> option1 = new PlayerCharacter(3, RandomNameGenerator.getElfName(), "Elf", "Random");
            case "Dwarf" -> option1 = new PlayerCharacter(3, RandomNameGenerator.getDwarfName(), "Dwarf", "Random");
            case "Human" -> option1 = new PlayerCharacter(3, RandomNameGenerator.getHumanName(), "Human", "Random");
            default -> option1 = new PlayerCharacter(3, RandomNameGenerator.getHumanName(), "Human", "Random");

        }
        PlayerCharacter option2;
        switch (getRandom(races)){
            case "Elf" -> option2 = new PlayerCharacter(3, RandomNameGenerator.getElfName(), "Elf", "Random");
            case "Dwarf" -> option2 = new PlayerCharacter(3, RandomNameGenerator.getDwarfName(), "Dwarf", "Random");
            case "Human" -> option2 = new PlayerCharacter(3, RandomNameGenerator.getHumanName(), "Human", "Random");
            default -> option2 = new PlayerCharacter(3, RandomNameGenerator.getHumanName(), "Human", "Random");
        }
        PlayerCharacter option3;
        switch (getRandom(races)){
            case "Elf" -> option3 = new PlayerCharacter(3, RandomNameGenerator.getElfName(), "Elf", "Random");
            case "Dwarf" -> option3 = new PlayerCharacter(3, RandomNameGenerator.getDwarfName(), "Dwarf", "Random");
            case "Human" -> option3 = new PlayerCharacter(3, RandomNameGenerator.getHumanName(), "Human", "Random");
            default -> option3 = new PlayerCharacter(3, RandomNameGenerator.getHumanName(), "Human", "Random");
        }

        System.out.println("Option 1:\n-------------------------------");
        option1.printSheet();
        System.out.println("Backstory:");
        System.out.println(RandomBackgroundGenerator.getBackstory(option1));
        System.out.println("\n\n\n");

        System.out.println("Option 2:\n-------------------------------");
        option2.printSheet();
        System.out.println("Backstory:");
        System.out.println(RandomBackgroundGenerator.getBackstory(option2));
        System.out.println("\n\n\n");


        System.out.println("Option 3:\n-------------------------------");
        option3.printSheet();
        System.out.println("Backstory:");
        System.out.println(RandomBackgroundGenerator.getBackstory(option3));

        //PlayerCharacter option1 = new PlayerCharacter(3, RandomNameGenerator., race, "Random");
    }
    private static String getRandom(String[] array) { //returns a random String from an array
        int index = (int)(Math.round(Math.random() * (array.length-1)));
        return array[index];

    }
}
