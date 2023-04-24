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

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

   /* public InventoryItem(){ //makes a new generic item
        name = "Unknown Item";
        quantity = 1;
    }*/
}
