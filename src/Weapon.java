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
    public Weapon(String name, int weaponBonus, int damageDie, int numDamageDice, String weaponType, String damageType){
        super(name, 1);
        this.weaponBonus = weaponBonus;
        this.damageDie = damageDie;
        this.numDamageDice = numDamageDice;
        this.weaponType = weaponType;
        this.damageType = damageType;
        //As this is a lengthy and annoying constructor, perhaps we could make another one that just
        //takes in one string and uses regular expressions to extract data from it like "Iron Sword, +1, 2d6, Dexterity, Slashing"
    }

    /**
     *
     * @return returns the roll to hit value
     */
    public int toHit(){
        return -1;
    } //delete this comment

    /**
     *
     * @return the total damage dealt
     */
    public int getDamage(){
        return -1;
    }
}
