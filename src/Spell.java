/**
 * @author Ben Smith, David Olinger
 * This class simulates a dnd spell in an abstract form, storing what the spell does and what damage it can do
 * but not specific premade dnd spells
 */
public class Spell {

  // Spell Variables
    private String name;
  private int damageDie;
  private int numDamageDice;
  private String affect;
  private int slotLevel;
  private boolean attackSpell;

  /**
   * constructs a damage dealing spell
   * @param name name of spell
   * @param damageDie The number of sides on the damage dice being used
   * @param numDamageDice = The number of dice being used
   * @param slotLevel level of spell
   * @param affect = the spells affect in string form
   */
  public Spell(String name, int damageDie, int numDamageDice, int slotLevel, String affect){
    this.name = name;
    this.damageDie = damageDie;
    this.numDamageDice = numDamageDice;
    this.slotLevel = slotLevel;
    this.affect = affect;
    this.attackSpell = true;
  }

  /**
   * Constructs a basic spell
   * @param name = name of spell
   * @param slotLevel = level of spell
   * @param affect = the spells affect in string form
   */
  public Spell(String name, int slotLevel, String affect){
    this.name = name;
    this.damageDie = 0;
    this.numDamageDice = 0;
    this.slotLevel = slotLevel;
    this.affect = affect;
    this.attackSpell = false;
  }


  // Getters and Setters

  public String getName() {
    return name;
  }

  public int getDamageDie() {
    return damageDie;
  }

  public int getNumDamageDice() {
    return numDamageDice;
  }

  public int getSlotLevel() {
    return slotLevel;
  }

  public String getAffect() {
    return affect;
  }

  public boolean isAttackSpell() {
    return attackSpell;
  }
}
