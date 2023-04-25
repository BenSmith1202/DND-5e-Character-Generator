import java.util.*;

/**
 * @Author: Ben Smith, David Olinger
 */

public class PlayerCharacter {

    private static String[] humanNameSyls = new String[]{"ra", "ba", "lar", "tab", "ga", "ben", "dav", "log", "pre", "car", "rop", "dav", "sar",
    "lit", "pog", "frag", "slag", "pic", "hor", "lee", "smit", "oll", "in", "ger", "di", "kin", "son", "dell", "ing", "er", "win", "rick", "tal",
    "ro", "to", "bo", "ry", "co", "ca", "co", "la" };

    private static String[] dwarfNameSyls = new String[]{"tik", "lik", "dik", "pik", "puk", "duk", "luk", "tuk", "arz", "alz" , "anz", "urz",
    "unz", "ulz", "rok", "nok", "bok", "sok", "ruk", "nuk", "dwar", "vy", "suk", "buk", "enger", "dale", "tal", "mith", "koka", "darl", "karl", "snarl", "barl",
    "jarl", "nug", "rog", "rik", "nik", "pik", "akz", "daye", "mond", "mund", "trund"};

    private static String[] elfNameSyls = new String[]{"dru", "ehr", "grim", "lynn", "wynn", "ev", "eth", "gael", "eltar", "bryl", "jan", "dar",
    "ero", "lith", "gant", "faor", "fho", "fyl", "ha", "la", "ri", "paer", "ril", "thil", "aerm", "aum", "rath", "cali", "ban", "wisp", "bel",
    "droth", "darry", "thor", "idan", "ian", "rian", "lian", "trine", "rina", "dal", "yor", "bel", "naith", "evos", "assin", "lil", "sus" };

    private static String[] elfSurnames = new String[]{"leaf", "branch", "river", "stone", "ice", "flame", "cove", "birch", "oak", "dawn", "dusk",
    "flax", "flood", "gale", "breeze", "zephyr", "air", "sky", "ash", "silk", "vine", "jewel", "pond", "marsh", "moon", "star", "sun", "wild", "tide",
    "heath", "hawk", "reef", "frost", "bud", "jay", "pine", "aspen", "cedar", "grove", "thorn", "wisp", "ink", "rook"};

    private static String[] humanSurnames = new String[]{"wheeler", "chapman", "smith", "olinger", "coward", "dempster", "davis", "fitz", "hurst",
            "shaw", "townsend", "cruikshank", "moody", "lark", "taylor", "butcher", "gouy", "pozu", "heavyarms", "wheezer", "foster", "folger", "trombka",
            "toms", "stanski", "mamajek", "jordan", "arkwright", "brewster", "walker", "marshall", "turner", "johnson", "lister", "lucky", "ebert", "wing"};

    private static String[] dwarfSurnamesModifyer = new String[]{"strong", "steel", "dark", "stormy", "diamond", "ruby", "onyx", "iron", "golden", "stoney",
    "blazing", "slaughter", "war", "lumber", "rock", "splitter", "dwarven", "flinty", "mica", "granite", "marble", "under", "over", "twisted", "welded", "scrawny"};
    private static String[] dwarfSurnamesObject = new String[]{"crown", "sword", "pick", "mine", "gem", "flint", "rock", "armor", "weapon", "tools", "boots", "passage",
    "dwarf", "blade", "edge", "head", "foot", "fist", "fists", "lord", "forge", "field", "drink", "ale", "plow", "beam", "plate", "guard", "gourd", "cheese",
    "wood", "stone", "crystal", "hammer", "chisel", "saw"};
    private String name;
    private int level;
    private HashMap<String, Integer> abilityScores;
    //hashmap of spells needed
    private ArrayList<InventoryItem> inventory;
    private ArrayList<Spell> spells;

    private int[] maxSpellSlots;
    private int[] remainingSpellSlots;

    //Player stats
    private int maxHealth;
    private int currentHealth;
    private int gold;
    private int armorClass;
    private int speed;
    //Keeps track of failed and succeeded death saves
    private int succDS;
    private int failDS;


    /**
     * Default Constructor for PlayerCharacter
     *
     */
    public PlayerCharacter(){
        Random r = new Random();

        abilityScores = new HashMap<>(6); // stub
        abilityScores.put("Strength", 12);
        abilityScores.put("Dexterity", 12);
        abilityScores.put("Constitution", 12);
        abilityScores.put("Intelligence", 12);
        abilityScores.put("Wisdom", 12);
        abilityScores.put("Charisma", 12);

        inventory =  new ArrayList<>();
        spells = new ArrayList<>();

        maxSpellSlots = new int[]{4, 3, 3, 1, 0, 0, 0, 0, 0};
        remainingSpellSlots = new int[9];

        this.name = "Test Character";
        this.level = 1;
        this.maxHealth = 8 + getMod("Constitution") + rollDice(level-1, 8, getMod("Constitution"));
        this.gold = 10* rollDice(5, 4);
        this.armorClass = 10+getMod("Dexterity"); //must always spell out full word or it don't work, unless we want to implement that
        this.speed = 30;

        this.succDS = 0;
        this.failDS = 0;


        //at the end
        longRest();
    }

