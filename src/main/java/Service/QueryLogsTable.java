/*
 * Created by JFormDesigner on Tue May 28 20:00:30 CST 2024
 */

package Service;

import swtich.QueryLogs;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.SelectableChannel;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 29621
 */
public class QueryLogsTable extends JFrame {
    public static void main(String[] args) {
      QueryLogsTable queryLogsTable=new QueryLogsTable();
      queryLogsTable.setVisible(true);
      queryLogsTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public QueryLogsTable() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
//        displayProductsInTable();
        displayProductsInTable();
        departmentAddActionPerformed();
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        tpTxt = new JTextField();
        label2 = new JLabel();
        conTxt = new JTextField();
        label4 = new JLabel();
        DateTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u67e5\u8be2\u7c7b\u578b");
        contentPane.add(label1);
        label1.setBounds(5, 5, 75, 20);
        contentPane.add(tpTxt);
        tpTxt.setBounds(85, 5, 75, tpTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u67e5\u8be2\u6761\u4ef6");
        contentPane.add(label2);
        label2.setBounds(165, 5, 65, 20);
        contentPane.add(conTxt);
        conTxt.setBounds(240, 5, 65, conTxt.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u67e5\u8be2\u65e5\u671f");
        contentPane.add(label4);
        label4.setBounds(300, 5, 50, 20);
        contentPane.add(DateTxt);
        DateTxt.setBounds(355, 5, 85, 25);

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
                    "\u67e5\u8be2ID", "\u67e5\u8be2\u7c7b\u578b", "\u67e5\u8be2\u6761\u4ef6", "\u67e5\u8be2\u7ed3\u679c", "\u67e5\u8be2\u65e5\u671f"
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
        scrollPane1.setBounds(5, 35, 630, 295);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(10, 345, 175, 75);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(450, 350, 190, 75);

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
    private JTextField tpTxt;
    private JLabel label2;
    private JTextField conTxt;
    private JLabel label4;
    private JTextField DateTxt;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void departmentAddActionPerformed(){
        String Type =this.tpTxt.getText();
        String Con =this.conTxt.getText();
        String date =this.DateTxt.getText();
        QueryLogs queryLogs = new QueryLogs(Type,Con,date);
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true"; // 假设端口是默认的1433
        String userName = "GHR22367106"; // 替换为您的数据库用户名
        String userPassword = "22367106"; // 替换为您的密码
        String insertSQL = "INSERT INTO query_logs (QueryType,inventoryCheckID,QueryDate ) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbURL, userName, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // 设置PreparedStatement参数
            pstmt.setString(1, Type);
            pstmt.setString(2, Con);
//            pstmt.setString(3, rs);
            pstmt.setString(3, date);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "查询成功！");
            } else {
                JOptionPane.showMessageDialog(this, "查询失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作出错：" + e.getMessage());
        }
    }

private void displayProductsInTable() {
    String Con =this.conTxt.getText();
    String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Safe;encrypt=true;trustServerCertificate=true";
    String userName = "GHR22367106";
    String userPassword = "22367106";
    String querySQL = "SELECT q.QueryID, q.inventoryCheckID, q.QueryType, ic.ProductID, ic.CheckDate "
            + "FROM query_logs q "
            + "LEFT JOIN inventory_checks ic ON q.inventoryCheckID = ic.inventoryCheckID "
            + "WHERE q.inventoryCheckID = ?";

    // 从数据库中查询数据并填充到表格模型中
    try (Connection connection = DriverManager.getConnection(dbURL, userName, userPassword);
         PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {

        // 设置inventoryCheckID的值
        preparedStatement.setString(1,Con);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
