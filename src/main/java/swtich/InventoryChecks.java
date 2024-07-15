package swtich;

public class InventoryChecks {
    private String InventoryCheckID;
    private String CheckDate;
    private String ProductID;
    private int CheckQuantity;
    private String Notes;

    public String getInventoryCheckID() {
        return InventoryCheckID;
    }

    public void setInventoryCheckID(String inventoryCheckID) {
        this.InventoryCheckID = inventoryCheckID;
    }

    public String getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(String checkDate) {
        this.CheckDate = checkDate;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        this.ProductID = productID;
    }

    public int getCheckQuantity() {
        return CheckQuantity;
    }

    public void setCheckQuantity(int checkQuantity) {
        this.CheckQuantity = checkQuantity;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        this.Notes = notes;
    }
    public InventoryChecks(String CheckDate,String ProductID,String Notes){super();}
    public InventoryChecks(String InventoryCheckID,String CheckDate,String ProductID,String CheckQuantity,String Notes){
        super();
        this.InventoryCheckID=InventoryCheckID;
        this.CheckDate=CheckDate;
        this.ProductID=ProductID;
        this.CheckQuantity= Integer.parseInt(CheckQuantity);
        this.Notes=Notes;
    }

    @Override
    public String toString() {
        return "InventoryCheck{" +
                "inventoryCheckID='" + InventoryCheckID + '\'' +
                ", checkDate='" + CheckDate + '\'' +
                ", productID='" + ProductID + '\'' +
                ", checkQuantity=" + CheckQuantity +
                ", notes='" + Notes + '\'' +
                '}';
    }
}
