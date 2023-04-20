import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: Ben Smith, David Olinger
 */

public class PlayerCharacter {
    private HashMap<String, Integer> abilityScores;
    //hashmap of spells needed
    private ArrayList<InventoryItem> inventory;

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
        this.maxHealth = r.nextInt(20); // stub
        this.currentHealth = maxHealth;
        this.gold = r.nextInt(20); // stub
        this.armorClass = r.nextInt(10,18); // stub
        this.speed = r.nextInt(4,9) * 5; // stub

        this.succDS = 0;
        this.failDS = 0;

        abilityScores = new HashMap<>(6); // stub
        abilityScores.put("Strength", 12);
        abilityScores.put("Dexterity", 12);
        abilityScores.put("Constitution", 12);
        abilityScores.put("Intelligence", 12);
        abilityScores.put("Wisdom", 12);
        abilityScores.put("Charisma", 12);

        inventory =  new ArrayList<>();
    }

    /**
     *  Constructs a character using a file in the proper format to fill out each variable in the character sheet
     * @param fileName = a file containing strings with the proper info to create a character
     */
    public PlayerCharacter(String fileName){
        Scanner scnr = new Scanner(fileName);
            //stub this will read through the text the way we want it to, filling out each variable and stuff

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
        System.out.println(weapon.toHit());
        System.out.println(weapon.getDamage());
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
     * Adds a new Item to the players inventory
     * @param newItem = the item to be added
     */
    public void addItem(InventoryItem newItem){
        inventory.add(newItem); // stub idk if this is right
    }

    /**
     * rolls a d20 for an ability check, calculating with the players ability modifiers
     * @return the total result of the roll
     */
    public int rollAbilityCheck(String ability){return rollDice(1,20,getMod(ability)); //stub
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
