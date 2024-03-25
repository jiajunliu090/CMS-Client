package ui.user;


import ui.element.FocusButton;
import ui.element.MyJTextField;

import javax.swing.*;
import java.awt.*;

public class changeMeetingInfoJFrame extends JFrame {
    private JPanel panel1;
    private JLabel mainLabel;
    private JLabel themeLabel;
    private JLabel label3;
    private MyJTextField themeField;
    private MyJTextField meetingTimeField;
    private JComboBox roomBox;
    private JLabel label4;
    private JLabel addLabel;
    private JLabel deleteLabel;
    private MyJTextField deleteParticipateField;
    private MyJTextField addParticipateField;
    private FocusButton finishButton;
    public changeMeetingInfoJFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - jiajun Liu
        panel1 = new JPanel();
        mainLabel = new JLabel();
        themeLabel = new JLabel();
        label3 = new JLabel();
        themeField = new MyJTextField();
        meetingTimeField = new MyJTextField();
        roomBox = new JComboBox();
        label4 = new JLabel();
        addLabel = new JLabel();
        deleteLabel = new JLabel();
        deleteParticipateField = new MyJTextField();
        addParticipateField = new MyJTextField();
        finishButton = new FocusButton();

        //======== this ========
        setTitle("\u66f4\u6539\u4f1a\u8bae\u4fe1\u606f/change meeting infomation");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
                    ( 0, 0 ,0 , 0) ,  " " , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
                    .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
                    . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
                ;} } );
            panel1.setLayout(null);

            //---- mainLabel ----
            mainLabel.setText("\u66f4\u6539\u4f1a\u8bae--\uff1a");
            mainLabel.setForeground(Color.lightGray);
            panel1.add(mainLabel);
            mainLabel.setBounds(295, 20, 165, 35);

            //---- themeLabel ----
            themeLabel.setText("\u4f1a\u8bae\u4e3b\u9898/theme\uff1a");
            themeLabel.setForeground(Color.lightGray);
            panel1.add(themeLabel);
            themeLabel.setBounds(100, 70, 165, 35);

            //---- label3 ----
            label3.setText("\u4f1a\u8bae\u65f6\u95f4meeting time\uff1aMM.dd.HH.mm");
            label3.setForeground(Color.lightGray);
            panel1.add(label3);
            label3.setBounds(375, 170, 310, 35);
            panel1.add(themeField);
            themeField.setBounds(165, 125, 170, 30);
            panel1.add(meetingTimeField);
            meetingTimeField.setBounds(440, 225, 170, 30);
            panel1.add(roomBox);
            roomBox.setBounds(475, 125, 116, 30);

            //---- label4 ----
            label4.setText("\u4f1a\u8bae\u5ba4/conference room\uff1a");
            label4.setForeground(Color.lightGray);
            panel1.add(label4);
            label4.setBounds(375, 70, 255, 35);

            //---- addLabel ----
            addLabel.setText("\u6dfb\u52a0\u53c2\u4f1a\u4eba\u5458\uff1a");
            addLabel.setForeground(Color.lightGray);
            panel1.add(addLabel);
            addLabel.setBounds(100, 170, 165, 35);

            //---- deleteLabel ----
            deleteLabel.setText("\u5220\u9664\u53c2\u4f1a\u4eba\u5458\uff1a");
            deleteLabel.setForeground(Color.lightGray);
            panel1.add(deleteLabel);
            deleteLabel.setBounds(100, 270, 165, 35);
            panel1.add(deleteParticipateField);
            deleteParticipateField.setBounds(165, 320, 170, 30);
            panel1.add(addParticipateField);
            addParticipateField.setBounds(165, 225, 170, 30);

            //---- finishButton ----
            finishButton.setText("\u5b8c\u6210/finish");
            finishButton.setBackground(Color.black);
            finishButton.setForeground(Color.lightGray);
            panel1.add(finishButton);
            finishButton.setBounds(445, 315, 105, 40);

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
        panel1.setBounds(0, 0, 720, 435);

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