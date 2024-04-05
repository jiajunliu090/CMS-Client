package ui.admin;


import ui.element.FocusButton;
import ui.element.MyJTextField;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class AdminUI extends JFrame {
    private String loginAdmin_id;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectInputStream objectInputStream;

    private JTabbedPane tabbedPane1;
    private JPanel panel4;
    private JLabel admin_IDLabel;
    private JLabel admin_IDLabel2;
    private JScrollPane scrollPane1;
    private JTable roomInfoTable;
    private JLabel label3;
    private FocusButton closeRoomButton;
    private FocusButton addRoomButton;
    private FocusButton openRoomButton;
    private FocusButton deleteRoomButton;
    private JPanel panel5;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTable meetingInfoTable;
    private JLabel searchMeetingLabel;
    private MyJTextField searchMeetingField;
    private JLabel searchMeetingIcon;
    private JPanel panel6;
    private JLabel userInfoLabel;
    private JScrollPane scrollPane3;
    private JTable userInfoTable;
    private JLabel searchUserLabel;
    private MyJTextField searchUserField;
    private JLabel searchUserIcon;
    private FocusButton addUserButton;
    private FocusButton deleteUserButton;
    public AdminUI(String loginAdmin_id) throws IOException, ClassNotFoundException {
        this.loginAdmin_id = loginAdmin_id;
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        tabbedPane1 = new JTabbedPane();
        panel4 = new JPanel();
        admin_IDLabel = new JLabel();
        admin_IDLabel2 = new JLabel();
        scrollPane1 = new JScrollPane();
        out.println("admin_getRoomInfoTable");
        out.flush();
        ObjectInputStream objectInputStream1 = new ObjectInputStream(socket.getInputStream());
        TableModel model1 = (TableModel) objectInputStream1.readObject();
        roomInfoTable = new JTable();
        roomInfoTable.setModel(model1);
        label3 = new JLabel();
        closeRoomButton = new FocusButton();
        addRoomButton = new FocusButton();
        openRoomButton = new FocusButton();
        deleteRoomButton = new FocusButton();
        panel5 = new JPanel();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        meetingInfoTable = new JTable();
        out.println("admin_getMeetingInfoTable");
        out.flush();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        TableModel model = (TableModel) objectInputStream.readObject();
        meetingInfoTable.setModel(model);
        searchMeetingLabel = new JLabel();
        searchMeetingField = new MyJTextField();
        searchMeetingIcon = new JLabel();
        panel6 = new JPanel();
        userInfoLabel = new JLabel();
        scrollPane3 = new JScrollPane();
        out.println("admin_getUserInfoTable");
        out.flush();
        ObjectInputStream objectInputStream3 = new ObjectInputStream(socket.getInputStream());
        TableModel model3 = (TableModel) objectInputStream3.readObject();
        userInfoTable = new JTable();
        userInfoTable.setModel(model3);
        searchUserLabel = new JLabel();
        searchUserField = new MyJTextField();
        searchUserIcon = new JLabel();
        addUserButton = new FocusButton();
        deleteUserButton = new FocusButton();

        //======== this ========
        setTitle("会议管理系统--管理员");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== panel4 ========
            {
                panel4.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
                        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  " " , javax. swing .border . TitledBorder
                        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialog", java .
                        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel4. getBorder () ) )
                ; panel4. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "border" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
                panel4.setLayout(null);

                //---- admin_IDLabel ----
                admin_IDLabel.setText("管理员ID/Admin_ID：");
                panel4.add(admin_IDLabel);
                admin_IDLabel.setBounds(0, 0, 150, 40);

                //---- admin_IDLabel2 ----
                admin_IDLabel2.setText(this.loginAdmin_id);
                panel4.add(admin_IDLabel2);
                admin_IDLabel2.setBounds(160, 0, 100, 40);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(roomInfoTable);
                }
                panel4.add(scrollPane1);
                scrollPane1.setBounds(0, 75, 430, 350);

                //---- label3 ----
                label3.setText("会议室使用情况：");
                panel4.add(label3);
                label3.setBounds(0, 40, 150, 40);

                //---- closeRoomButton ----
                closeRoomButton.setText("关闭会议室");
                closeRoomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("admin_closeRoomButton");
                        String select_room_id = (String) roomInfoTable.getValueAt(roomInfoTable.getSelectedRow(), 0);
                        out.println(select_room_id);
                        out.flush();
                        String returnType = null;
                        try {
                            returnType = in.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        if (returnType.equals("Room closed")) {
                            JOptionPane.showMessageDialog(null, "关闭成功");
                            try {
                                flushTable();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            } catch (ClassNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                        }else JOptionPane.showMessageDialog(null, "关闭错误");
                    }
                });
                panel4.add(closeRoomButton);
                closeRoomButton.setBounds(535, 265, 145, 50);

                //---- addRoomButton ----
                addRoomButton.setText("添加会议室");
                addRoomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            AddRoomJDialog addRoomJDialog = new AddRoomJDialog(AdminUI.this);
                            addRoomJDialog.setVisible(true);
                            addRoomJDialog.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    try {
                                        flushTable();
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (ClassNotFoundException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                            });
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                panel4.add(addRoomButton);
                addRoomButton.setBounds(535, 115, 145, 50);

                //---- openRoomButton ----
                openRoomButton.setText("开启会议室");
                openRoomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("admin_openRoomButton");
                        String select_room_id = (String) roomInfoTable.getValueAt(roomInfoTable.getSelectedRow(), 0);
                        out.println(select_room_id);
                        out.flush();
                        String returnType = null;
                        try {
                            returnType = in.readLine();
                            JOptionPane.showMessageDialog(null, returnType);
                            flushTable();
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                panel4.add(openRoomButton);
                openRoomButton.setBounds(535, 335, 145, 50);

                //---- deleteRoomButton ----
                deleteRoomButton.setText("删除会议室");
                deleteRoomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("admin_deleteRoomButton");
                        String select_room_id = (String) roomInfoTable.getValueAt(roomInfoTable.getSelectedRow(), 0);
                        out.println(select_room_id);
                        out.flush();
                        String returnType = null;
                        try {
                            returnType = in.readLine();
                            JOptionPane.showMessageDialog(null, returnType);
                            flushTable();
                        }catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
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
            tabbedPane1.addTab("主页", panel4);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                //---- label4 ----
                label4.setText("预召开会议：");
                panel5.add(label4);
                label4.setBounds(20, 15, 105, 40);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(meetingInfoTable);
                }
                panel5.add(scrollPane2);
                scrollPane2.setBounds(0, 75, 785, 350);

                //---- searchMeetingLabel ----
                searchMeetingLabel.setText("搜索会议：");
                panel5.add(searchMeetingLabel);
                searchMeetingLabel.setBounds(255, 15, 110, 40);
                panel5.add(searchMeetingField);
                searchMeetingField.setBounds(370, 20, 150, 30);

                //---- searchMeetingIcon ----

                File file = new File("src/ui/resources/statics/image/icons8-search-32(1).png");
                InputStream stream = new FileInputStream(file);
                BufferedImage image = ImageIO.read(stream);
                searchMeetingIcon.setIcon(new ImageIcon(image));
                searchMeetingIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        searchMeetingIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        searchMeetingIcon.setCursor(Cursor.getDefaultCursor());
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (searchMeetingField.getText() == null || searchMeetingField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "请输入会议ID再搜索");
                        }else {
                            String searchMeeting_ID = searchMeetingField.getText();
                            searchMeeting(searchMeeting_ID);
                        }
                    }
                });

                searchUserIcon.setIcon(new ImageIcon(image));
                searchUserIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        searchUserIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        searchUserIcon.setCursor(Cursor.getDefaultCursor());
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (searchUserField.getText() == null || searchUserField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "请输入用户ID再搜索");
                        }else {
                            String searchUser_ID = searchUserField.getText();
                            searchUser(searchUser_ID);
                        }
                    }
                });
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
            tabbedPane1.addTab("会议信息", panel5);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                //---- userInfoLabel ----
                userInfoLabel.setText("用户信息：");
                panel6.add(userInfoLabel);
                userInfoLabel.setBounds(20, 15, 105, 40);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(userInfoTable);
                }
                panel6.add(scrollPane3);
                scrollPane3.setBounds(0, 75, 505, 350);

                //---- searchUserLabel ----
                searchUserLabel.setText("搜索用户：");
                panel6.add(searchUserLabel);
                searchUserLabel.setBounds(255, 15, 110, 40);
                panel6.add(searchUserField);
                searchUserField.setBounds(370, 20, 150, 30);

                //---- searchUserIcon ----
                panel6.add(searchUserIcon);
                searchUserIcon.setBounds(525, 15, 40, 40);

                //---- deleteUserButton ----
                deleteUserButton.setText("删除用户");
                deleteUserButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("admin_deleteUser");
                        String select_user_id = (String) userInfoTable.getValueAt(userInfoTable.getSelectedRow(), 0);
                        out.println(select_user_id);
                        out.flush();
                        String returnType = null;
                        try {
                            returnType = in.readLine();
                            JOptionPane.showMessageDialog(null, returnType);
                            flushTable();
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
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
            tabbedPane1.addTab("用户管理", panel6);
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

    private void searchMeeting(String text) {
        for (int row = 0; row < meetingInfoTable.getRowCount(); row++) {
            Object cellValue = meetingInfoTable.getValueAt(row, 0); // 获取当前行会议ID列的值
            if (cellValue != null && cellValue.toString().toLowerCase().equals(text)) {
                meetingInfoTable.getSelectionModel().setSelectionInterval(row, row);
                meetingInfoTable.scrollRectToVisible(meetingInfoTable.getCellRect(row, 0, true));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "未查找到该会议");
    }

    private void searchUser(String text) {
        for (int row = 0; row < userInfoTable.getRowCount(); row++) {
            Object cellValue = userInfoTable.getValueAt(row, 0); // 获取当前行会议ID列的值
            if (cellValue != null && cellValue.toString().toLowerCase().equals(text)) {
                userInfoTable.getSelectionModel().setSelectionInterval(row, row);
                userInfoTable.scrollRectToVisible(userInfoTable.getCellRect(row, 0, true));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "未找到该用户");
    }


    private void flushTable() throws IOException , ClassNotFoundException{
        out.println("admin_flushTable");
        out.flush();
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        TableModel tableModel = (TableModel) objectInputStream.readObject();
        TableModel tableModel1 = (TableModel) objectInputStream.readObject();
        TableModel tableModel2 = (TableModel) objectInputStream.readObject();

        roomInfoTable.setModel(tableModel);
        roomInfoTable.repaint();

        meetingInfoTable.setModel(tableModel1);
        meetingInfoTable.repaint();

        userInfoTable.setModel(tableModel2);
        userInfoTable.repaint();
    }
}