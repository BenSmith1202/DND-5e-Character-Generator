public class Main {
    /**
     * Currently the main method is being used just to test the code in the other methods
     * @param args
     */
    public static void main(String[] args) {
        PlayerCharacter p1 = new PlayerCharacter();
        System.out.println(p1.rollAbilityCheck("Strength"));   // Make sure to spell things correctly lol
        System.out.println(p1.getMod("Dexterity"));


        Weapon sword = new Weapon("sword", 2, 6, 2, "sword", "slashing");
        p1.addItem(sword);
        System.out.println(p1.rollToHit(sword));

        InventoryItem rocks = new InventoryItem("rocks", 5);
        p1.addItem(rocks);

        Spell fireball = new Spell("fireball", 6,8,4,"Dexterity Saving throw DC: idk really");
        p1.addSpell(fireball);

        p1.castAttackSpell(fireball);

        Spell lightingBolt = new Spell("lighting bolt", 6,8,4,"this casts biggy bolty");
        p1.addSpell(lightingBolt);

        p1.printSheet();

        PlayerCharacter fileChar = new PlayerCharacter("FileCharacter.txt");
        fileChar.printSheet();

    }
}
