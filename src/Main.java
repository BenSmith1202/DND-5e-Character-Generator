import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * This class will be an interactive thingy that will prompt the user to make a character and do stuff
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("""
                Choose one of the options by typing in the given string:
                createRandom
                createFile""");

        Scanner scnr = new Scanner(System.in);
        String store = scnr.next();
        PlayerCharacter p1 = null;

            if (store.equals("createRandom")) {
                System.out.println("Please enter one of the following character races: Dwarf, Elf, or Human");
                String race = scnr.next();
                System.out.println("Please enter the characters level");
                int level = scnr.nextInt();
                String name = "";
                if (race.toUpperCase().equals("DWARF")) {
                    name = RandomNameGenerator.getDwarfName();
                } else if (race.toUpperCase().equals("ELF")) {
                    name = RandomNameGenerator.getElfName();
                } else if (race.toUpperCase().equals("HUMAN")) {
                    name = RandomNameGenerator.getHumanName();
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
                System.out.println("""


                        Choose any of the actions below by typing in the string, or type 'done' to exit:
                        addItem
                        addSpell
                        attack
                        rest
                        castSpell
                        changeHealth
                        rollDS
                        printSheet""");
                String input = scnr.next();


                if (input.equals("addItem")){
                    System.out.println("enter the string of the type of item you want to add from the following\n" +
                            "item\nweapon\npotion");
                    String s = scnr.next();
                    if (s.equals("item")) {
                        System.out.println("enter the name of the item you want to add to your inventory");
                        scnr.nextLine();
                        String name = scnr.nextLine();
                        System.out.println("enter out how many of that item you want to add");
                        int quantity = scnr.nextInt();
                        InventoryItem item = new InventoryItem(name,quantity);
                        p1.addItem(item);


                        // adds a weapon to inventory
                    } else if (s.equals("weapon")) {
                        System.out.println("enter the name of the weapon you want to add to your inventory");
                        scnr.nextLine();
                        String name = scnr.nextLine();
                        System.out.println("enter the sides of the damage die it uses");
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


                        //adds a potion to inventory
                    } else if (s.equals("potion")) {
                        //for when or if we add potion functionality
                    }

                }


                //adds a spell to spells list
                if (input.equals("addSpell")){
                    System.out.println("enter the name of the spell you want to add to your spell list");
                    scnr.nextLine();
                    String name = scnr.nextLine();
                    System.out.println("enter what spell slot it uses");
                    int slot = scnr.nextInt();
                    System.out.println("is it a damage roll spell? enter 'yes' or 'no'");

                    if (scnr.next().equals("yes")){
                        System.out.println("enter the sides of the damage die it uses");
                        int damageDie = scnr.nextInt();
                        System.out.println("enter the number of damage dice it uses");
                        int numDamageDice = scnr.nextInt();
                        System.out.println("enter what the spell does on cast");
                        scnr.nextLine();
                        String affect = scnr.nextLine();
                        Spell spell = new Spell(name, damageDie, numDamageDice, slot, affect);
                        p1.addSpell(spell);
                    }
                    else {
                        System.out.println("enter what the spell does on cast");
                        scnr.nextLine();
                        String affect = scnr.nextLine();
                        Spell spell = new Spell(name, slot, affect);
                        p1.addSpell(spell);
                    }

                }



                if (input.equals("attack")){
                    System.out.println("enter what weapon you want to attack with"); //attacks with given weapon
                    p1.attack(scnr.next());
                }



                if (input.equals("castSpell")){
                    System.out.println("enter what spell you want to cast");
                    String s = scnr.next();
                    System.out.println("Is it a damage spell? type 'yes' or 'no'");
                    if (scnr.next() == "yes"){
                        p1.castSpell(s,true);        //casts given spell
                    }
                    p1.castSpell(s,false);
                }



                if (input.equals("rest")){
                    System.out.println("enter 'long' to longRest or 'short' to shortRest");
                    String s = scnr.next();
                    if (s.equals("long")){
                        p1.longRest();
                    } else if (s.equals("short")){
                        p1.shortRest(2); //hit Dice is wrong, this part has the character rest
                    }
                }


                if (input.equals("changeHealth")){
                    System.out.println("enter how much health you want to add or subtract (to decrease health enter a negative number)");
                    p1.changeHealth(scnr.nextInt());
                }                                                 // changes health


                if (input.equals("rollDS")){
                    p1.rollDS();                // rolls death save
                }


                if (input.equals("printSheet")){
                    p1.printSheet();                //prints sheet
                }


                if (input.equals("done")){
                    done = true;              // ends loop
                }


            }


    }
}
