import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * This class will be a interactive thingy that will promt the user to make a character and do stuffm
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Choose one of the options by typing in the given string:\n" +
                "createRandom\ncreateFile");

        Scanner scnr = new Scanner(System.in);
        String store = scnr.next();
        PlayerCharacter p1 = null;

            if (store.equals("createRandom")) {
                System.out.println("Please enter one of the following character races: dwarf, elf, or human");
                String race = scnr.next();
                System.out.println("Please enter the characters level");
                int level = scnr.nextInt();
                String name = "";
                if (race.equals("dwarf")) {
                    name = PlayerCharacter.getDwarfName();
                } else if (race.equals("elf")) {
                    name = PlayerCharacter.getElfName();
                } else if (race.equals("human")) {
                    name = PlayerCharacter.getHumanName();
                }
                p1 = new PlayerCharacter(level, name);
                p1.printSheet();
            }

            if (store.equals("createFile")) {
                System.out.println("Please enter the file name you wish to create a character from");
                p1 = new PlayerCharacter(scnr.next());
                p1.printSheet();
            }

            boolean done = false;
            while (!done){
                System.out.println("Choose any of the actions below by typing in the string, or type 'done' to exit:\n" +
                        "addItem\n" + "addSpell\n" + "attack\n" + "rest\n" + "castSpell\n" + "changeHealth\n" + "printSheet");
                String input = scnr.next();
                if (input.equals("addItem")){
                    System.out.println("enter the string of the type of item you want to add from the following\n" +
                            "item\nweapon\npotion");
                    String s = scnr.next();
                    if (s.equals("item")) {
                        System.out.println("enter the name of the item you want to add to your inventory");
                        String name = scnr.next();
                        System.out.println("enter out how many of that item you want to add");
                        int quantity = scnr.nextInt();
                        InventoryItem item = new InventoryItem(name,quantity);
                        p1.addItem(item);

                    } else if (s.equals("weapon")) {
                        System.out.println("enter the name of the weapon you want to add to your inventory");
                        String name = scnr.next();
                        System.out.println("enter what type of damage die it uses");
                        int damageDie = scnr.nextInt();
                        System.out.println("enter the amount of damage dice it uses");
                        int numDamageDice = scnr.nextInt();
                        System.out.println("enter the weapon bonus (if there is no bonus type 0)");
                        int weaponBonus = scnr.nextInt();
                        System.out.println("enter what type of weapon it is");
                        String weaponType = scnr.next();
                        System.out.println("enter the type of damage the weapon deals");
                        String damageType = scnr.next();
                        InventoryItem weapon = new Weapon(name, weaponBonus, damageDie, numDamageDice, weaponType, damageType);
                        p1.addItem(weapon); //this constructor is super long but idk how to make it better

                    } else if (s.equals("potion")) {
                        //for when or if we add potion functionality
                    }


                }
                if (input.equals("addSpell")){
                    System.out.println("enter the name of the spell you want to add to your spell list");
                    String name = scnr.next();
                    System.out.println("enter what spell slot it uses");
                    int slot = scnr.nextInt();
                    System.out.println("is it a damage roll spell? enter 'yes' or 'no'");

                    if (scnr.next().equals("yes")){
                        System.out.println("enter the type of damage die it uses");
                        int damageDie = scnr.nextInt();
                        System.out.println("enter the number of damage dice it uses");
                        int numDamageDice = scnr.nextInt();
                        System.out.println("enter what the spell does on cast");
                        String affect = scnr.next();
                        Spell spell = new Spell(name, damageDie, numDamageDice, slot, affect);
                        p1.addSpell(spell);
                    }
                    else {
                        System.out.println("enter what the spell does on cast");
                        String affect = scnr.next();
                        Spell spell = new Spell(name, slot, affect);
                        p1.addSpell(spell);
                    }

                }
                if (input.equals("attack")){

                }
                if (input.equals("castSpell")){
                    System.out.println();
                }
                if (input.equals("rest")){
                    System.out.println("enter 'long' to longRest or 'short' to shortRest");
                    String s = scnr.next();
                    if (s.equals("long")){ // should print out updated health
                        p1.longRest();
                    } else if (s.equals("short")){
                        p1.shortRest(2); // idk how hitDice works
                    }
                }
                if (input.equals("changeHealth")){
                    System.out.println("enter how much health you want to add or subtract (to decrease health enter a negative number)");
                    p1.changeHealth(scnr.nextInt()); // should also print out updated health
                }
                if (input.equals("printSheet")){
                    p1.printSheet();
                }
                if (input.equals("done")){
                    done = true;
                }
                // gotta add death saves!!!!!


            }


    }
}
