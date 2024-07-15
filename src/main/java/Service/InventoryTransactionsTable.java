/*
 * Created by JFormDesigner on Tue May 28 19:58:12 CST 2024
 */

package Service;

import swtich.InventoryTransactions;
import swtich.Products;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 29621
 */
public class InventoryTransactionsTable extends JFrame {
    public static void main(String[] args) {
        InventoryTransactionsTable inventoryTransactionsTable=new InventoryTransactionsTable();
        inventoryTransactionsTable.setVisible(true);
        inventoryTransactionsTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public InventoryTransactionsTable() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        departmentAddActionPerformed();
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        displayProductsInTable();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        TypeTxt = new JTextField();
        label2 = new JLabel();
        TDateTxt = new JTextField();
        label3 = new JLabel();
        quTxt = new JTextField();
        label4 = new JLabel();
        NoteTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();
        idTxt = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4ea4\u6613\u7c7b\u578b");
        contentPane.add(label1);
        label1.setBounds(5, 10, 60, 20);
        contentPane.add(TypeTxt);
        TypeTxt.setBounds(70, 10, 70, 25);

        //---- label2 ----
        label2.setText("\u4ea4\u6613\u65e5\u671f");
        contentPane.add(label2);
        label2.setBounds(140, 10, 80, 20);
        contentPane.add(TDateTxt);
        TDateTxt.setBounds(220, 10, 75, 25);

        //---- label3 ----
        label3.setText("\u6570\u91cf");
        contentPane.add(label3);
        label3.setBounds(310, 10, 55, 20);
        contentPane.add(quTxt);
        quTxt.setBounds(365, 10, 70, 25);

        //---- label4 ----
        label4.setText("\u5907\u6ce8");
        contentPane.add(label4);
        label4.setBounds(465, 10, 50, 20);
        contentPane.add(NoteTxt);
        NoteTxt.setBounds(515, 10, 80, 25);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, "", null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "\u4ea4\u6613ID", "\u4ea7\u54c1ID", "\u4ea4\u6613\u7c7b\u578b", "\u4ea4\u6613\u65e5\u671f", "\u6570\u91cf", "\u5907\u6ce8"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 40, 585, 275);

        //---- button1 ----
        button1.setText("\u64cd\u4f5c");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(15, 340, 125, 50);

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(430, 345, 140, 50);

        //---- label5 ----
        label5.setText("\u4ea7\u54c1ID");
        contentPane.add(label5);
        label5.setBounds(600, 10, 60, 25);
        contentPane.add(idTxt);
        idTxt.setBounds(660, 10, 75, 25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField TypeTxt;
    private JLabel label2;
    private JTextField TDateTxt;
    private JLabel label3;
    private JTextField quTxt;
    private JLabel label4;
    private JTextField NoteTxt;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    private JTextField idTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    //输入
    private void departmentAddActionPerformed(){

            String pid = this.idTxt.getText();
            String type = this.TypeTxt.getText();
            String date = this.TDateTxt.getText();
            int quantity = Integer.parseInt(this.quTxt.getText()); // 假设数量是整数，需要转换为int
            String note = this.NoteTxt.getText();

            String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true";
            String userName = "GHR22367106";
            String userPassword = "22367106";

            // 开始数据库事务
            try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword)) {
                conn.setAutoCommit(false); // 设置自动提交为false
                // 检查当前库存和最小库存限制
                String checkSQL = "SELECT  Specification, WarningLowerLimit FROM products WHERE ProductID = ?";
                try (PreparedStatement pstmtCheck = conn.prepareStatement(checkSQL)) {
                    pstmtCheck.setString(1, pid);
                    ResultSet rs = pstmtCheck.executeQuery();
                    if (rs.next()) {
                        int Specification = rs.getInt("Specification");
                        int WarningLowerLimit = rs.getInt("WarningLowerLimit");
                        if (type.equals("OUT") || type.equals("BORROW")) {
                            if (Specification - quantity < WarningLowerLimit) {
                                JOptionPane.showMessageDialog(this, "库存量低于最小限制值！");
                                conn.rollback(); // 回滚事务
                                return;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "产品不存在！");
                        conn.rollback(); // 回滚事务
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    conn.rollback(); // 回滚事务
                    JOptionPane.showMessageDialog(this, "检查库存限制出错：" + e.getMessage());
                    return;
                }
                // 更新产品数量
                String updateSQL = "";
                if (type.equals("IN")) {
                    updateSQL = "UPDATE products SET Specification = Specification + ? WHERE ProductID = ?";
                } else if (type.equals("OUT") || type.equals("BORROW")) {
                    updateSQL = "UPDATE products SET Specification = Specification - ? WHERE ProductID = ?";
                } else {
                    JOptionPane.showMessageDialog(this, "未知的交易类型！");
                    return;
                }

                try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateSQL)) {
                    pstmtUpdate.setInt(1, quantity);
                    pstmtUpdate.setString(2, pid);
                    int rowsAffected = pstmtUpdate.executeUpdate();
                    if (rowsAffected == 0) {
                        JOptionPane.showMessageDialog(this, "产品不存在或数量不足！");
                        conn.rollback(); // 回滚事务
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    conn.rollback(); // 回滚事务
                    JOptionPane.showMessageDialog(this, "更新产品数量出错：" + e.getMessage());
                    return;
                }

                // 插入交易记录
                String insertSQL = "INSERT INTO inventory_transactions (ProductID, TransactionType, TransactionDate, Quantity, Notes) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmtInsert = conn.prepareStatement(insertSQL)) {
                    pstmtInsert.setString(1, pid);
                    pstmtInsert.setString(2, type);
                    pstmtInsert.setString(3, date);
                    pstmtInsert.setInt(4, quantity);
                    pstmtInsert.setString(5, note);
                    pstmtInsert.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    conn.rollback(); // 回滚事务
                    JOptionPane.showMessageDialog(this, "插入交易记录出错：" + e.getMessage());
                    return;
                }

                // 提交事务
                conn.commit();
                JOptionPane.showMessageDialog(this, "交易处理成功！");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "数量必须是整数！");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "数据库操作出错：" + e.getMessage());
            }
    }
    //查询
    private void displayProductsInTable() {
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        // 从数据库中查询数据并填充到表格模型中
        try (Connection connection = DriverManager.getConnection(dbURL, userName, userPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM inventory_transactions")) {

            // 获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }
            // 将查询结果填充到 DefaultTableModel
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }
            table1.setModel(model);
            for (int i = 0; i < columnCount; i++) {
                TableColumn column = table1.getColumnModel().getColumn(i);
                column.setHeaderValue(metaData.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
