import java.util.Scanner;

/**
 * @author Ben Smith, David Olinger
 * This class simulate a dnd item and is inherited from by weapon
 */
public class InventoryItem {

    // Variables
    private String name;
    private int quantity;

    /**
     * constructs an InventoryItem
     * @param name name of item
     * @param quantity how many of that item
     */
    public InventoryItem(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * constructs an Inventory item using a string.
     * @param itemString a string formatted like "[int quantity] [the rest of the line is the name of the item]"
     */
    public InventoryItem(String itemString){
        Scanner scan = new Scanner(itemString);
        if (scan.hasNextInt()){
            this.quantity = scan.nextInt();
        }else {
            this.quantity = 1;
        }
        this.name = scan.nextLine().trim();
        scan.close();
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String toString(){
        return quantity + " " + name;
    }
    public void setName(String n){
        this.name = n;
    }
}
