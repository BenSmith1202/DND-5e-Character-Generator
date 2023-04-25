import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    /**
     * Currently the main method is being used just to test the code in the other methods
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        PlayerCharacter p1 = new PlayerCharacter();

        PlayerCharacter p2 = new PlayerCharacter("FileCharacter.txt");
        p2.printSheet();

        Weapon sword = new Weapon("sword", 2, 6, 2, "sword", "slashing");
        p2.addItem(sword);
        InventoryItem rocks = new InventoryItem("rocks", 5);
        p2.addItem(rocks);
        Spell fireball = new Spell("fireball", 6,8,4,"Dexterity Saving throw DC: idk really");
        p2.addSpell(fireball);
        Spell lightingBolt = new Spell("lighting bolt", 6,8,4,"this casts biggy bolty");
        p2.addSpell(lightingBolt);


        p2.printSheet();
        p1.printSheet();


//        System.out.println(p2.rollToHit(sword));
        System.out.println();
        p2.castAttackSpell(fireball);
        System.out.println();
        p2.attack(sword);


    }
}
