package swtich;

public class BorrowRecords {
    private String BorrowSlipID;
    private String BorrowDate;
    private String ReturnDate;
    private int Quantity;
    private String Notes;

    public String getBorrowSlipID() {
        return BorrowSlipID;
    }

    public void setBorrowSlipID(String BorrowSlipID) {
        this.BorrowSlipID = BorrowSlipID;
    }
    public String getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(String BorrowDate) {
        this.BorrowDate = BorrowDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
    public BorrowRecords(String BorrowDate,String ReturnDate,String Quantity,String Notes){
        super();
    }
    public BorrowRecords(String BorrowSlipID,String BorrowDate,String ReturnDate,String Quantity,String Notes){
        super();
        this.BorrowSlipID=BorrowSlipID;
        this.BorrowDate=BorrowDate;
        this.ReturnDate=ReturnDate;
        this.Quantity= Integer.parseInt(Quantity);
        this.Notes=Notes;
    }


    @Override
    public String toString() {
        return "BorrowRecord{" +
                "borrowSlipID='" + BorrowSlipID + '\'' +
                ", borrowDate='" + BorrowDate + '\'' +
                ", returnDate='" + ReturnDate + '\'' +
                ", quantity=" + Quantity +
                ", notes='" + Notes + '\'' +
                '}';
    }
}
