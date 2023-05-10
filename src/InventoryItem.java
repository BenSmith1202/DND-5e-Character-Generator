import java.util.Scanner;

public class InventoryItem {
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
