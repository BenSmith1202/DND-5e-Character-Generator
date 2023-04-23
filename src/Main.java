public class Main {
    /**
     * Currently the main method is being used just to test the code in the other methods
     * @param args
     */
    public static void main(String[] args) {
        PlayerCharacter p1 = new PlayerCharacter();
        System.out.println(p1.rollAbilityCheck("Strength"));   // Make sure to spell things correctly lol
        System.out.println(p1.getMod("Dexterity"));


                 // I made abilityScores public to test these



        Weapon sword = new Weapon("sword", 2, 6, 2, "sword", "slashing");
        p1.addItem(sword);
        System.out.println(p1.rollToHit(sword));
        p1.printSheet();

    }
}
