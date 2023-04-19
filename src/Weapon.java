public class Weapon extends InventoryItem {
    private int weaponBonus;
    private int damageDie;
    private int numDamageDice;
    private String weaponType;
    private String damageType;

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

    public int toHit(){
        return -1;
    } //delete this comment

    public int getDamage(){
        return -1;
    }
}
