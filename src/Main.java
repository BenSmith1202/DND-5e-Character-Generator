import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * This class will be an interactive thingy that will prompt the user to make a character and do stuff
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("""
                Choose one of the options below by typing in the given number of the option you wish to choose:
                [1] createRandom
                [2] createFile""");

        Scanner scnr = new Scanner(System.in);
        int store = scnr.nextInt();
        PlayerCharacter p1 = null;

            if (store == 1) {
                System.out.println("Please enter one of the following character races: [1] Dwarf, [2] Elf, [3] Human, or [4] Random Race");
                int raceChoice = scnr.nextInt();
                Random r = new Random();
                String race = switch (raceChoice) {
                    case 1 -> "Dwarf";
                    case 2 -> "Elf";
                    case 3 -> "Human";
                    case 4 -> switch (r.nextInt(1,4)){
                        case 1 -> "Dwarf";
                        case 2 -> "Elf";
                        case 3 -> "Human";
                        default -> "";
                    };
                    default -> "";
                };
                String name = switch (race) {
                    case "Dwarf" -> RandomNameGenerator.getDwarfName();
                    case "Elf" -> RandomNameGenerator.getElfName();
                    case "Human" -> RandomNameGenerator.getHumanName();
                    default -> "";
                };
                System.out.println("Please enter one of the following classes: [1] Fighter, [2] Rouge, [3] Barbarian," +
                        "[4] Wizard, [5] Sorcerer, [6] Bard, [7] Random Class");
                int classChoice = scnr.nextInt();
                String characterClass = switch (classChoice) {
                    case 1 -> "Fighter";
                    case 2 -> "Rouge";
                    case 3 -> "Barbarian";
                    case 4 -> "Wizard";
                    case 5 -> "Sorcerer";
                    case 6 -> "Bard";
                    case 7 -> "Random";
                    default -> "";
                };
                System.out.println("Please enter the characters level");
                int level = scnr.nextInt();

                p1 = new PlayerCharacter(level, name, race, characterClass);
                p1.printSheet();
            }

            if (store == 2) {
                System.out.println("Please enter the file name you wish to create a character from");
                p1 = new PlayerCharacter(scnr.next());
                p1.printSheet();
            }

            boolean done = false;
            while (!done){
                System.out.println("""
                        
                        Choose any of the actions below by typing in the given number
                        [0] Get Help with Backstory [1] Add Item
                        [2] Add Spell               [3] Attack
                        [4] Cast Spell              [5] Rest
                        [6] Change Health           [7] Roll Death Save
                        [8] Print Character Sheet   [9] Save Character
                        [10] Reroll Personality     [11] Reroll Backstory
                        [12] Exit Program""");

                int input = scnr.nextInt();

                //addItem
                if (input == 0){
                    if (p1.getBackstory().equals("There is nothing here now, but you can generate a backstory from the main menu")){
                        p1.setBackstory(RandomBackgroundGenerator.getBackstory(p1));
                    }
                    System.out.println("Here's a randomly generated backstory that has been saved to your character:");
                    System.out.println("----------------------------");
                    System.out.println(p1.getBackstory());
                    System.out.println("----------------------------");
                }

                if (input == 1){
                    System.out.println("enter the string of the type of item you want to add from the following\n" +
                            "[1] item\n[2] weapon");
                    int s = scnr.nextInt();
                    if (s == 1) {
                        System.out.println("enter the name of the item you want to add to your inventory");
                        scnr.nextLine();
                        String name = scnr.nextLine();
                        System.out.println("enter out how many of that item you want to add");
                        int quantity = scnr.nextInt();
                        InventoryItem item = new InventoryItem(name,quantity);
                        p1.addItem(item);


                        // adds a weapon to inventory
                    } else if (s == 2) {
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


                        //adds a weapon to inventory
                    }

                }

                //addSpell
                //adds a spell to spells list
                if (input == 2){
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


                //attack
                if (input == 3){
                    System.out.println("enter what weapon you want to attack with"); //attacks with given weapon
                    p1.attack(scnr.next());
                }


                //castSpell
                if (input == 4){
                    System.out.println("enter what spell you want to cast");
                    String s = scnr.next();
                    System.out.println("Is it a damage spell? type 'yes' or 'no'");
                    if (scnr.next() == "yes"){
                        p1.castSpell(s,true);        //casts given spell
                    }
                    p1.castSpell(s,false);
                }


                // rest
                if (input == 5){
                    System.out.println("enter the number for the type of rest you want to take\n[1] long rest\n[2] short rest");
                    int s = scnr.nextInt();
                    if (s == 1){
                        p1.longRest();
                    } else if (s == 2){
                        p1.shortRest(2); //hit Dice is wrong, this part has the character rest
                    }
                }

                // changeHealth
                if (input == 6){
                    System.out.println("enter how much health you want to add or subtract (to decrease health enter a negative number)");
                    p1.changeHealth(scnr.nextInt());
                }                                                 // changes health

                //roll death save
                if (input == 7){
                    p1.rollDS();                // rolls death save
                }

                //print sheet
                if (input == 8){
                    p1.printSheet();                //prints sheet
                }

                //saves character sheet to file
                if (input == 9){
                    boolean properInput = false;
                    do {

                        System.out.println("Name your save file (save1.txt, for example)");
                        Scanner scan = new Scanner(System.in);
                        String fileName = scan.nextLine();
                        if (!fileName.substring(fileName.length()-4).equals(".txt")){
                            System.out.println("That wasn't a proper name for a file, try again.");
                            continue;
                        }
                        properInput = true;
                        p1.saveCharacter(fileName);

                    } while (!properInput);//saves character
                }
                if (input == 10) {
                    System.out.println("Rerolling Persona...");
                    p1.setPersona(RandomPersonaGenerator.getPersona(p1));
                    System.out.println("-----NEW  PERSONALITY-----");
                    System.out.println(p1.getPersona());
                    System.out.println("--------------------------");
                }
                if (input == 11) {
                    System.out.println("Rerolling backstory...");
                    p1.setBackstory(RandomBackgroundGenerator.getBackstory(p1));
                    System.out.println("------NEW  BACKSTORY------");
                    System.out.println(p1.getBackstory());
                    System.out.println("--------------------------");
                }
                //ends cycle
                if (input == 12){
                    done = true;              // ends loop
                }


            }


    }
}
