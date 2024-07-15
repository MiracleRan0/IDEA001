/*
 * Created by JFormDesigner on Tue May 28 19:55:05 CST 2024
 */

package Service;

import swtich.Products;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 29621
 */
public class ProductsTable extends JFrame {
//    private JTable table1;
    public static void main(String[] args) {
    ProductsTable productsTable=new ProductsTable();
    productsTable.setVisible(true);
    productsTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public ProductsTable() {
        initComponents();
        displayProductsInTable();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        departmentAddActionPerformed();
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        displayProductsInTable();
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
         delete();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        nameTxt = new JTextField();
        label4 = new JLabel();
        spTxt = new JTextField();
        label5 = new JLabel();
        priceTxt = new JTextField();
        label1 = new JLabel();
        upTxt = new JTextField();
        label3 = new JLabel();
        downTxt = new JTextField();
        button3 = new JButton();
        label6 = new JLabel();
        id = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(5, 255, 125, 40);

        //---- button2 ----
        button2.setText("\u67e5\u8be2");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(410, 255, 115, 40);

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
                },
                new String[] {
                    "\u4ea7\u54c1ID", "\u4ea7\u54c1\u540d\u79f0", "\u4ea7\u54c1\u89c4\u683c", "\u4ea7\u54c1\u5355\u4ef7"
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
        scrollPane1.setBounds(0, 50, 530, 185);

        //---- label2 ----
        label2.setText("\u4ea7\u54c1\u540d\u79f0");
        contentPane.add(label2);
        label2.setBounds(5, 10, 55, 20);
        contentPane.add(nameTxt);
        nameTxt.setBounds(55, 10, 60, nameTxt.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u4ea7\u54c1\u89c4\u683c");
        contentPane.add(label4);
        label4.setBounds(120, 10, 55, 20);
        contentPane.add(spTxt);
        spTxt.setBounds(170, 10, 50, 25);

        //---- label5 ----
        label5.setText("\u4ea7\u54c1\u5355\u4ef7");
        contentPane.add(label5);
        label5.setBounds(230, 10, 55, 25);
        contentPane.add(priceTxt);
        priceTxt.setBounds(280, 10, 55, 25);

        //---- label1 ----
        label1.setText("\u4e0a\u9650");
        contentPane.add(label1);
        label1.setBounds(335, 10, 65, 30);
        contentPane.add(upTxt);
        upTxt.setBounds(405, 10, 75, 25);

        //---- label3 ----
        label3.setText("\u4e0b\u9650");
        contentPane.add(label3);
        label3.setBounds(485, 10, 50, 25);
        contentPane.add(downTxt);
        downTxt.setBounds(525, 10, 70, 25);

        //---- button3 ----
        button3.setText("\u5220\u9664");
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(185, 255, 135, 40);

        //---- label6 ----
        label6.setText("\u4ea7\u54c1ID");
        contentPane.add(label6);
        label6.setBounds(605, 10, 40, 20);
        contentPane.add(id);
        id.setBounds(650, 10, 55, id.getPreferredSize().height);

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
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JTextField nameTxt;
    private JLabel label4;
    private JTextField spTxt;
    private JLabel label5;
    private JTextField priceTxt;
    private JLabel label1;
    private JTextField upTxt;
    private JLabel label3;
    private JTextField downTxt;
    private JButton button3;
    private JLabel label6;
    private JTextField id;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void departmentAddActionPerformed(){
        String Name =this.nameTxt.getText();
        String Sp =this.spTxt.getText();
        String Price =this.priceTxt.getText();
        String up=this.upTxt.getText();
        String down=this.downTxt.getText();
        Products products=new Products(Name,Sp,Price,up,down);
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        String insertSQL = "INSERT INTO Products (ProductName, Specification, Price,WarningUpperLimit,WarningLowerLimit) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // 设置PreparedStatement参数
            pstmt.setString(1, Name);
            pstmt.setString(2, Sp);
            pstmt.setString(3, Price);
            pstmt.setString(4, up);
            pstmt.setString(5, down);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "数据添加成功！");
            } else {
                JOptionPane.showMessageDialog(this, "数据添加失败！");
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
             ResultSet resultSet = statement.executeQuery("SELECT ProductID,ProductName, Specification, Price from products")) {

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
    private void delete(){
        String id =this.id.getText();
        Products products=new Products(id);
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        String deleteSQL = "DELETE  FROM Products WHERE ProductID = ?";
        try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            // 设置PreparedStatement参数
            pstmt.setString(1,id);


            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "数据删除成功！");
            } else {
                JOptionPane.showMessageDialog(this, "数据删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作出错：" + e.getMessage());
        }
    }
}
