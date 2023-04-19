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
    public PlayerCharacter(String fileName){

    }
    public int getMod(){
        return -1; // stub
    }
//    skill/saving throw checks
//    failDS
//            succDS
    public void rollDS(){

    }
//    clearDS
    public void clearDS(){

    }
    public int rollToHit(){
        return -1;
    }
//    rollDamage(Weapon)returns damage
    public int rollDamage(Weapon weapon){
        return -1; //stub
    }
//    addItem/removeItem
    public void addItem(InventoryItem newItem){

    }
//            rollAbilityCheck
    public int rollAbilityCheck(){
        return -1; //stub
    }
//    rollDie(Number, Sides,  Bonus)
    public int rollDice(int number, int sides, int bonus){
        return -1; //stub
    }
//+castSpell(Spell)
    public void castSpell(Spell spell){

    }
//+getGold
    public int getGold() {
        return -1; //stub
    }

//+changeGold(value)
    public void changeGold(int numChange){

    }
//+printSheet()
    public void printSheet(){

    }
//+longRest()
    public void longRest(){

    }
//+shortRest(numHitDice)
    public void shortRest(int numHitDice){

    }




}
