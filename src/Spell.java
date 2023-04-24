public class Spell {

  //hopefully this pushes now
    private String name;
  private int damageDie;
  private int numDamageDice;
  private int slotLevel;

  private String damageType; // i think this is a part of spells too right?
  /**
   * constructs a spell
   * @param name name of spell
   * @param damageDie The number of sides on the damage dice being used
   * @param slotLevel level of spell
   */
  public Spell(String name, int damageDie, int numDamageDice, int slotLevel){
    this.name = name;
    this.damageDie = damageDie;
    this.numDamageDice = numDamageDice;
    this.slotLevel = slotLevel;
  }


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
}
