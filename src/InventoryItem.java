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

   /* public InventoryItem(){ //makes a new generic item
        name = "Unknown Item";
        quantity = 1;
    }*/
}
