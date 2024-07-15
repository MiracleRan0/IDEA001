package swtich;

public class SalesOrders {
    private String SalesOrderID;
    private String ShipDate;
    private String TotalAmount;
    private String Notes;

    public String getSalesOrderID() {
        return SalesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.SalesOrderID = salesOrderID;
    }

    public String getShipDate() {
        return ShipDate;
    }

    public void setShipDate(String shipDate) {
        this.ShipDate = shipDate;
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
    public SalesOrders(String ShipDate,String TotalAmount,String Notes){super();}
    public SalesOrders(String SalesOrderID,String ShipDate,String TotalAmount,String Notes){
        super();
        this.SalesOrderID=SalesOrderID;
        this.ShipDate=ShipDate;
        this.TotalAmount=TotalAmount;
        this.Notes=Notes;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "salesOrderID='" + SalesOrderID + '\'' +
                ", shipDate='" + ShipDate + '\'' +
                ", totalAmount=" + TotalAmount +
                ", notes='" + Notes + '\'' +
                '}';
    }
}
