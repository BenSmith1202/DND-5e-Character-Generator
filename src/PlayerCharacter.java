import java.util.ArrayList;
import java.util.HashMap;

public class PlayerCharacter {
    private HashMap<String, Integer> abilityScores = new HashMap(6,75);
    //hashmap of spells needed
    private ArrayList<InventoryItem> inventory = new ArrayList<>();


    private int maxHealth;
    private int currentHealth;
    private int gold;
    private int armorClass;
    private int speed;

    private int[] deathSave;





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
//    clearDS
//    attack(Weapon)returns damage
//    addItem/removeItem
//            rollAbilityCheck
//    rollDie(Number, Sides,  Bonus)
//+castSpell(Spell)
    public void castSpell(Spell spell){

    }
//+getGold
    public int getGold() {
        return -1; //stub
    }

//+changeGold(value)
    public void changeGold(){

    }
//+printSheet()
    public void printSheet(){

    }
//+longRest()
    public void longRest(){

    }
//+shortRest(numHitDice)




}
