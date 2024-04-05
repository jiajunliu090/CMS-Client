package ui.user;


import ui.element.FocusButton;
import ui.element.MyJTextField;
import ui.element.NonEditableTableModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;


public class UserUI extends JFrame {
    private String loginUser_id;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectInputStream objectInputStream;
    private JTabbedPane tabbedPane1;
    private JPanel StartPanel;
    private JPanel panel3;
    private JLabel nameLabel;
    private JLabel meetingNameLabel;
    private JLabel positionLabel;
    private JLabel nameLabel2;
    private JLabel meetingNameLabel2;
    private JLabel positionLabel2;
    private JLabel timeLabel;
    private JLabel TimeLabel2;
    private MyJTextField searchField;
    private JLabel searchIcon;
    private JLabel searchLabel;
    private JPanel panel4;
    private JLabel conferenceLabel;
    private JScrollPane scrollPane1;
    private JTable conferenceTable;
    private JLabel startUser_IDLabel;
    private JLabel startUser_IDLabel2;
    private JPanel CMPanel;
    private JPanel panel5;
    private JLabel createMeetingLabel;
    private MyJTextField meeting_IDField;
    private JLabel meeting_IDLabel;
    private JLabel participantsLabel;
    private JLabel meetingTimeLabel;
    private MyJTextField participantsField;
    private MyJTextField meetingTimeField;
    private FocusButton createMeetingButton;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JTable conferenceTable2;
    private JLabel conferenceLabel2;
    private FocusButton signInButton;
    private FocusButton removeButton;
    private FocusButton updateMeetingButton;
    private FocusButton writeCommentButton;
    private JPanel User_infoPanel;
    private JPanel userInfoPanel;
    private JLabel titleLabel;
    private JLabel infoNameLabel;
    private JLabel infoMeetingNameLabel;
    private JLabel infoPositionLabel;
    private JLabel user_IDLabel;
    private JLabel infoPasswordLabel;
    private MyJTextField infoNameField;
    private MyJTextField infoMeetingNameField;
    private MyJTextField infoPositionField;
    private MyJTextField infoPasswordField;
    private JLabel user_IDLabel2;
    private JLabel infoGenderLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private FocusButton logOutAccount;
    private FocusButton infoUpdateButton;

