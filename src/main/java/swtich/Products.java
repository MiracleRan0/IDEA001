package swtich;

public class Products {
    private String ID;
    private String Name;
    private String Specification;
    private String Price;
    private int warningUpperLimit; // 库存的警戒上限值
    private int warningLowerLimit; // 库存的警戒下限值

    public int getWarningUpperLimit() {
        return warningUpperLimit;
    }

    public void setWarningUpperLimit(int warningUpperLimit) {
        this.warningUpperLimit = warningUpperLimit;
    }

    public int getWarningLowerLimit() {
        return warningLowerLimit;
    }

    public void setWarningLowerLimit(int warningLowerLimit) {
        this.warningLowerLimit = warningLowerLimit;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
    public Products(String name, String sp, String price,String warningUpperLimit,String warningLowerLimit){super();}
    public Products(String ID){super();}
    public Products(String ID, String name, String specification, String price,String warningUpperLimit,String warningLowerLimit) {
        super();
        this.ID = ID;
        this.Name = name;
        this.Specification = specification;
        this.Price = price;
    }

    @Override
    public String toString(){
        return "Products{"+
                "ID="+ID+
                ",Name="+Name+'\''+
                ",Specification="+Specification+'\''+
                ",Price="+Price+'\''+
                ", warningUpperLimit=" + warningUpperLimit +
                ", warningLowerLimit=" + warningLowerLimit +
                '}';
    }
}
