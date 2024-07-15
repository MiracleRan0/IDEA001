package swtich;

public class PurchaseOrders {
    private String PurchaseOrderID;
    private String ReceiveDate;
    private String TotalAmount;
    private String Notes;

    public String getPurchaseOrderID() {
        return PurchaseOrderID;
    }

    public void setPurchaseOrderID(String purchaseOrderID) {
        this.PurchaseOrderID = purchaseOrderID;
    }
    public String getReceiveDate() {
        return ReceiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.ReceiveDate = receiveDate;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.TotalAmount = totalAmount;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        this.Notes = notes;
    }
public PurchaseOrders(String ReceiveDate,String TotalAmount,String Notes){super();}
    public PurchaseOrders(String PurchaseOrderID,String ReceiveDate,String TotalAmount,String Notes){
        super();
        this.PurchaseOrderID=PurchaseOrderID;
        this.ReceiveDate=ReceiveDate;
        this.TotalAmount=TotalAmount;
        this.Notes=Notes;
    }
    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderID='" + PurchaseOrderID + '\'' +
                ", receiveDate='" + ReceiveDate + '\'' +
                ", totalAmount=" + TotalAmount +
                ", notes='" + Notes + '\'' +
                '}';
    }
}
