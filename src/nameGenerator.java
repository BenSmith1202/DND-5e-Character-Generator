public class nameGenerator {
    public static void main(String[] args) {
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
    }
}
