import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Ben Smith, David Olinger
 * This class simulates a dnd character sheet, keeping track of player stats, inventory, and spell list. It can be constructed randomly
 * Or by sending in a formatted file that has either been pre-made or saved from the character sheet.
 */

public class PlayerCharacter {
    private String name;
    private String persona;
    private int level;
    private HashMap<String, Integer> abilityScores;
    private HashMap<String,Integer> hitDieOptions;
    //hashmap of spells needed
    private ArrayList<InventoryItem> inventory;
    private ArrayList<Spell> spells;
    private int[] maxSpellSlots;
    private int[] remainingSpellSlots;

    //Player stats
    private int maxHealth, currentHealth, gold, armorClass, speed, succDS, failDS, hitDie; //we can just declare these all at once
    private String alignment; //a two character alignment with the form '[L, N, or C][G, N, or E]'.
    private String characterClass;
    private String race;

    private String backstory;

    private static String[] abilityList = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};




    /**
     * Default Constructor for PlayerCharacter: Randomly generated stats and inventory
     *
     */
    public PlayerCharacter(int level, String inputName, String race, String inputClass) throws FileNotFoundException {
        backstory = "There is nothing here now, but you can generate a backstory from the main menu";

        abilityScores = new HashMap<>(6); // roll all the stats
        abilityScores.put("Strength", rollCharacterStats());
        abilityScores.put("Dexterity", rollCharacterStats());
        abilityScores.put("Constitution", rollCharacterStats());
        abilityScores.put("Intelligence", rollCharacterStats());
        abilityScores.put("Wisdom", rollCharacterStats());
        abilityScores.put("Charisma", rollCharacterStats());

        Random r = new Random();
        if (race.equals("Random")){
            this.race = switch (r.nextInt(1,4)){
                case 1 -> "Dwarf";
                case 2 -> "Elf";
                case 3 -> "Human";
                default -> "";
            };
        } else this.race = race;

        switch (race){ //grants racial stat bonuses, uses high elf, mountain dwarf, and standard human
            case "Elf" -> {this.speed = 35; abilityScores.put("Dexterity", abilityScores.get("Dexterity") + 2);
                abilityScores.put("Intelligence", abilityScores.get("Intelligence") + 1);}
            case "Dwarf" -> {this.speed = 25; abilityScores.put("Constitution", abilityScores.get("Constitution") + 2);
                abilityScores.put("Strength", abilityScores.get("Strength") + 2);}
            case "Human" -> {this.speed = 30; for (String stat : abilityList) {abilityScores.put(stat, abilityScores.get(stat) + 1);} }
        }


        hitDieOptions = new HashMap<>(6);
        hitDieOptions.put("Barbarian",12);
        hitDieOptions.put("Fighter",10);
        hitDieOptions.put("Rogue",8);
        hitDieOptions.put("Wizard",6);
        hitDieOptions.put("Sorcerer",6);
        hitDieOptions.put("Bard",8);

        abilityList = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};


        inventory =  new ArrayList<>();
        File starterItems = new File("starterItems.txt"); //open file for starting items
        Scanner checkStartingItems = new Scanner(starterItems); //checks how many items are in the Starting items file so we don't have to
        int starterItemsLen = 0;
        while (checkStartingItems.hasNextLine()){
            starterItemsLen++;
            checkStartingItems.nextLine();
        }
        checkStartingItems.close();

        for (int i = 0; i < 8; i++) {
            Scanner scan = new Scanner(starterItems);
            for (int j = 0; j < rollDice(1, starterItemsLen-1); j++) { //sides is number of lines in file -1
                scan.nextLine(); //cycle to a random line
            }
            inventory.add(new InventoryItem(scan.nextLine())); //add what's on that line
            scan.close();
        }

        File trinkets = new File("trinketsList.txt"); //open file for trinkets
        Scanner checkTrinkets = new Scanner(trinkets); //checks how many items are in the trinkets file so that we don't have to
        int trinketsLen = 0;
        while (checkTrinkets.hasNextLine()){
            trinketsLen++;
            checkTrinkets.nextLine();
        }
        checkTrinkets.close();


        Scanner scan = new Scanner(trinkets);
        for (int j = 0; j < rollDice(1, trinketsLen-1); j++) { //sides is number of lines in file -1
            scan.nextLine(); //cycle to a random line

        }
        inventory.add(new InventoryItem(scan.nextLine())); //add what's on that line
        scan.close();


        spells = new ArrayList<>();

        maxSpellSlots = new int[]{4, 3, 3, 1, 0, 0, 0, 0, 0}; //sets max spell slots
        remainingSpellSlots = new int[9];


        this.level = level;
        this.gold = 10* rollDice(5, 4);
        this.armorClass = 10 + getMod("Dexterity");
        if (!inputClass.equals("Random")) {
            this.characterClass = inputClass;
        } else {
            String highStat = "";
            int highStatNum = 0;
            for (int i = 0; i < 6; i++) {
                if (abilityScores.get(abilityList[i]) > highStatNum){
                    highStatNum = abilityScores.get(abilityList[i]);
                    highStat = abilityList[i];
                } else if (abilityScores.get(abilityList[i]) == highStatNum){
                    int random = rollDice(1,2);
                    if (random == 2) {
                        highStat = abilityList[i];  // if 2 stats tie it picks between one at random
                    }
                }
            }
            switch (highStat) {
                case "Strength" -> characterClass = "Fighter";
                case "Dexterity" -> characterClass = "Rogue";
                case "Constitution" -> characterClass = "Barbarian";
                case "Intelligence" -> characterClass = "Wizard";
                case "Wisdom" -> characterClass = "Sorcerer";
                case "Charisma" -> characterClass = "Bard";
            }
        }
        this.hitDie = hitDieOptions.get(characterClass);
        this.maxHealth = hitDie + rollDice(level-1, hitDie) + (level*getMod("Constitution"));

        if (!inputName.equals("Random")){
            this.name = inputName;
        } else {
            this.name = switch (this.race) {
                case "Dwarf" -> RandomNameGenerator.getDwarfName();
                case "Elf" -> RandomNameGenerator.getElfName();
                case "Human" -> RandomNameGenerator.getHumanName();
                default -> "";
            };
        }

        this.succDS = 0;
        this.failDS = 0;

        String[] ali1 = new String[] {"L", "N", "C"};
        String[] ali2 = new String[] {"G", "N", "E"};
        alignment = ali1[PlayerCharacter.rollDice(1, 3)-1] + ali2[PlayerCharacter.rollDice(1, 3)-1]; //gets a random two character alignment.
        persona = RandomPersonaGenerator.getPersona(this); //stores a random personality based on the random alignment.

        longRest(); //resets expendable stats to max.
    }


    /**
     *  Constructs a character using a file in the proper format to fill out each variable in the character sheet
     * @param fileName = a file containing strings with the proper info to create a character
     */
    public PlayerCharacter(String fileName) throws FileNotFoundException {
        backstory = "There is nothing here now, but you can generate a backstory from the main menu";

        inventory = new ArrayList<>();
        spells = new ArrayList<>();

        maxSpellSlots = new int[]{4, 3, 3, 1, 0, 0, 0, 0, 0};
        remainingSpellSlots = new int[9];

        abilityScores = new HashMap<>(6);

        File f = new File(fileName);
        Scanner scan = new Scanner(f);

        scan.next();
        name = scan.nextLine();
        scan.next();
        level = scan.nextInt();
        scan.nextLine();
        scan.next();
        maxHealth = scan.nextInt();
        scan.nextLine();
        scan.next();
        speed = scan.nextInt();
        scan.nextLine();
        scan.next();
        armorClass = scan.nextInt();
        scan.nextLine();
        scan.next();
        characterClass = scan.next();
        scan.nextLine();
        scan.next();
        race = scan.next();
        scan.nextLine();
        scan.next();
        gold = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < 6; i++) {
            abilityScores.put(scan.next(), scan.nextInt());
            scan.nextLine();
        }
        scan.next();
        alignment = scan.next();
        scan.nextLine();
        scan.nextLine();
        persona = "";
        for (int i = 0; i < 8; i++) {
            persona += scan.nextLine() + "\n";
        }
        scan.nextLine(); //skip inventory header
        //Inventory
        while (scan.hasNextInt()){
            Scanner scanline = new Scanner(scan.nextLine());
            int quantity = scanline.nextInt();
            if (scanline.hasNextInt()){
                InventoryItem weap = new Weapon(scanline.nextInt(), scanline.nextInt(), scanline.nextInt(), scanline.next(), scanline.next(), scanline.nextLine());
                inventory.add(weap);
            } else {
                inventory.add(new InventoryItem(scanline.nextLine(), quantity));
            }
        }
        scan.nextLine();
        backstory = scan.nextLine();
        while (scan.hasNextLine()){
            backstory = "\n" + backstory + scan.nextLine();
        }

        currentHealth = maxHealth;
        this.succDS = 0;
        this.failDS = 0;

        longRest();
    }


    /**
     * Returns the modifier that the player will get on an ability based on their score
     * @param = the ability in AbilityScores that will be calculated with
     * @return The ability modifier number
     */
    public int getMod(String ability){
        return (abilityScores.get(ability) - 10) / 2;
    }


    /**
     * rolls a death saving throw, if failed will add to failDS, if suceeded will add to succDS, also acounts for critical rolls of 20
     */
    public void rollDS(){
        int roll = rollDice(1,20,0);
        System.out.println("Death Save Roll = " + roll);
        if (roll == 1){
            failDS += 2;
            System.out.println("Critical Failure!");
        } else if (roll == 20){
            succDS = 3;
            System.out.println("Critical Success!");
        } else if (roll < 10){
            failDS++;
            System.out.println("Failure");
        } else {
            succDS++;
            System.out.println("Success");
        }
        if (succDS >= 3){
            System.out.println("You stabilize");
            clearDS();
        } else if (failDS >= 3){
            System.out.println("You Died");
            clearDS();
        } else System.out.println("fails: " + failDS + "\nsuccesses: " + succDS);
    }


    /**
     * Clears the death saving throw count arrays after a player has survived
     */
    public void clearDS(){
        failDS = 0;
        succDS = 0;
    }


    /**
     * Prints out the attack roll and potential damage of an attack
     * @param weapon = The weapon that the player is attacking with
     */
    public void attack(Weapon weapon){
        System.out.println("Attacking with " + weapon.getName() + ":"); // Need to Implement Crits now
        System.out.println("Roll to hit = " + rollToHit(weapon));
        System.out.println("Damage dealt on hit = " + rollDamage(weapon));
    }


    /**
     * Prints out the attack roll and potential damage of an attack, taken from a name string
     * @param weaponName = The name of the weapon that the player is attacking with
     */
    public void attack(String weaponName){
        for (InventoryItem inventoryItem : inventory) {
            if (weaponName.equals(inventoryItem.getName())) {
                attack((Weapon) inventoryItem);
            }
        }
    }


    /**
     * Returns the attack roll for trying to hit an enemy
     * @param weapon = The weapon that the player is attacking with
     * @return the attack roll
     */
    public int rollToHit(Weapon weapon){
        return PlayerCharacter.rollDice(1, 20, weapon.getWeaponBonus() + getMod("Strength"));
    }


    /**
     * Returns the damage a weapon would do if it hits
     * @param weapon = The weapon that the player is attacking with
     * @return number of damage dealt
     */
    public int rollDamage(Weapon weapon){
        return PlayerCharacter.rollDice(weapon.getNumDamageDice(), weapon.getDamageDie(), weapon.getWeaponBonus());
    }


    /**
     * Adds a new Item to the player's inventory
     * @param newItem = the item to be added
     */
    public void addItem(InventoryItem newItem){
        inventory.add(newItem);
    }
    public void addItem(String itemString){
        InventoryItem newItem = new InventoryItem(itemString);
        inventory.add(newItem);
    }


    /**
     * removes an Item from the player's inventory
     * @param item = the item to be removed
     */
    public void RemoveItem(InventoryItem item){
        inventory.remove(item);
    }


    /**
     * Adds a new spell to the player's spells
     * @param newSpell = the spell to be added
     */
    public void addSpell(Spell newSpell){
        spells.add(newSpell);
    }


    /**
     * rolls a d20 for an ability check, calculating with the players ability modifiers
     * @return the total result of the roll
     */
    public int rollAbilityCheck(String ability){
        int roll = rollDice(1,20,getMod(ability));
        return Math.max(roll, 1);
    }


    /**
     * Rolls a set of dice and returns the result
     * @param number = the number of dice being rolled
     * @param sides = the number of sides each of those dice has
     * @param bonus = any bonus being added onto the total dice roll
     * @return the total combined number of the rolled dice
     */
    public static int rollDice(int number, int sides, int bonus) {
        Random r = new Random();
        int total = 0;
        for (int i = 0; i < number; i++) {
            total += r.nextInt(1,sides+1);
        }
        total += bonus;
        return total;
    }


    /**
     * Rolls a set of dice and returns the result, doesn't use bonus
     * @param number = the number of dice being rolled
     * @param sides = the number of sides each of those dice has
     * @return the total combined number of the rolled dice
     */
    public static int rollDice(int number, int sides){
        Random r = new Random();
        int total = 0;
        for (int i = 0; i < number; i++) {
            total += r.nextInt(1,sides+1);
        }

        return total;
    }


    public static int rollCharacterStats(){
        int total = 0;
        int lowest = 7;
        for (int i = 0; i < 4; i++) {
            int num = rollDice(1, 6);
            if (num < lowest){
                lowest = num;
            }
            total += num;
        }
        total -= lowest;

        return total;
    }


    /**
     * Casts the given spell
     * @param spell the spell being casts
     */
    public void castAttackSpell(Spell spell){
        System.out.println("Casting " + spell.getName() + ":");
        System.out.println(spell.getAffect());
        System.out.println("Damage dealt on hit = " + rollDamage(spell));
    }


    /**
     * Casts the given spell
     * @param spell the spell being casts
     */
    public void castSpell(Spell spell){
        System.out.println(spell.getAffect());
    }
    public void castSpell(String spellName, boolean attackSpell){
        for (int i = 0; i < spells.size(); i++) {
            if (spellName.equals(spells.get(i).getName())){
                if (attackSpell){
                    castAttackSpell(spells.get(i));
                } else {
                castSpell(spells.get(i));
                }
            }
        }
    }


    /**
     * Returns the damage a spell would do if it hits
     * @param spell = The spell that the player is casting
     * @return number of damage dealt
     */
    public int rollDamage(Spell spell){
        return PlayerCharacter.rollDice(spell.getNumDamageDice(), spell.getDamageDie(), 0); // idk how spell bonus works
    }


    /**
     * Returns the amount of gold the player has
     * @return the amount of gold
     */
    public int getGold() {
        return this.gold;
    }


    /**
     * adds or subtracts gold from the players total gold
     * @param numChange = the amount to be added or subtracted
     */
    public void changeGold(int numChange){
        this.gold += numChange;
    }


    /**
     * prints out the character sheet of the player in a file
     */
    public void printSheet(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Name: " + name + "     Race: " + race + "      Class: " + characterClass +
                "     Level: " + level + "    Alignment: " + alignment);
        System.out.println("Speed: " + speed + "              Armor Class: " + armorClass);
        System.out.println("Hit Points: " + currentHealth+"/"+maxHealth + "       Death Saves (S/F): " + succDS+"/"+failDS);
        System.out.println("Gold: " + gold);

        System.out.println("Strength: " + abilityScores.get("Strength") + "(" + getMod("Strength")+ ")" + "       " +
                "Dexterity: " + abilityScores.get("Dexterity") + "(" + getMod("Dexterity")+ ")" + "   " +
                "Constitution: " + abilityScores.get("Constitution") + "(" + getMod("Constitution")+ ")");
        System.out.println("Intelligence: " + abilityScores.get("Intelligence") + "(" + getMod("Intelligence")+ ")" + "   " +
                "Wisdom: " + abilityScores.get("Wisdom") + "(" + getMod("Wisdom")+ ")" + "      " +
                "Charisma: " + abilityScores.get("Charisma") + "(" + getMod("Charisma")+ ")");

        System.out.println(persona + "\n");

        System.out.print("Inventory: ");
        if (inventory.size() == 0) System.out.println("Empty");
        else {
            System.out.print("\n");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i+1) + ". " + inventory.get(i).getQuantity() + "x " + inventory.get(i).getName());
            }
            System.out.println();
        }

        System.out.print("Spells: ");
        if (spells.size() == 0) System.out.println("Empty");
        else {
            for (int i = 0; i < spells.size(); i++) {
                if (i > 0) System.out.print("i");
                System.out.print(spells.get(i).getName());
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------");
    }


    /**
     * performs a long rest, restoring all spell slots and returning health to max
     */
    public void longRest(){
        currentHealth = maxHealth;
        System.arraycopy(maxSpellSlots, 0, remainingSpellSlots, 0, 9);

    }


    /**
     * restores a number of hit points appropriate for a short rest.
     * @param numHitDice the number of hit dice to use during the rest
     */
    public void shortRest(int numHitDice){
        currentHealth += PlayerCharacter.rollDice(8, 8);
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void changeHealth(int change) {
        this.currentHealth += change;
        if (currentHealth > maxHealth){
            currentHealth = maxHealth;
        }
        System.out.println("Updated health: " + currentHealth + "/" + maxHealth);
    }

    public void saveCharacter(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        PrintWriter pw = new PrintWriter(f);

        pw.print("Name: ");
        pw.println(name);

        pw.print("Level: ");
        pw.println(level);

        pw.print("MaxHealth: ");
        pw.println(maxHealth);

        pw.print("Speed: ");
        pw.println(speed);

        pw.print("ArmorClass: ");
        pw.println(armorClass);

        pw.print("Class: ");
        pw.println(characterClass);

        pw.print("Race: ");
        pw.println(race);

        pw.print("Gold: ");
        pw.println(gold);

        for (int i = 0; i < 6; i++) {
            pw.print(abilityList[i] + " ");
            pw.println(abilityScores.get(abilityList[i]));
        }
        pw.print("Alignment ");
        pw.println(alignment);

        pw.print(persona);

        pw.println("Inventory:");
        for (InventoryItem i : inventory) {
            pw.println(i);
        }
        pw.println("Backstory:");
        pw.println(backstory);

        pw.close();
        }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public String getBackstory() {
        return backstory;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getAlignment() {
        return alignment;
    }
}
