/*
 * Created by JFormDesigner on Tue May 28 20:00:17 CST 2024
 */

package Service;

import swtich.BorrowRecords;
import swtich.InventoryChecks;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * @author 29621
 */
public class InventoryChecksTable extends JFrame {
    public static void main(String[] args) {
         InventoryChecksTable inventoryChecksTable =new InventoryChecksTable();
         inventoryChecksTable.setVisible(true);
         inventoryChecksTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public InventoryChecksTable() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        departmentAddActionPerformed();
//        displayProductsInTable();
        displayProductAndInventoryDataByProductId();

    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        DateTxt = new JTextField();
        label2 = new JLabel();
        idTxt = new JTextField();
        label3 = new JLabel();
        NoteTxt = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "\u76d8\u5e93ID", "\u76d8\u5e93\u65e5\u671f", "\u4ea7\u54c1ID", "\u76d8\u5e93\u6570\u91cf", "\u5907\u6ce8"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 35, 585, 235);

        //---- button1 ----
        button1.setText("\u76d8\u5e93");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(15, 285, 120, 45);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(440, 285, 120, 45);

        //---- label1 ----
        label1.setText("\u76d8\u5e93\u65e5\u671f");
        contentPane.add(label1);
        label1.setBounds(0, 0, 90, 35);
        contentPane.add(DateTxt);
        DateTxt.setBounds(95, 0, 90, 35);

        //---- label2 ----
        label2.setText("\u4ea7\u54c1ID");
        contentPane.add(label2);
        label2.setBounds(185, 0, 55, 35);
        contentPane.add(idTxt);
        idTxt.setBounds(240, 0, 100, 35);

        //---- label3 ----
        label3.setText("\u5907\u6ce8");
        contentPane.add(label3);
        label3.setBounds(340, 0, 70, 35);
        contentPane.add(NoteTxt);
        NoteTxt.setBounds(410, 0, 110, 35);

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JTextField DateTxt;
    private JLabel label2;
    private JTextField idTxt;
    private JLabel label3;
    private JTextField NoteTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void departmentAddActionPerformed(){
        String date =this.DateTxt.getText();
        String id =this.idTxt.getText();
        String note =this.NoteTxt.getText();

        InventoryChecks inventoryChecks =new InventoryChecks(date,id,note);
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        String insertSQL = "INSERT INTO inventory_checks (CheckDate ,ProductID,Notes) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // 设置PreparedStatement参数
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            pstmt.setString(3, note);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "盘库成功！");
            } else {
                JOptionPane.showMessageDialog(this, "盘库失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作出错：" + e.getMessage());
        }
    }
private void displayProductAndInventoryDataByProductId() {
    String productId = this.idTxt.getText();
    String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true";
    String userName = "GHR22367106";
    String userPassword = "22367106";

    // 构建连接查询语句，从两个表中提取数据
    String querySQL = "SELECT p.Specification, ic.CheckDate, ic.Notes,p.WarningLowerLimit "
            + "FROM Products p "
            + "LEFT JOIN inventory_checks ic ON p.ProductID = ic.ProductID "
            + "WHERE p.ProductID = ?";

    try (Connection connection = DriverManager.getConnection(dbURL, userName, userPassword);
         PreparedStatement pstmt = connection.prepareStatement(querySQL)) {

        // 设置PreparedStatement参数
        pstmt.setString(1, productId);

        // 执行查询操作
        ResultSet resultSet = pstmt.executeQuery();

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
            int WarningLowerLimit = resultSet.getInt("WarningLowerLimit");
            int Specification = resultSet.getInt("Specification");
            if (Specification < WarningLowerLimit) {
                JOptionPane.showMessageDialog(this, "库存量低于最小限制值！");
            }
            model.addRow(row);
        }

        // 设置表格模型
        table1.setModel(model);
        for (int i = 0; i < columnCount; i++) {
            TableColumn column = table1.getColumnModel().getColumn(i);
            column.setHeaderValue(metaData.getColumnName(i + 1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "数据库操作出错：" + e.getMessage());
    }
}



}
