/*
 * Created by JFormDesigner on Tue May 28 19:59:03 CST 2024
 */

package Service;

import swtich.BorrowRecords;
import swtich.InventoryTransactions;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author 29621
 */
public class BorrowRecordsTable extends JFrame {
    public static void main(String[] args) {
        BorrowRecordsTable borrowRecordsTable=new BorrowRecordsTable();
        borrowRecordsTable.setVisible(true);
        borrowRecordsTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public BorrowRecordsTable() {
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
        BDTxt = new JTextField();
        label2 = new JLabel();
        RDTxt = new JTextField();
        label3 = new JLabel();
        QuantityTxt = new JTextField();
        label4 = new JLabel();
        NoteTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u501f\u51fa\u65e5\u671f");
        contentPane.add(label1);
        label1.setBounds(5, 5, 50, 25);
        contentPane.add(BDTxt);
        BDTxt.setBounds(65, 5, 85, 25);

        //---- label2 ----
        label2.setText("\u5f52\u8fd8\u65e5\u671f");
        contentPane.add(label2);
        label2.setBounds(155, 5, 60, 20);
        contentPane.add(RDTxt);
        RDTxt.setBounds(220, 5, 80, 20);

        //---- label3 ----
        label3.setText("\u6570\u91cf");
        contentPane.add(label3);
        label3.setBounds(310, 5, 45, 20);
        contentPane.add(QuantityTxt);
        QuantityTxt.setBounds(360, 5, 70, 25);

        //---- label4 ----
        label4.setText("\u5907\u6ce8");
        contentPane.add(label4);
        label4.setBounds(440, 5, 55, 20);
        contentPane.add(NoteTxt);
        NoteTxt.setBounds(505, 5, 85, 25);

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
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "\u501f\u6761ID", "\u501f\u51fa\u65e5\u671f", "\u5f52\u8fd8\u65e5\u671f", "\u6570\u91cf", "\u5907\u6ce8"
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
        scrollPane1.setBounds(5, 35, 605, 365);

        //---- button1 ----
        button1.setText("\u501f\u51fa");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(10, 415, 165, 85);

        //---- button2 ----
        button2.setText("\u67e5\u8be2");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(465, 420, 155, 75);

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
    private JTextField BDTxt;
    private JLabel label2;
    private JTextField RDTxt;
    private JLabel label3;
    private JTextField QuantityTxt;
    private JLabel label4;
    private JTextField NoteTxt;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void departmentAddActionPerformed(){
        String bd =this.BDTxt.getText();
        String rd =this.RDTxt.getText();
        String quantity =this.QuantityTxt.getText();
        String note =this.NoteTxt.getText();
       BorrowRecords borrowRecords=new BorrowRecords(bd,rd,quantity,note);
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        String insertSQL = "INSERT INTO borrow_records ( BorrowDate, ReturnDate,Quantity, Notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // 设置PreparedStatement参数
            pstmt.setString(1, bd);
            pstmt.setString(2, rd);
            pstmt.setString(3, quantity);
            pstmt.setString(4, note);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "借出" + "成功！");
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
             ResultSet resultSet = statement.executeQuery("SELECT * FROM borrow_records")) {

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