    /**
     *  Constructs a character using a file in the proper format to fill out each variable in the character sheet
     * @param fileName = a file containing strings with the proper info to create a character
     */
    public PlayerCharacter(String fileName){
        inventory =  new ArrayList<>();
        spells = new ArrayList<>();

        abilityScores = new HashMap<>(6);

        Scanner scnr = new Scanner(fileName);

        scnr.next();
        name = scnr.nextLine();
        scnr.next();
        level = scnr.nextInt();
        scnr.nextLine();
        scnr.next();
        maxHealth = scnr.nextInt();
        scnr.nextLine();
        scnr.next();
        speed = scnr.nextInt();
        scnr.nextLine();
        scnr.next();
        armorClass = scnr.nextInt();
        scnr.nextLine();
        scnr.next();
        gold = scnr.nextInt();

        for (int i = 0; i < 6; i++) {
            abilityScores.put(scnr.next(), scnr.nextInt());
            scnr.nextLine();
        }




        succDS = 0;
        failDS = 0;
        currentHealth = maxHealth;
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
        if (roll == 1){
            failDS += 2;
        } else if (roll == 20){
            succDS = 3;
        } else if (roll < 10){
            failDS++;
        } else succDS++;
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
        System.out.println("Roll to hit = " + rollToHit(weapon));
        System.out.println("Damage dealt on hit = " + rollDamage(weapon));
    }

    /**
     * Returns the attack roll for trying to hit an enemy
     * @param weapon = The weapon that the player is attacking with
     * @return the attack roll
     */
    public int rollToHit(Weapon weapon){
        return PlayerCharacter.rollDice(1, 20, weapon.getWeaponBonus());
    }

    /**
     * Returns the damage a weapon would do if it hits
     * @param weapon = The weapon that the player is attacking with
     * @return number of damage dealt
     */
    public int rollDamage(Weapon weapon){
        return PlayerCharacter.rollDice(weapon.getNumDamageDice(), weapon.getDamageDie(), weapon.getWeaponBonus()) +
                getMod(weapon.getWeaponType());
    }

    /**
     * Adds a new Item to the player's inventory
     * @param newItem = the item to be added
     */
    public void addItem(InventoryItem newItem){
        inventory.add(newItem);
    }
    /**
     * Adds a new Item to the player's inventory
     * @param newItem = the item to be added
     */
    public void RemoveItem(InventoryItem newItem){
        inventory.remove(newItem);
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
        if (roll < 1){
            return 1;
        }
        else return roll;
    }
//    rollDie(Number, Sides,  Bonus)

    /**
     * Rolls a set of dice and returns the result
     * @param number = the number of dice being rolled
     * @param sides = the number of sides each of those dice has
     * @param bonus = any bonus being added onto the total dice roll
     * @return the total combined number of the rolled dice
     */
    public static int rollDice(int number, int sides, int bonus){
        Random r = new Random();
        int total = 0;
        for (int i = 0; i < number; i++) {
            total += r.nextInt(1,sides+1);
        }
        total += bonus;
        return total;
    }

    public static int rollDice(int number, int sides){
        Random r = new Random();
        int total = 0;
        for (int i = 0; i < number; i++) {
            total += r.nextInt(1,sides+1);
        }

        return total;
    }


    /**
     * Casts the given spell
     * @param spell the spell being casts
     */
    public void castAttackSpell(Spell spell){
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
    /**
     * Returns the attack roll for trying to hit an enemy
     * @param spell = The spell that the player is casting
     * @return the attack roll
     */


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
        System.out.println("-----------------------------------------------");
        System.out.println("Name: " + name +   "            Level: " + level);
        System.out.println("Speed: " + speed + "            Armor Class: " + armorClass);
        System.out.println("Hit Points: " + currentHealth+"/"+maxHealth + "            Death Saves (S/F): " + succDS+"/"+failDS);
        System.out.println("Gold: " + gold);

        System.out.println("Strength: " + abilityScores.get("Strength") + "(+" + getMod("Strength")+ ")" + "       " +
                "Dexterity: " + abilityScores.get("Dexterity") + "(+" + getMod("Dexterity")+ ")" + "      " +
                "Constitution: " + abilityScores.get("Constitution") + "(+" + getMod("Constitution")+ ")");
        System.out.println("Intelligence: " + abilityScores.get("Intelligence") + "(+" + getMod("Intelligence")+ ")" + "     " +
                "Wisdom: " + abilityScores.get("Wisdom") + "(+" + getMod("Wisdom")+ ")" + "     " +
                "Charisma: " + abilityScores.get("Charisma") + "(+" + getMod("Charisma")+ ")");

        System.out.print("Inventory: ");
        if (inventory.size() == 0) System.out.print("Empty");
        for (int i = 0; i < inventory.size(); i++) {
            if (i>0) System.out.print(", ");
            System.out.print(inventory.get(i).getQuantity() + " " + inventory.get(i).getName());
        }
        System.out.println();
        System.out.print("Spells: ");
        if (spells.size() == 0) System.out.print("Empty");
        for (int i = 0; i < spells.size(); i++) {
            if (i>0) System.out.print(", ");
            System.out.print(spells.get(i).getName());
        }

    }

