/*
 * Created by JFormDesigner on Sun May 26 17:25:27 CST 2024
 */

package Service;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.security.Provider;

import static JDBC.Sql.validateUser;

/**
 * @author 29621
 */
public class login extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            login loginForm = new login();
            loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginForm.setVisible(true);
        });
    }
    public login() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if (e.getSource() == button1) {
            // 获取用户输入的账户和密码
            String username = textField1.getText();
            String password = new String(passwordField1.getPassword());

            // 连接到数据库并验证用户
            if (validateUser(username, password,"SELECT * FROM Users WHERE Username = ? AND Password = ?","username" )) {
                JOptionPane.showMessageDialog(null, "登录成功！");
                MainForme mainForme = new MainForme();
                mainForme.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "登录失败，请检查用户名和密码！");
            }
        }
    }

    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here

    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u767b\u5f55\u754c\u9762");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("                     \u4ed3\u5e93\u7ba1\u7406\u7cfb\u7edf");
        contentPane.add(label1);
        label1.setBounds(90, 10, 210, 30);

        //---- label2 ----
        label2.setText("\u8d26\u6237");
        contentPane.add(label2);
        label2.setBounds(55, 85, 50, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(55, 145, 40, label3.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(110, 80, 180, textField1.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(110, 145, 180, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(90, 205, 100, 40);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(215, 205, 95, 40);

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
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
