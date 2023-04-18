public class Weapon extends InventoryItem{

    private int weaponBonus;
    private int damageDie;
    private int numDamageDice;
    private String damageType;

    public Weapon(String name, int quantity, int numDamageDice, int damageDie, int weaponBonus, String damageType) {
        super(name, quantity);
    }

    public int toHit(){
        return -1; //stub
    }

    public int getDamage(){
        return -1;
    }
    //Methods:
//    Constructor(numDice, damageDie, bonus)
//    toHit
//            getDamage



}