    public static String getDwarfName(){
        StringBuilder firstNameBuilder = new StringBuilder();
        StringBuilder lastNameBuilder = new StringBuilder();
        Random random = new Random();
        int r = random.nextInt(2);
        if (r == 1){
            firstNameBuilder.append(dwarfNameSyls[(random.nextInt(dwarfNameSyls.length))]);
            firstNameBuilder.append(dwarfNameSyls[(random.nextInt(dwarfNameSyls.length))]);
            firstNameBuilder.append(" ");
        } else {
            firstNameBuilder.append(dwarfNameSyls[(random.nextInt(dwarfNameSyls.length))]);
            firstNameBuilder.append(dwarfNameSyls[(random.nextInt(dwarfNameSyls.length))]);
            firstNameBuilder.append(dwarfNameSyls[(random.nextInt(dwarfNameSyls.length))]);
            firstNameBuilder.append(" ");
        }
        String firstName = firstNameBuilder.substring(0,1).toUpperCase() + firstNameBuilder.substring(1);
        lastNameBuilder.append(dwarfSurnamesModifyer[(random.nextInt(dwarfSurnamesModifyer.length))]);
        lastNameBuilder.append(dwarfSurnamesObject[(random.nextInt(dwarfSurnamesObject.length))]);
        return firstName + lastNameBuilder.substring(0,1).toUpperCase() + lastNameBuilder.substring(1);
    }

    public static String getHumanName(){
        StringBuilder firstNameBuilder = new StringBuilder();
        StringBuilder lastNameBuilder = new StringBuilder();
        Random random = new Random();
        int r = random.nextInt(2);
        if (r == 1){
            firstNameBuilder.append(humanNameSyls[(random.nextInt(humanNameSyls.length))]);
            firstNameBuilder.append(humanNameSyls[(random.nextInt(humanNameSyls.length))]);
            firstNameBuilder.append(" ");
        } else {
            firstNameBuilder.append(humanNameSyls[(random.nextInt(humanNameSyls.length))]);
            firstNameBuilder.append(humanNameSyls[(random.nextInt(humanNameSyls.length))]);
            firstNameBuilder.append(humanNameSyls[(random.nextInt(humanNameSyls.length))]);
            firstNameBuilder.append(" ");
        }
        String firstName = firstNameBuilder.substring(0,1).toUpperCase() + firstNameBuilder.substring(1);
        lastNameBuilder.append(humanSurnames[(random.nextInt(humanSurnames.length))]);
        return firstName + lastNameBuilder.substring(0,1).toUpperCase() + lastNameBuilder.substring(1);
    }

    public static String getElfName(){
        StringBuilder firstNameBuilder = new StringBuilder();
        StringBuilder lastNameBuilder = new StringBuilder();
        Random random = new Random();
        int r = random.nextInt(2);
        if (r == 1){
            firstNameBuilder.append(elfNameSyls[(random.nextInt(elfNameSyls.length))]);
            firstNameBuilder.append(elfNameSyls[(random.nextInt(elfNameSyls.length))]);
            firstNameBuilder.append(" ");
        } else {
            firstNameBuilder.append(elfNameSyls[(random.nextInt(elfNameSyls.length))]);
            firstNameBuilder.append(elfNameSyls[(random.nextInt(elfNameSyls.length))]);
            firstNameBuilder.append(elfNameSyls[(random.nextInt(elfNameSyls.length))]);
            firstNameBuilder.append(" ");
        }
        String firstName = firstNameBuilder.substring(0,1).toUpperCase() + firstNameBuilder.substring(1);
        lastNameBuilder.append(elfSurnames[(random.nextInt(elfSurnames.length))]);
        lastNameBuilder.append(elfSurnames[(random.nextInt(elfSurnames.length))]);
        return firstName + lastNameBuilder.substring(0,1).toUpperCase() + lastNameBuilder.substring(1);
    }


    /**
     * performs a long rest, restoring all spell slots and returning health to max
     */
    public void longRest(){
        currentHealth = maxHealth;
        for (int i = 0; i < 9; i++) {
            remainingSpellSlots[i] = maxSpellSlots[i];
        }

    }


    /**
     *
     * @param numHitDice =
     */
    public void shortRest(int numHitDice){

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
    }
}
