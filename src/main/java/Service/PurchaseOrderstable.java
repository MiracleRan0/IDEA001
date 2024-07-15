/*
 * Created by JFormDesigner on Tue May 28 19:58:26 CST 2024
 */

package Service;

import swtich.Products;
import swtich.PurchaseOrders;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 29621
 */
public class PurchaseOrderstable extends JFrame {
    public static void main(String[] args) {
 PurchaseOrderstable purchaseOrderstable=new PurchaseOrderstable();
 purchaseOrderstable.setVisible(true);
 purchaseOrderstable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public PurchaseOrderstable() {
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
        DateTxt = new JTextField();
        label2 = new JLabel();
        AmountTxt = new JTextField();
        label3 = new JLabel();
        NoteTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollBar1 = new JScrollBar();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5165\u5e93\u65e5\u671f");
        contentPane.add(label1);
        label1.setBounds(10, 10, 60, 20);
        contentPane.add(DateTxt);
        DateTxt.setBounds(85, 10, 70, DateTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u603b\u91d1\u989d");
        contentPane.add(label2);
        label2.setBounds(170, 10, 55, 20);
        contentPane.add(AmountTxt);
        AmountTxt.setBounds(230, 10, 70, 25);

        //---- label3 ----
        label3.setText("\u5907\u6ce8");
        contentPane.add(label3);
        label3.setBounds(310, 10, 60, 20);
        contentPane.add(NoteTxt);
        NoteTxt.setBounds(375, 10, 70, 25);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "\u5165\u5e93\u5355ID", "\u5165\u5e93\u65e5\u671f", "\u603b\u91d1\u989d", "\u5907\u6ce8"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 40, 710, 315);
        contentPane.add(scrollBar1);
        scrollBar1.setBounds(715, 40, scrollBar1.getPreferredSize().width, 415);

        //---- button1 ----
        button1.setText("\u5165\u5e93");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(15, 370, 185, 80);

        //---- button2 ----
        button2.setText("\u67e5\u8be2");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(555, 370, 160, 85);

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
    private JTextField DateTxt;
    private JLabel label2;
    private JTextField AmountTxt;
    private JLabel label3;
    private JTextField NoteTxt;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollBar scrollBar1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void departmentAddActionPerformed(){
        String Date =this.DateTxt.getText();
        String Amount =this.AmountTxt.getText();
        String Note =this.NoteTxt.getText();
        PurchaseOrders purchaseOrders=new PurchaseOrders(Date,Amount,Note);
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        String insertSQL = "INSERT INTO purchase_orders (ReceiveDate,TotalAmount,Notes) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // 设置PreparedStatement参数
            pstmt.setString(1,Date);
            pstmt.setString(2, Amount);
            pstmt.setString(3, Note);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "入库成功！");
            } else {
                JOptionPane.showMessageDialog(this, "入库失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作出错：" + e.getMessage());
        }
    }
    private void displayProductsInTable() {
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        // 从数据库中查询数据并填充到表格模型中
        try (Connection connection = DriverManager.getConnection(dbURL, userName, userPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM purchase_orders")) {

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
