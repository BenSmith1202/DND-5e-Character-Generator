import java.io.FileNotFoundException;

public class Test {
    /**
     *  This class will now be our place to test random stuff
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        PlayerCharacter p1 = new PlayerCharacter(1,PlayerCharacter.getDwarfName()); //this is cool lol, this constructor works

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
