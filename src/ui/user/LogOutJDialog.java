package ui.user;


import ui.element.FocusButton;
import ui.element.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LogOutJDialog extends JDialog {
    private String user_ID;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private MyJTextField textField1;
    private FocusButton button1;

    public LogOutJDialog(Window owner, String user_ID) throws IOException {
        super(owner);
        this.user_ID = user_ID;
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new MyJTextField();
        button1 = new FocusButton();

        //======== this ========
        setTitle("注销用户");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0xcccccc));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                    javax.swing.border.EmptyBorder(0,0,0,0), " ",javax
                    .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                    .awt.Font("Dialog",java.awt.Font.BOLD,12),java.awt
                    .Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("border".
                equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("确定注销用户");
            label1.setForeground(Color.red);
            panel1.add(label1);
            label1.setBounds(105, 35, 175, 40);

            //---- label2 ----
            label2.setText("输入：");
            label2.setForeground(Color.red);
            panel1.add(label2);
            label2.setBounds(105, 85, 145, 40);
            //---- textField1 ----
            textField1.setForeground(Color.red);
            textField1.setText("输入：“我同意注销 + user_ID”");
            panel1.add(textField1);
            textField1.setBounds(105, 135, 235, 30);

            //---- button1 ----
            button1.setText("注销");
            button1.setForeground(Color.red);
            button1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    out.println("logOutUser");
                    out.println(textField1.getText()); // ensure
                    out.flush();
                    try {
                        String returnType = in.readLine();
                        if (returnType.equals("logOutSuccess")) {
                            JOptionPane.showMessageDialog(null, "操作成功");
                            dispose();
                            getOwner().dispose();
                        }else JOptionPane.showMessageDialog(null, "操作失败");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(195, 200), button1.getPreferredSize()));

            {
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 470, 260);

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
    }

}