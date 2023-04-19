import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Ben Smith, David Olinger
 */

public class PlayerCharacter {
    private HashMap<String, Integer> abilityScores = new HashMap(6,75);
    //hashmap of spells needed
    private ArrayList<InventoryItem> inventory = new ArrayList<>();

    //Player stats
    private int maxHealth;
    private int currentHealth;
    private int gold;
    private int armorClass;
    private int speed;
    //Keeps track of failed and succeeded death saves
    private int[] succDS;
    private int[] failDS;


    /**
     * Default Constructor for PlayerCharacter
     */
    public PlayerCharacter(){

    }

    /**
     *  Constructs a character using a file in the proper format to fill out each variable in the character sheet
     * @param fileName = a file containing strings with the proper info to create a character
     */
    public PlayerCharacter(String fileName){

    }

    /** ??????????????????????????????????????????
     * @return ???
     */
    public int getMod(){
        return -1; // stub
    }

    /**
     * rolls a death saving throw, if failed will add to failDS, if suceeded will add to succDS, also acounts for critical rolls of 20
     */
    public void rollDS(){

    }

    /**
     * Clears the death saving throw count arrays after a player has survived
     */
    public void clearDS(){

    }

    /**
     * Prints out the attack roll and potential damage of an attack
     * @param weapon = The weapon that the player is attacking with
     */
    public void attack(Weapon weapon){
         //stub
    }

    /**
     * Returns the attack roll for trying to hit an enemy
     * @param weapon = The weapon that the player is attacking with
     * @return the attack roll
     */
    public int rollToHit(Weapon weapon){
        //stub
        return -1;
    }

    /**
     * Returns the damage a weapon would do if it hits
     * @param weapon = The weapon that the player is attacking with
     * @return number of damage dealt
     */
    public int rollDamage(Weapon weapon){
        //stub
        return -1;
    }

    /**
     * Adds a new Item to the players inventory
     * @param newItem = the item to be added
     */
    public void addItem(InventoryItem newItem){

    }
//            rollAbilityCheck

    /**
     * rolls a d20 for an ability check, calculating with the players ability modifiers
     * @return the total result of the roll
     */
    public int rollAbilityCheck(){
        return -1; //stub
    }
//    rollDie(Number, Sides,  Bonus)

    /**
     * Rolls a set of dice and returns the result
     * @param number = the number of dice being rolled
     * @param sides = the number of sides each of those dice has
     * @param bonus = any bonus being added onto the total dice roll
     * @return the total combined number of the rolled dice
     */
    public int rollDice(int number, int sides, int bonus){
        return -1; //stub
    }


    /**
     * Casts the given spell ????????????????????????
     * @param spell the spell being casts
     */
    public void castSpell(Spell spell){

    }

    /**
     * Returns the amount of gold the player has
     * @return the amount of gold
     */
    public int getGold() {
        return -1; //stub
    }

    /**
     * adds or subtracts gold from the players total gold
     * @param numChange = the amount to be added or subtracted
     */
    public void changeGold(int numChange){

    }

    /**
     * prints out the character sheet of the player in a file
     */
    public void printSheet(){

    }
//+longRest()

    /**
     * performs a long rest, restoring all spell slots and returning health to max
     */
    public void longRest(){

    }
//+shortRest(numHitDice)

    /**
     *
     * @param numHitDice =
     */
    public void shortRest(int numHitDice){

    }




}
