/*
 * Created by JFormDesigner on Sun May 26 20:07:08 CST 2024
 */

package Service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 29621
 */
public class MainForme extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           MainForme forme=new MainForme();
            forme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            forme.setVisible(true);
        });
    }
    public MainForme() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        ProductsTable productsTable=new ProductsTable();
        productsTable.setVisible(true);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        InventoryTransactionsTable inventoryTransactionsTable=new InventoryTransactionsTable();
        inventoryTransactionsTable.setVisible(true);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        PurchaseOrderstable purchaseOrderstable=new PurchaseOrderstable();
        purchaseOrderstable.setVisible(true);
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        SalesOrdersTable salesOrdersTable=new SalesOrdersTable();
        salesOrdersTable.setVisible(true);
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        BorrowRecordsTable borrowRecordsTable=new BorrowRecordsTable();
        borrowRecordsTable.setVisible(true);
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
        InventoryTable inventoryTable=new InventoryTable();
        inventoryTable.setVisible(true);
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
        InventoryChecksTable inventoryChecksTable=new InventoryChecksTable();
        inventoryChecksTable.setVisible(true);
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        QueryLogsTable queryLogsTable=new QueryLogsTable();
        queryLogsTable.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u4ed3\u5e93\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4ea7\u54c1\u4fe1\u606f");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(75, 30, 140, 35);

        //---- button2 ----
        button2.setText("\u8fdb\u51fa\u5e93");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(315, 30, 140, 35);

        //---- button3 ----
        button3.setText("\u5165\u5e93\u5355");
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(75, 110, 140, 35);

        //---- button4 ----
        button4.setText("\u501f\u51fa\u8bb0\u5f55");
        button4.addActionListener(e -> button5(e));
        contentPane.add(button4);
        button4.setBounds(75, 190, 140, 35);

        //---- button5 ----
        button5.setText("\u5e93\u5b58");
        button5.addActionListener(e -> button6(e));
        contentPane.add(button5);
        button5.setBounds(315, 190, 140, 35);

        //---- button6 ----
        button6.setText("\u51fa\u5e93\u5355");
        button6.addActionListener(e -> button4(e));
        contentPane.add(button6);
        button6.setBounds(315, 110, 140, 35);

        //---- button7 ----
        button7.setText("\u76d8\u5e93\u8bb0\u5f55");
        button7.addActionListener(e -> button7(e));
        contentPane.add(button7);
        button7.setBounds(75, 260, 140, 35);

        //---- button8 ----
        button8.setText("\u67e5\u8be2\u65e5\u5fd7");
        button8.addActionListener(e -> button8(e));
        contentPane.add(button8);
        button8.setBounds(315, 265, 140, 35);

        //---- label1 ----
        label1.setText("1");
        contentPane.add(label1);
        label1.setBounds(35, 35, 20, 22);

        //---- label2 ----
        label2.setText("2");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(275, 35), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("3");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(35, 115), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("4");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(275, 115), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("5");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(35, 195), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("6");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(275, 195), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("7");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(35, 265), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("8");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(280, 270), label8.getPreferredSize()));

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
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
