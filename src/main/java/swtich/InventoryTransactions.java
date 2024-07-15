package swtich;

public class InventoryTransactions {
    private String TransactionID;
    private String ProductID;
    private String TransactionType;
    private String TransactionDate;
    private int Quantity;
    private String Notes;

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        this.TransactionID = transactionID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        this.ProductID = productID;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        this.TransactionType = transactionType;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.TransactionDate = transactionDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        this.Notes = notes;
    }
    public InventoryTransactions(String ProductID,String TransactionType,String TransactionDate,String Quantity,String Notes){
        super();
    }
    public InventoryTransactions(String TransactionID,String ProductID,String TransactionType,String  TransactionDate,String Quantity,String Notes){
        super();
        this.TransactionID=TransactionID;
        this.ProductID=ProductID;
        this.TransactionType=TransactionType;
        this.TransactionDate=TransactionDate;
        this.Quantity= Integer.parseInt(Quantity);
        this.Notes=Notes;

    }

    @Override
    public String toString() {
        return "InventoryTransaction{" +
                "transactionID='" + TransactionID + '\'' +
                ", productID='" + ProductID + '\'' +
                ", transactionType='" + TransactionType + '\'' +
                ", transactionDate='" + TransactionDate + '\'' +
                ", quantity=" + Quantity +
                ", notes='" + Notes + '\'' +
                '}';
    }
}
