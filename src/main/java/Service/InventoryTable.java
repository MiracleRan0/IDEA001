/*
 * Created by JFormDesigner on Wed May 29 12:07:13 CST 2024
 */

package Service;

import swtich.Inventory;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 29621
 */
public class InventoryTable extends JFrame {
    public static void main(String[] args) {
         InventoryTable inventoryTable=new InventoryTable();
         inventoryTable.setVisible(true);
         inventoryTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public InventoryTable() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here\
        displayProductsInTable();
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
        label2 = new JLabel();
        idTxt = new JTextField();
        upTxt = new JTextField();
        label3 = new JLabel();
        downTxt = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, null, null},
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
                    "\u4ea7\u54c1ID", "\u5f53\u524d\u5e93\u5b58", "\u8b66\u6212\u4e0a\u9650", "\u8b66\u6212\u4e0b\u9650"
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
        scrollPane1.setBounds(0, 80, 605, 280);

        //---- button1 ----
        button1.setText("\u64cd\u4f5c");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(30, 375, 135, 60);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(445, 385, 130, 55);

        //---- label1 ----
        label1.setText("\u8b66\u6212\u4e0a\u9650");
        contentPane.add(label1);
        label1.setBounds(165, 15, 75, 25);

        //---- label2 ----
        label2.setText("\u4ea7\u54c1ID");
        contentPane.add(label2);
        label2.setBounds(5, 10, 60, 25);
        contentPane.add(idTxt);
        idTxt.setBounds(60, 15, 95, 20);
        contentPane.add(upTxt);
        upTxt.setBounds(240, 15, 70, 20);

        //---- label3 ----
        label3.setText("\u8b66\u6212\u4e0b\u9650");
        contentPane.add(label3);
        label3.setBounds(320, 15, 60, 20);
        contentPane.add(downTxt);
        downTxt.setBounds(385, 10, 80, 25);

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
    private JLabel label2;
    private JTextField idTxt;
    private JTextField upTxt;
    private JLabel label3;
    private JTextField downTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void displayProductsInTable() {
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        // 从数据库中查询数据并填充到表格模型中
        try (Connection connection = DriverManager.getConnection(dbURL, userName, userPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT ProductID,Specification,WarningUpperLimit,WarningLowerLimit FROM products")) {

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


