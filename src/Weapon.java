import java.util.Scanner;

/**
 * @author Ben Smith, David Olinger
 * This class simulates a dnd weapon and inherits from InventoryItem
 */
public class Weapon extends InventoryItem {
    private int weaponBonus;
    private int damageDie;
    private int numDamageDice;
    private String weaponType;
    private String damageType;

    /**
     * constructor for a weapon object
     * @param name name of weapon
     * @param weaponBonus bonus to add to attacks
     * @param damageDie number of sides on die
     * @param numDamageDice number of dice
     * @param weaponType strength or dexterity weapon
     * @param damageType slashing/bludgeoning etc.
     */
    public Weapon(int numDamageDice, int damageDie, int weaponBonus, String weaponType, String damageType, String name){
        super(name, 1);
        this.weaponBonus = weaponBonus;
        this.damageDie = damageDie;
        this.numDamageDice = numDamageDice;
        this.weaponType = weaponType;
        this.damageType = damageType;
        //As this is a lengthy and annoying constructor, perhaps we could make another one that just
        //takes in one string and uses regular expressions to extract data from it like "Iron Sword, +1, 2d6, Dexterity, Slashing"
    }
    public Weapon(String weaponString){
        super("", 1);
        Scanner scan = new Scanner(weaponString);
        this.numDamageDice = scan.nextInt();
        this.damageDie = scan.nextInt();
        this.weaponBonus = scan.nextInt();
        this.weaponType = scan.next();
        this.damageType = scan.next();
        super.setName(scan.nextLine().trim());
        //As this is a lengthy and annoying constructor, perhaps we could make another one that just
        //takes in one string and uses regular expressions to extract data from it like "Iron Sword, +1, 2d6, Dexterity, Slashing"
    }


    public int getWeaponBonus() {
        return weaponBonus;
    }

    public int getNumDamageDice() {
        return numDamageDice;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public String toString(){
        return "1" + " " + numDamageDice + " " + damageDie + " " + weaponBonus + " " + weaponType + " " + damageType + " " + super.getName();
    }
    public String toReadableString(){
        return "+" + weaponBonus + " " +super.getName() + " (" + numDamageDice + "d" + damageDie + "+" + weaponBonus +  " " + damageType + " damage)";
    }
    public String getDamageType(){
        return this.damageType;
    }
}
