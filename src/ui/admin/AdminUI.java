package ui.admin;


import javax.swing.*;
import java.awt.*;

public class AdminUI extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel panel4;
    private JLabel admin_IDLabel;
    private JLabel admin_IDLabel2;
    private JScrollPane scrollPane1;
    private JTable roomInfoTable;
    private JLabel label3;
    private JButton closeRoomButton;
    private JButton addRoomButton;
    private JButton openRoomButton;
    private JButton deleteRoomButton;
    private JPanel panel5;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTable meetingInfoTable;
    private JLabel searchMeetingLabel;
    private JTextField searchMeetingField;
    private JLabel searchMeetingIcon;
    private JPanel panel6;
    private JLabel userInfoLabel;
    private JScrollPane scrollPane3;
    private JTable userInfoTable;
    private JLabel searchUserLabel;
    private JTextField searchUserField;
    private JLabel searchUserIcon;
    private JButton addUserButton;
    private JButton deleteUserButton;
    public AdminUI() {

        tabbedPane1 = new JTabbedPane();
        panel4 = new JPanel();
        admin_IDLabel = new JLabel();
        admin_IDLabel2 = new JLabel();
        scrollPane1 = new JScrollPane();
        roomInfoTable = new JTable();
        label3 = new JLabel();
        closeRoomButton = new JButton();
        addRoomButton = new JButton();
        openRoomButton = new JButton();
        deleteRoomButton = new JButton();
        panel5 = new JPanel();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        meetingInfoTable = new JTable();
        searchMeetingLabel = new JLabel();
        searchMeetingField = new JTextField();
        searchMeetingIcon = new JLabel();
        panel6 = new JPanel();
        userInfoLabel = new JLabel();
        scrollPane3 = new JScrollPane();
        userInfoTable = new JTable();
        searchUserLabel = new JLabel();
        searchUserField = new JTextField();
        searchUserIcon = new JLabel();
        addUserButton = new JButton();
        deleteUserButton = new JButton();

        //======== this ========
        setTitle("\u4f1a\u8bae\u7ba1\u7406\u7cfb\u7edf--\u7ba1\u7406\u5458");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== panel4 ========
            {
                panel4.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
                        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  " " , javax. swing .border . TitledBorder
                        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .
                        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel4. getBorder () ) )
                ; panel4. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
                panel4.setLayout(null);

                //---- admin_IDLabel ----
                admin_IDLabel.setText("\u7ba1\u7406\u5458ID/Admin_ID\uff1a");
                panel4.add(admin_IDLabel);
                admin_IDLabel.setBounds(0, 0, 150, 40);

                //---- admin_IDLabel2 ----
                admin_IDLabel2.setText("text");
                panel4.add(admin_IDLabel2);
                admin_IDLabel2.setBounds(160, 0, 100, 40);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(roomInfoTable);
                }
                panel4.add(scrollPane1);
                scrollPane1.setBounds(0, 75, 430, 350);

                //---- label3 ----
                label3.setText("\u4f1a\u8bae\u5ba4\u4f7f\u7528\u60c5\u51b5\uff1a");
                panel4.add(label3);
                label3.setBounds(0, 40, 150, 40);

                //---- closeRoomButton ----
                closeRoomButton.setText("\u5173\u95ed\u4f1a\u8bae\u5ba4");
                panel4.add(closeRoomButton);
                closeRoomButton.setBounds(535, 265, 145, 50);

                //---- addRoomButton ----
                addRoomButton.setText("\u6dfb\u52a0\u4f1a\u8bae\u5ba4");
                panel4.add(addRoomButton);
                addRoomButton.setBounds(535, 115, 145, 50);

                //---- openRoomButton ----
                openRoomButton.setText("\u5f00\u542f\u4f1a\u8bae\u5ba4");
                panel4.add(openRoomButton);
                openRoomButton.setBounds(535, 335, 145, 50);

                //---- deleteRoomButton ----
                deleteRoomButton.setText("\u5220\u9664\u4f1a\u8bae\u5ba4");
                panel4.add(deleteRoomButton);
                deleteRoomButton.setBounds(535, 190, 145, 50);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4e3b\u9875", panel4);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                //---- label4 ----
                label4.setText("\u9884\u53ec\u5f00\u4f1a\u8bae\uff1a");
                panel5.add(label4);
                label4.setBounds(20, 15, 105, 40);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(meetingInfoTable);
                }
                panel5.add(scrollPane2);
                scrollPane2.setBounds(0, 75, 785, 350);

                //---- searchMeetingLabel ----
                searchMeetingLabel.setText("\u641c\u7d22\u4f1a\u8bae\uff1a");
                panel5.add(searchMeetingLabel);
                searchMeetingLabel.setBounds(255, 15, 110, 40);
                panel5.add(searchMeetingField);
                searchMeetingField.setBounds(370, 20, 150, 30);

                //---- searchMeetingIcon ----

                searchMeetingIcon.setIcon(new ImageIcon(String.valueOf(AdminUI.class.getResourceAsStream("/image/icons8-search-32(1).png"))));
                panel5.add(searchMeetingIcon);
                searchMeetingIcon.setBounds(525, 15, 40, 40);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4f1a\u8bae\u4fe1\u606f", panel5);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                //---- userInfoLabel ----
                userInfoLabel.setText("\u7528\u6237\u4fe1\u606f\uff1a");
                panel6.add(userInfoLabel);
                userInfoLabel.setBounds(20, 15, 105, 40);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(userInfoTable);
                }
                panel6.add(scrollPane3);
                scrollPane3.setBounds(0, 75, 505, 350);

                //---- searchUserLabel ----
                searchUserLabel.setText("\u641c\u7d22\u7528\u6237\uff1a");
                panel6.add(searchUserLabel);
                searchUserLabel.setBounds(255, 15, 110, 40);
                panel6.add(searchUserField);
                searchUserField.setBounds(370, 20, 150, 30);

                //---- searchUserIcon ----
                searchUserIcon.setIcon(new ImageIcon(String.valueOf(AdminUI.class.getResourceAsStream("/image/icons8-search-32(1).png"))));
                panel6.add(searchUserIcon);
                searchUserIcon.setBounds(525, 15, 40, 40);

                //---- addUserButton ----
                addUserButton.setText("\u6dfb\u52a0\u7528\u6237");
                panel6.add(addUserButton);
                addUserButton.setBounds(575, 120, 145, 50);

                //---- deleteUserButton ----
                deleteUserButton.setText("\u5220\u9664\u7528\u6237");
                panel6.add(deleteUserButton);
                deleteUserButton.setBounds(575, 220, 145, 50);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7528\u6237\u7ba1\u7406", panel6);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 785, 460);

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