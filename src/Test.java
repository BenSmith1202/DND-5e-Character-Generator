import java.io.FileNotFoundException;

public class Test {
    /**
     *  This class will now be our place to test random stuff
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
//
//        PlayerCharacter p1 = new PlayerCharacter(1, RandomNameGenerator.getDwarfName(),"Dwarf","Bard");
//
//
//        Weapon sword = new Weapon("sword", 2, 6, 2, "sword", "slashing");
//        p2.addItem(sword);
//        InventoryItem rocks = new InventoryItem("rocks", 5);
//        p2.addItem(rocks);
//        Spell fireball = new Spell("fireball", 6,8,4,"Dexterity Saving throw DC: idk really");
//        p2.addSpell(fireball);
//        Spell lightingBolt = new Spell("lighting bolt", 6,8,4,"this casts biggy bolty");
//        p2.addSpell(lightingBolt);
//        Spell becomeFrog = new Spell("becomeFrog", 2,"you become a frog");
//        p2.addSpell(becomeFrog);
//
//
//        p2.castAttackSpell(fireball);
//        System.out.println();
//        p2.attack(sword);
//        System.out.println();
//        p2.castSpell(becomeFrog);
//
//        p2.printSheet();
//        p1.printSheet();

        PlayerCharacter p2 = new PlayerCharacter("FileCharacter.txt");
        p2.printSheet();

        for (int i = 0; i < 10; i++) {
            PlayerCharacter test = new PlayerCharacter(1, "Random","Random","Random");
            test.printSheet();
        }

        PlayerCharacter test = new PlayerCharacter(1, "Random","Random","Random");
        test.printSheet();
        test.saveCharacter();
//
//        PlayerCharacter savedChar = new PlayerCharacter("output.txt");
//        savedChar.printSheet();




    }
}
