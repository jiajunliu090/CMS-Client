package ui.user;

import view.element.FocusButton;
import view.element.MyJTextField;

import javax.swing.*;
import java.awt.*;

public class LogOutJDialog extends JDialog {
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private MyJTextField textField1;
    private FocusButton button1;

    public LogOutJDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - jiajun Liu
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new MyJTextField();
        button1 = new FocusButton();

        //======== this ========
        setTitle("\u6ce8\u9500\u7528\u6237");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0xcccccc));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                    javax.swing.border.EmptyBorder(0,0,0,0), " ",javax
                    .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                    .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
                    .Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".
                equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u786e\u5b9a\u6ce8\u9500\u7528\u6237");
            label1.setForeground(Color.red);
            panel1.add(label1);
            label1.setBounds(105, 35, 175, 40);

            //---- label2 ----
            label2.setText("\u8f93\u5165\uff1a");
            label2.setForeground(Color.red);
            panel1.add(label2);
            label2.setBounds(105, 85, 145, 40);
            panel1.add(textField1);
            textField1.setBounds(105, 135, 235, 30);

            //---- button1 ----
            button1.setText("\u6ce8\u9500");
            button1.setForeground(Color.red);
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(195, 200), button1.getPreferredSize()));

            {
                // compute preferred size
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