import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int checkedInput(String prompt, int rangeStart, int rangeEnd ){
        boolean goodIn = false;
        int input = 12;
        do {

            System.out.println(prompt);
            Scanner intCheck = new Scanner(System.in);
            if (intCheck.hasNextInt()) {
                input = intCheck.nextInt();
                if (input>rangeEnd||input<rangeStart){
                    System.out.println("Sorry, that wasn't quite right, please enter a number between " + rangeStart + " and " + rangeEnd);
                    continue;
                }
                goodIn = true;
            } else {
                System.out.println("Sorry, that wasn't quite right, please enter a number between " + rangeStart + " and " + rangeEnd);
            }
        } while (!goodIn);
        return input;
    }
    public static int checkedInput(String prompt){
        boolean goodIn = false;
        int input = 12;
        do {

            System.out.println(prompt);
            Scanner intCheck = new Scanner(System.in);
            if (intCheck.hasNextInt()) {
                input = intCheck.nextInt();
                if (input>=0){
                    goodIn = true;
                } else {
                    System.out.println("Sorry, that wasn't quite right, please enter a positive integer");
                }
            } else {
                System.out.println("Sorry, that wasn't quite right, please enter a positive integer");
            }
        } while (!goodIn);
        return input;
    }

    public static void main(String[] args) throws FileNotFoundException {

        int store = checkedInput("""
                Choose one of the options below by typing in the given number of the option you wish to choose:
                [1] Generate New Character
                [2] Load Saved Character""", 1, 2);
        PlayerCharacter p1 = null;
        Scanner scnr = new Scanner(System.in);

            if (store == 1) {
                int raceChoice = checkedInput("Please enter one of the following character races: [1] Dwarf, [2] Elf, [3] Human, or [4] Random Race", 1, 4);
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

                int classChoice = checkedInput("Please enter one of the following classes: [1] Fighter, [2] Rouge, [3] Barbarian," +
                        "[4] Wizard, [5] Sorcerer, [6] Bard, [7] Random Ideal Class", 1, 7);
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

                int level = checkedInput("Please enter the character's level (between 1 and 20)",1,20);
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
                int input = checkedInput("""
                                                    
                            Choose any of the actions below by typing in the given number
                            [0]  Get Help with Backstory [1]  Add Item
                            [2]  Add Spell               [3]  Attack
                            [4]  Cast Spell              [5]  Rest
                            [6]  Change Health           [7]  Roll Death Save
                            [8]  Print Character Sheet   [9]  Save Character
                            [10] Reroll Personality      [11] Reroll Backstory
                            [12] Roll Skill Check        [13] Edit Stats
                            [14] Exit Program""", 0, 12);
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

                    int s = checkedInput("""
                            enter the string of the type of item you want to add from the following
                            [1] item
                            [2] weapon""", 1, 2);
                    if (s == 1) {
                        System.out.println("Enter the name of the item you want to add");
                        String name = scnr.nextLine();
                        int quantity = checkedInput("enter out how many of that item you want to add");
                        InventoryItem item = new InventoryItem(name,quantity);
                        p1.addItem(item);


                        // adds a weapon to inventory
                    } else if (s == 2) {
                        System.out.println("enter the name of the weapon you want to add to your inventory");
                        scnr.nextLine();
                        String name = scnr.nextLine();
                        int damageDie = checkedInput("enter the number sides of the damage die it uses");
                        int numDamageDice = checkedInput("enter the amount of damage dice it uses");
                        int weaponBonus = checkedInput("enter the weapon bonus (if there is no bonus type 0)");
                        System.out.println("enter what type of weapon it is: 1 for Dexterity, 2 for Strength");
                        int weaponTypeIn = checkedInput("enter what type of weapon it is: 1 for Dexterity, 2 for Strength", 1, 2);
                        String weaponType = switch (weaponTypeIn) {
                            case 1 -> "Dexterity";
                            default -> "Strength";
                        };
                        int damageTypeIn = checkedInput("enter what type of damage it deals: 1 for Slashing, 2 for Piercing, or 3 for Bludgeoning.", 1, 3);
                        String damageType = switch (damageTypeIn) {
                            case 1 -> "Slashing";
                            case 2 -> "Piercing";
                            default -> "bludgeoning";
                        };
                        InventoryItem weapon = new Weapon(numDamageDice, damageDie, weaponBonus, weaponType, damageType, name);
                        p1.addItem(weapon);

                        //adds a weapon to inventory
                    }

                }

                //addSpell
                //adds a spell to spells list
                if (input == 2){
                    System.out.println("enter the name of the spell you want to add to your spell list");
                    scnr.nextLine();
                    String name = scnr.nextLine();
                    int slot = checkedInput("enter what spell slot it uses");
                    int damageSpellCheck = checkedInput("is it a damage roll spell? enter '1' for yes or '0' for no", 0 ,1);


                    if (damageSpellCheck == 1){
                        int damageDie = checkedInput("enter the number sides of the damage die it uses");
                        int numDamageDice = checkedInput("enter the amount of damage dice it uses");
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
                    ArrayList inventory = p1.getInventory();
                    System.out.println("enter the inventory slot number of the weapon you want to attack with"); //attacks with given weapon
                    p1.attack((Weapon) inventory.get(checkedInput("enter the inventory slot number of the weapon you want to attack with", 1, inventory.size()+1)-1));
                }


                //castSpell
                if (input == 4){
                    System.out.println("enter what spell you want to cast");
                    String s = scnr.next();
                    int isDamage = checkedInput("Is it a damage spell? type '1' for yes, or '0' for no.", 0, 1);
                    p1.castSpell(s, isDamage == 1);        //casts given spell
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
                if (input == 12){
                    System.out.println("This functionality is coming in a future version");
                }
                if (input == 13){
                    System.out.println("This functionality is coming in a future version");
                }
                //ends cycle
                if (input == 14){
                    done = true;              // ends loop
                }


            }


    }
}
