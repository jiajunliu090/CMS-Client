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
import java.util.ArrayList;
import java.util.List;

public class ChangeMeetingInfoJFrame extends JFrame {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String meeting_ID;
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
    public ChangeMeetingInfoJFrame(String meeting_ID) throws IOException {
        this.meeting_ID = meeting_ID;
        initComponents();
    }

    private void initComponents() throws IOException {
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
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
        setTitle("更改会议信息/change meeting information");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
                    ( 0, 0 ,0 , 0) ,  " " , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
                    .TitledBorder . BOTTOM, new java. awt .Font ( "Dialog", java .awt . Font. BOLD ,12 ) ,java . awt
                    . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "border" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
                ;} } );
            panel1.setLayout(null);

            //---- mainLabel ----
            mainLabel.setText("更改会议--" + meeting_ID);
            mainLabel.setForeground(Color.lightGray);
            panel1.add(mainLabel);
            mainLabel.setBounds(295, 20, 165, 35);

            //---- themeLabel ----
            themeLabel.setText("会议主题/theme：");
            themeLabel.setForeground(Color.lightGray);
            panel1.add(themeLabel);
            themeLabel.setBounds(100, 70, 165, 35);

            //---- label3 ----
            label3.setText("会议时间meeting time：MM.dd.HH.mm");
            label3.setForeground(Color.lightGray);
            panel1.add(label3);
            label3.setBounds(375, 170, 310, 35);
            panel1.add(themeField);
            themeField.setBounds(165, 125, 170, 30);
            panel1.add(meetingTimeField);
            meetingTimeField.setBounds(440, 225, 170, 30);
            out.println("getAvailableRoom");
            out.println(meeting_ID);
            out.flush();
            String s = in.readLine();
            int size = Integer.parseInt(s);
            List<String> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(in.readLine());
            }
            // 添加元素
            for (String item : arrayList) {
                roomBox.addItem(item);
            }
            panel1.add(roomBox);
            roomBox.setBounds(475, 125, 116, 30);

            //---- label4 ----
            label4.setText("会议室/conference room：");
            label4.setForeground(Color.lightGray);
            panel1.add(label4);
            label4.setBounds(375, 70, 255, 35);

            //---- addLabel ----
            addLabel.setText("添加参会人员：");
            addLabel.setForeground(Color.lightGray);
            panel1.add(addLabel);
            addLabel.setBounds(100, 170, 165, 35);

            //---- deleteLabel ----
            deleteLabel.setText("删除参会人员：");
            deleteLabel.setForeground(Color.lightGray);
            panel1.add(deleteLabel);
            deleteLabel.setBounds(100, 270, 165, 35);
            panel1.add(deleteParticipateField);
            deleteParticipateField.setBounds(165, 320, 170, 30);
            panel1.add(addParticipateField);
            addParticipateField.setBounds(165, 225, 170, 30);

            //---- finishButton ----
            finishButton.setText("完成/finish");
            finishButton.setBackground(Color.black);
            finishButton.setForeground(Color.lightGray);
            finishButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    out.println("changeConferenceInfo");
                    String theme = themeField.getText();
                    String meetingTime = meetingTimeField.getText();
                    String add = addParticipateField.getText();
                    String delete = deleteParticipateField.getText();
                    String room_ID = (String) roomBox.getSelectedItem();
                    out.println(meeting_ID); //2
                    out.println(theme);
                    out.println(meetingTime);
                    out.println(add);
                    out.println(delete);
                    out.println(room_ID);
                    out.println();
                    out.flush();
                    try {
                        String returnType1 = in.readLine();
                        String returnType2 = in.readLine();
                        String returnType3 = in.readLine();
                        if (returnType1.equals("changeConferenceInfoSuccess") &&
                        returnType2.equals("removeParticipantsSuccess") &&
                        returnType3.equals("addParticipantsSuccess")) {
                            JOptionPane.showMessageDialog(null, "操作成功");
                            dispose();
                        }else JOptionPane.showMessageDialog(null, "更新失败");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
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