    public UserUI(String loginUser_id) throws IOException, ClassNotFoundException {

        this.loginUser_id = loginUser_id;
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        tabbedPane1 = new JTabbedPane();
        StartPanel = new JPanel();
        panel3 = new JPanel();
        nameLabel = new JLabel();
        meetingNameLabel = new JLabel();
        positionLabel = new JLabel();
        nameLabel2 = new JLabel();
        meetingNameLabel2 = new JLabel();
        positionLabel2 = new JLabel();
        timeLabel = new JLabel();
        TimeLabel2 = new JLabel();
        searchField = new MyJTextField();
        searchIcon = new JLabel();
        searchLabel = new JLabel();
        panel4 = new JPanel();
        conferenceLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        conferenceTable = new JTable();
        startUser_IDLabel = new JLabel();
        startUser_IDLabel2 = new JLabel();
        CMPanel = new JPanel();
        panel5 = new JPanel();
        createMeetingLabel = new JLabel();
        meeting_IDField = new MyJTextField();
        meeting_IDLabel = new JLabel();
        participantsLabel = new JLabel();
        meetingTimeLabel = new JLabel();
        participantsField = new MyJTextField();
        meetingTimeField = new MyJTextField();
        createMeetingButton = new FocusButton();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        conferenceTable2 = new JTable();
        conferenceLabel2 = new JLabel();
        signInButton = new FocusButton();
        removeButton = new FocusButton();
        updateMeetingButton = new FocusButton();
        writeCommentButton = new FocusButton();
        User_infoPanel = new JPanel();
        userInfoPanel = new JPanel();
        titleLabel = new JLabel();
        infoNameLabel = new JLabel();
        infoMeetingNameLabel = new JLabel();
        infoPositionLabel = new JLabel();
        user_IDLabel = new JLabel();
        infoPasswordLabel = new JLabel();
        infoNameField = new MyJTextField();
        infoMeetingNameField = new MyJTextField();
        infoPositionField = new MyJTextField();
        infoPasswordField = new MyJTextField();
        user_IDLabel2 = new JLabel();
        infoGenderLabel = new JLabel();
        maleRadioButton = new JRadioButton();
        femaleRadioButton = new JRadioButton();
        logOutAccount = new FocusButton();
        infoUpdateButton = new FocusButton();
        // 加载图片
        try {
            File file = new File("src/ui/resources/statics/image/icons8-search-36(1).png");
            InputStream stream = new FileInputStream(file);
            BufferedImage image = ImageIO.read(stream);
            searchIcon.setIcon(new ImageIcon(image));
        }catch (Exception e) {
            e.printStackTrace();
        }
        //======== this ========
        setTitle("会议管理系统");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            //======== StartPanel ========
            {
                StartPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
                        EmptyBorder(0, 0, 0, 0), " ", javax.swing.border.TitledBorder.CENTER, javax.swing
                        .border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), StartPanel.getBorder()));
                StartPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("border".equals(e.getPropertyName()))
                            throw new RuntimeException();
                    }
                });
                StartPanel.setLayout(null);

                //======== panel3 ========
                {
                    panel3.setBackground(new Color(0x666666));
                    panel3.setLayout(null);

                    //---- nameLabel ----
                    nameLabel.setText("姓名/Name:");
                    nameLabel.setForeground(Color.lightGray);
                    panel3.add(nameLabel);
                    nameLabel.setBounds(60, 30, 100, 30);

                    //---- meetingNameLabel ----
                    meetingNameLabel.setText("会议姓名/Meeting Name:");
                    meetingNameLabel.setForeground(Color.lightGray);
                    panel3.add(meetingNameLabel);
                    meetingNameLabel.setBounds(60, 75, 170, 30);

                    //---- positionLabel ----
                    positionLabel.setText("职位/position");
                    positionLabel.setForeground(Color.lightGray);
                    panel3.add(positionLabel);
                    positionLabel.setBounds(60, 120, 170, 30);

                    //---- nameLabel2 ----
                    out.println("getLoginUser_name"); // 发送获取标识
                    out.println(loginUser_id); // 发送用户ID信息
                    out.flush();
                    String type = in.readLine(); // 获取返回后的类型
                    if (type.equals("ReturnUserName")) {
                        String name = in.readLine();
                        nameLabel2.setText(name);
                    }
                    nameLabel2.setForeground(Color.lightGray);
                    panel3.add(nameLabel2);
                    nameLabel2.setBounds(255, 30, 100, 30);

                    //---- meetingNameLabel2 ----
                    out.println("getLoginUser_meetingName"); // 发送会议昵称获取标识
                    out.println(loginUser_id); // 发送用户ID信息
                    out.flush();
                    String meeting_name_response = in.readLine();
                    if (meeting_name_response.equals("ReturnUserMeetingName")) {
                        meetingNameLabel2.setText(in.readLine()); // 下一行就会是会议昵称
                    }
                    meetingNameLabel2.setForeground(Color.lightGray);
                    panel3.add(meetingNameLabel2);
                    meetingNameLabel2.setBounds(255, 75, 100, 30);

                    //---- positionLabel2 ----
                    out.println("getLoginUser_position");
                    out.println(loginUser_id);
                    out.flush();
                    String position_response = in.readLine();
                    if (position_response.equals("ReturnUser_position")) {
                        positionLabel2.setText(in.readLine());
                    }
                    positionLabel2.setForeground(Color.lightGray);
                    panel3.add(positionLabel2);
                    positionLabel2.setBounds(255, 120, 100, 30);

                    //---- timeLabel ----
                    timeLabel.setText("当前时间/Current Time:");
                    timeLabel.setForeground(Color.lightGray);
                    panel3.add(timeLabel);
                    timeLabel.setBounds(375, 15, 165, 30);

                    //---- TimeLabel2 ----
                    String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    TimeLabel2.setText(nowTime);
                    TimeLabel2.setForeground(Color.lightGray);
                    panel3.add(TimeLabel2);
                    TimeLabel2.setBounds(550, 15, 120, 30);
                    panel3.add(searchField);
                    searchField.setBounds(375, 105, 225, 50);

                    //---- searchIcon ----
                    searchIcon.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // 根据会议id更新表格为搜索后的
                            if (searchField.getText() == null || searchField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "请输入会议ID再搜索");
                            }else {
                                String searchMeeting_ID = searchField.getText();
                                search(searchMeeting_ID);
                            }
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            searchIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            searchIcon.setCursor(Cursor.getDefaultCursor());
                        }
                    });
                    panel3.add(searchIcon);
                    searchIcon.setBounds(605, 110, 40, 40);

                    //---- searchLabel ----
                    searchLabel.setText("输入会议ID搜索/input meeting_ID do search：");
                    searchLabel.setForeground(Color.lightGray);
                    panel3.add(searchLabel);
                    searchLabel.setBounds(375, 55, 320, 45);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel3.getComponentCount(); i++) {
                            Rectangle bounds = panel3.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel3.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel3.setMinimumSize(preferredSize);
                        panel3.setPreferredSize(preferredSize);
                    }
                }
                StartPanel.add(panel3);
                panel3.setBounds(0, 0, 750, 190);

                //======== panel4 ========
                {
                    panel4.setBackground(Color.lightGray);
                    panel4.setLayout(null);

                    //---- conferenceLabel ----
                    conferenceLabel.setText("即将参加的会议/upcoming meeting:");
                    conferenceLabel.setForeground(new Color(0x333333));
                    panel4.add(conferenceLabel);
                    conferenceLabel.setBounds(60, 10, 240, 40);

                    //======== scrollPane1 ========
                    {

                        //---- conferenceTable ----
                        out.println("getComingMeetingTable");
                        out.println(loginUser_id);
                        out.flush();
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        TableModel tableModel = (TableModel) inputStream.readObject(); // 接受服务器返回的表格

                        conferenceTable.setModel(tableModel);
                        conferenceTable.setForeground(Color.lightGray);
                        conferenceTable.setBackground(Color.darkGray);
                        conferenceTable.setBorder(new LineBorder(Color.gray, 2, true));
                        scrollPane1.setViewportView(conferenceTable);
                    }
                    panel4.add(scrollPane1);
                    scrollPane1.setBounds(375, 0, 375, 280);

                    //---- startUser_IDLabel ----
                    startUser_IDLabel.setText("用户ID/user_ID:");
                    startUser_IDLabel.setForeground(new Color(0x333333));
                    panel4.add(startUser_IDLabel);
                    startUser_IDLabel.setBounds(0, 240, 105, 40);

                    //---- startUser_IDLabel2 ----
                    startUser_IDLabel2.setText(loginUser_id);
                    startUser_IDLabel2.setForeground(new Color(0x333333));
                    panel4.add(startUser_IDLabel2);
                    startUser_IDLabel2.setBounds(125, 240, 90, 40);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel4.getComponentCount(); i++) {
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
                StartPanel.add(panel4);
                panel4.setBounds(0, 190, 750, 280);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < StartPanel.getComponentCount(); i++) {
                        Rectangle bounds = StartPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = StartPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    StartPanel.setMinimumSize(preferredSize);
                    StartPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("主页", StartPanel);

            //======== CMPanel ========
            {
                CMPanel.setLayout(null);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(0x666666));
                    panel5.setLayout(null);

                    //---- createMeetingLabel ----
                    createMeetingLabel.setText("创建会议/create meeting:");
                    createMeetingLabel.setForeground(Color.lightGray);
                    panel5.add(createMeetingLabel);
                    createMeetingLabel.setBounds(30, 20, 170, 30);
                    panel5.add(meeting_IDField);
                    meeting_IDField.setBounds(505, 20, 150, 30);

                    //---- meeting_IDLabel ----
                    meeting_IDLabel.setText("会议ID/meeting_ID:");
                    meeting_IDLabel.setForeground(Color.lightGray);
                    panel5.add(meeting_IDLabel);
                    meeting_IDLabel.setBounds(215, 20, 150, 30);

                    //---- participantsLabel ----
                    participantsLabel.setText("参加人员/participants(姓名)");
                    participantsLabel.setForeground(Color.lightGray);
                    panel5.add(participantsLabel);
                    participantsLabel.setBounds(215, 65, 185, 30);

                    //---- meetingTimeLabel ----
                    meetingTimeLabel.setText("时间/Time(需要格式为: MM.dd.HH.mm): ");
                    meetingTimeLabel.setForeground(Color.lightGray);
                    panel5.add(meetingTimeLabel);
                    meetingTimeLabel.setBounds(215, 110, 265, 30);
                    panel5.add(participantsField);
                    participantsField.setBounds(505, 65, 150, 30);
                    panel5.add(meetingTimeField);
                    meetingTimeField.setBounds(505, 110, 150, 30);

                    //---- createMeetingButton ----
                    createMeetingButton.setText("创建/create");
                    createMeetingButton.setBackground(Color.lightGray);
                    createMeetingButton.setForeground(new Color(0x333333));
                    createMeetingButton.addActionListener(new AbstractAction() { // 创建会议
                        @Override
                        public void actionPerformed(ActionEvent e) { // 创建会议按钮
                            out.println("createConference");
                            // 会议创建信息
                            String meeting_id = meeting_IDField.getText();
                            String participants = participantsField.getText();
                            String meeting_time = meetingTimeField.getText();

                            // 输出到服务端
                            out.println(meeting_id);
                            out.println(participants);
                            out.println(meeting_time);
                            out.flush();

                            try {
                                String returnType = in.readLine(); // 读操作
                                String room_ID = in.readLine();
                                if (returnType.equals("CreateConferenceSuccess")) {
                                    // 创建成功打开成功界面
                                    CreateMeetingJDialog createMeetingJDialog = new CreateMeetingJDialog(UserUI.this, room_ID);
                                    createMeetingJDialog.setVisible(true);
                                    flushTable();
                                }

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            } catch (ClassNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                    });
                    panel5.add(createMeetingButton);
                    createMeetingButton.setBounds(300, 155, 121, createMeetingButton.getPreferredSize().height);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel5.getComponentCount(); i++) {
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
                CMPanel.add(panel5);
                panel5.setBounds(0, 0, 750, 190);

                //======== panel6 ========
                {
                    panel6.setBackground(Color.lightGray);
                    panel6.setLayout(null);

                    //======== scrollPane2 ========
                    {
                        //---- conferenceTable2 ----
                        out.println("getConferInfoTable");
                        out.println(loginUser_id);
                        out.flush();
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream()); // 接收信息 // client 484
                        TableModel tableModel = (TableModel) inputStream.readObject();
                        conferenceTable2.setModel(tableModel);
                        conferenceTable2.setForeground(Color.lightGray);
                        conferenceTable2.setBackground(Color.darkGray);
                        conferenceTable2.setBorder(new LineBorder(Color.gray, 2, true));
                        scrollPane2.setViewportView(conferenceTable2);
                    }
                    panel6.add(scrollPane2);
                    scrollPane2.setBounds(0, 0, 515, 280);

                    //---- conferenceLabel2 ----
                    conferenceLabel2.setText("在表格中选中会议进行操作:");
                    conferenceLabel2.setForeground(new Color(0x333333));
                    panel6.add(conferenceLabel2);
                    conferenceLabel2.setBounds(515, 5, 230, 40);

                    //---- signInButton ----
                    signInButton.setText("签到");
                    signInButton.setBackground(new Color(0x666666));
                    signInButton.setForeground(Color.lightGray);
                    signInButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) { // 签到按钮
                            // 查哪个会议是被选中了
                            String select_meeting_ID = (String) conferenceTable2.getValueAt(conferenceTable2.getSelectedRow(), 0);
                            // 弹出会议签到
                            SignInForMeetingJDialog sign = null;
                            try {
                                sign = new SignInForMeetingJDialog(UserUI.this, select_meeting_ID);
                                flushTable();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            } catch (ClassNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                            sign.setVisible(true);

                        }
                    });
                    panel6.add(signInButton);
                    signInButton.setBounds(560, 50, 120, 40);

                    //---- removeButton ----
                    removeButton.setText("从列表中移除");
                    removeButton.setBackground(new Color(0x666666));
                    removeButton.setForeground(Color.lightGray);
                    removeButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 移除队列按钮
                            // 弹出是否确定
                            String select_meeting_ID = (String) conferenceTable2.getValueAt(conferenceTable2.getSelectedRow(), 0);
                            out.println("removeFromMeeting"); // 发送移除标识
                            out.println(select_meeting_ID); // 发送会议id
                            out.flush();

                            try {
                                String returnType = in.readLine(); // 读取服务器响应
                                if (returnType.equals("removeSuccess")) {
                                    // 弹出移除成功
                                    JOptionPane.showMessageDialog(null, "移除成功");
                                } else if (returnType.equals("removeFail")) {
                                    // 弹出移除失败
                                    JOptionPane.showMessageDialog(null, "移除失败");
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    panel6.add(removeButton);
                    removeButton.setBounds(560, 105, 120, 40);

                    //---- updateMeetingButton ----
                    updateMeetingButton.setText("更改会议信息");
                    updateMeetingButton.setBackground(new Color(0x666666));
                    updateMeetingButton.setForeground(Color.lightGray);
                    updateMeetingButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 更新会议信息
                            // 弹出更新界面
                            String select_meeting_ID = (String) conferenceTable2.getValueAt(conferenceTable2.getSelectedRow(), 0);
                            ChangeMeetingInfoJFrame changeMeetingInfoJFrame = null;
                            try {
                                changeMeetingInfoJFrame = new ChangeMeetingInfoJFrame(select_meeting_ID);

                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            changeMeetingInfoJFrame.setVisible(true);
                        }
                    });
                    panel6.add(updateMeetingButton);
                    updateMeetingButton.setBounds(560, 160, 120, 40);

                    //---- writeCommentButton ----
                    writeCommentButton.setText("写评论");
                    writeCommentButton.setBackground(new Color(0x666666));
                    writeCommentButton.setForeground(Color.lightGray);
                    writeCommentButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 写评论
                            // 弹出写评论界面
                            String select_meeting_ID = (String) conferenceTable2.getValueAt(conferenceTable2.getSelectedRow(), 0);
                            WriteCommentJFrame writeCommentJFrame = null;
                            try {
                                writeCommentJFrame = new WriteCommentJFrame(select_meeting_ID);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            writeCommentJFrame.setVisible(true);
                        }
                    });
                    panel6.add(writeCommentButton);
                    writeCommentButton.setBounds(560, 215, 120, 40);

                    {
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel6.getComponentCount(); i++) {
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
                CMPanel.add(panel6);
                panel6.setBounds(0, 190, 750, 280);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < CMPanel.getComponentCount(); i++) {
                        Rectangle bounds = CMPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = CMPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    CMPanel.setMinimumSize(preferredSize);
                    CMPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("会议管理", CMPanel);

            //======== User_infoPanel ========
            {
                User_infoPanel.setLayout(null);

                //======== userInfoPanel ========
                {
                    userInfoPanel.setBackground(Color.gray);
                    userInfoPanel.setLayout(null);

                    //---- titleLabel ----
                    titleLabel.setText("个人信息/profile");
                    userInfoPanel.add(titleLabel);
                    titleLabel.setBounds(325, 10, 100, 50);

                    //---- infoNameLabel ----姓名
                    infoNameLabel.setText("姓名/Name");
                    infoNameLabel.setForeground(Color.white);
                    userInfoPanel.add(infoNameLabel);
                    infoNameLabel.setBounds(130, 70, 150, 25);

                    //---- infoMeetingNameLabel ----参会名
                    infoMeetingNameLabel.setText("参会名/Meeting Name");
                    infoMeetingNameLabel.setForeground(Color.white);
                    userInfoPanel.add(infoMeetingNameLabel);
                    infoMeetingNameLabel.setBounds(130, 140, 155, 25);

                    //---- infoPositionLabel ----
                    infoPositionLabel.setForeground(Color.white);
                    infoPositionLabel.setText("职位/position");
                    userInfoPanel.add(infoPositionLabel);
                    infoPositionLabel.setBounds(130, 210, 155, 25);

                    //---- user_IDLabel ----
                    user_IDLabel.setText("用户ID/user_ID：");
                    user_IDLabel.setForeground(Color.white);
                    userInfoPanel.add(user_IDLabel);
                    user_IDLabel.setBounds(0, 0, 105, 45);

                    //---- infoPasswordLabel ----
                    infoPasswordLabel.setText("密码/password");
                    infoPasswordLabel.setForeground(Color.white);
                    userInfoPanel.add(infoPasswordLabel);
                    infoPasswordLabel.setBounds(130, 285, 155, 25);
                    out.println("getLoginUser_name");
                    out.println(loginUser_id);
                    out.flush();
                    String returnType = in.readLine();
                    if (returnType.equals("ReturnUserName")) {
                        infoNameField.setText(in.readLine());
                    }
                    userInfoPanel.add(infoNameField);
                    infoNameField.setBounds(180, 105, 180, infoNameField.getPreferredSize().height);
                    out.println("getLoginUser_meetingName");
                    out.println(loginUser_id);
                    out.flush();
                    String returnType1 = in.readLine();
                    if (returnType1.equals("ReturnUserMeetingName")) {
                        infoMeetingNameField.setText(in.readLine());
                    }
                    userInfoPanel.add(infoMeetingNameField);
                    infoMeetingNameField.setBounds(180, 175, 180, infoMeetingNameField.getPreferredSize().height);
                    out.println("getLoginUser_position");
                    out.println(loginUser_id);
                    out.flush();
                    String returnType2 = in.readLine();
                    if (returnType2.equals("ReturnUser_position")) {
                        infoPositionField.setText(in.readLine());
                    }
                    userInfoPanel.add(infoPositionField);
                    infoPositionField.setBounds(180, 245, 180, infoPositionField.getPreferredSize().height);
                    out.println("getLoginUser_password");
                    out.println(loginUser_id);
                    out.flush();
                    String returnType3 = in.readLine();
                    if (returnType3.equals("ReturnU_password")) {
                        infoPasswordField.setText(in.readLine());
                    }
                    userInfoPanel.add(infoPasswordField);
                    infoPasswordField.setBounds(180, 320, 180, infoPasswordField.getPreferredSize().height);

                    //---- user_IDLabel2 ----
                    user_IDLabel2.setForeground(Color.white);
                    user_IDLabel2.setText(loginUser_id);
                    userInfoPanel.add(user_IDLabel2);
                    user_IDLabel2.setBounds(130, 10, 150, 25);

                    //---- infoGenderLabel ----
                    infoGenderLabel.setText("性别/gender");
                    infoGenderLabel.setForeground(Color.white);
                    userInfoPanel.add(infoGenderLabel);
                    infoGenderLabel.setBounds(430, 70, 150, 25);

                    //---- maleRadioButton ----
                    maleRadioButton.setText("男/male");
                    maleRadioButton.setForeground(Color.white);
                    ButtonGroup buttonGroup = new ButtonGroup();
                    buttonGroup.add(maleRadioButton);
                    userInfoPanel.add(maleRadioButton);
                    maleRadioButton.setBounds(465, 105, maleRadioButton.getPreferredSize().width, 25);

                    //---- femaleRadioButton ----
                    femaleRadioButton.setText("女/female");
                    femaleRadioButton.setForeground(Color.white);
                    buttonGroup.add(femaleRadioButton);
                    userInfoPanel.add(femaleRadioButton);
                    femaleRadioButton.setBounds(550, 105, femaleRadioButton.getPreferredSize().width, 25);

                    //---- logOutAccount ----
                    logOutAccount.setText("注销账号/log out account");
                    logOutAccount.setForeground(Color.red);
                    logOutAccount.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 注销用户按钮
                            LogOutJDialog logOutJDialog = null;
                            try {
                                logOutJDialog = new LogOutJDialog(UserUI.this, loginUser_id);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            logOutJDialog.setVisible(true);
                        }
                    });
                    userInfoPanel.add(logOutAccount);
                    logOutAccount.setBounds(540, 430, 205, 35);

                    //---- infoUpdateButton ----
                    infoUpdateButton.setText("提交");
                    infoUpdateButton.setForeground(Color.white);
                    infoUpdateButton.setBackground(Color.darkGray);
                    infoUpdateButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 信息更新提交按钮
                            // 完成
                            out.println("submitInfoChange");

                            String name = infoNameField.getText();
                            String meetingName = infoMeetingNameField.getText();
                            String position = infoPositionField.getText();
                            String password = infoPasswordField.getText();
                            String gender = null;
                            if (maleRadioButton.isSelected()) {
                                gender = "男";
                            }else if (femaleRadioButton.isSelected()) {
                                gender = "女";
                            }else gender = "undecided";
                            out.println(name);  // 1
                            out.println(meetingName);
                            out.println(position);
                            out.println(password);
                            out.println(gender);
                            out.flush();
                            try {
                                String retype = in.readLine();
                                if (retype.equals("submitChangeSuccess")) {
                                    JOptionPane.showMessageDialog(null, "更新成功");
                                }else if (retype.equals("submitChangeFail")) {
                                    JOptionPane.showMessageDialog(null, "更新失败");
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    userInfoPanel.add(infoUpdateButton);
                    infoUpdateButton.setBounds(335, 380, infoUpdateButton.getPreferredSize().width, 35);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < userInfoPanel.getComponentCount(); i++) {
                            Rectangle bounds = userInfoPanel.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = userInfoPanel.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        userInfoPanel.setMinimumSize(preferredSize);
                        userInfoPanel.setPreferredSize(preferredSize);
                    }
                }
                User_infoPanel.add(userInfoPanel);
                userInfoPanel.setBounds(0, 0, 750, 470);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < User_infoPanel.getComponentCount(); i++) {
                        Rectangle bounds = User_infoPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = User_infoPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    User_infoPanel.setMinimumSize(preferredSize);
                    User_infoPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("我的信息", User_infoPanel);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 750, 500);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
    // 搜索并高亮匹配的行
    private void search(String text) {
        for (int row = 0; row < conferenceTable.getRowCount(); row++) {
            Object cellValue = conferenceTable.getValueAt(row, 0); // 获取当前行会议ID列的值
            if (cellValue != null && cellValue.toString().toLowerCase().equals(text)) {
                conferenceTable.getSelectionModel().setSelectionInterval(row, row);
                conferenceTable.scrollRectToVisible(conferenceTable.getCellRect(row, 0, true));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "未查找到该会议");
    }
    private void flushTable() throws IOException, ClassNotFoundException {
        out.println("tableFlush");
        out.println(loginUser_id);
        out.flush();
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        TableModel tableModel1 = (TableModel) objectInputStream.readObject();
        TableModel tableModel2 = (TableModel) objectInputStream.readObject();
        conferenceTable.setModel(tableModel1);
        conferenceTable.repaint();
        conferenceTable2.setModel(tableModel2);
        conferenceTable2.repaint();
    }
}