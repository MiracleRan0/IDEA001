package swtich;

public class Inventory {
    private String productID; // 关联产品信息表
    private int currentQuantity; // 当前的产品库存数量
    private int warningUpperLimit; // 库存的警戒上限值
    private int warningLowerLimit; // 库存的警戒下限值
    public Inventory(String productID, int warningUpperLimit, int warningLowerLimit) {
        super();
    }
    // 构造函数
    public Inventory(String productID, String currentQuantity, String warningUpperLimit, String warningLowerLimit) {
        super();
        this.productID = productID;
        this.currentQuantity = Integer.parseInt(currentQuantity);
        this.warningUpperLimit = Integer.parseInt(warningUpperLimit);
        this.warningLowerLimit = Integer.parseInt(warningLowerLimit);
    }

    // Getter和Setter方法
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getWarningUpperLimit() {
        return warningUpperLimit;
    }

    public void setWarningUpperLimit(int warningUpperLimit) {
        this.warningUpperLimit = warningUpperLimit;
    }

    public int getWarningLowerLimit() {
        return warningLowerLimit;
    }

    public void setWarningLowerLimit() {
        this.warningLowerLimit = warningLowerLimit;
    }
    public void setWarningUpperLimit() {
        if (warningUpperLimit < this.warningLowerLimit) {
            throw new IllegalArgumentException("警戒上限不能小于警戒下限。");
        }
        this.warningUpperLimit = warningUpperLimit;
    }

    public void setWarningLowerLimit(int warningLowerLimit) {
        if (warningLowerLimit > this.warningUpperLimit) {
            throw new IllegalArgumentException("警戒下限不能大于警戒上限。");
        }
        this.warningLowerLimit = warningLowerLimit;
    }
    // toString方法，用于打印库存信息
    @Override
    public String toString() {
        return "Inventory{" +
                "productID='" + productID + '\'' +
                ", currentQuantity=" + currentQuantity +
                ", warningUpperLimit=" + warningUpperLimit +
                ", warningLowerLimit=" + warningLowerLimit +
                '}';
    }
}

