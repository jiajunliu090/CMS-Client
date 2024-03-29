package ui.user;



import ui.element.FocusButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteCommentJFrame extends JFrame {
    private String meeting_ID;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private FocusButton button1;
    public WriteCommentJFrame(String meeting_ID) throws IOException {
        this.meeting_ID = meeting_ID;
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        button1 = new FocusButton();

        //======== this ========
        setTitle("会议");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                    . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  " " , javax. swing
                    .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                    Font ( "Dialog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "border" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setBackground(Color.darkGray);
                textArea1.setForeground(Color.lightGray);
                scrollPane1.setViewportView(textArea1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(45, 75, 370, 140);

            //---- label1 ----
            label1.setText("对此次会议的评价/建议/评论：");
            label1.setForeground(Color.lightGray);
            panel1.add(label1);
            label1.setBounds(45, 10, 185, 40);

            //---- button1 ----
            button1.setText("提交");
            button1.setBackground(Color.black);
            button1.setForeground(Color.lightGray);
            button1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    out.println("submitComment");
                    out.println(meeting_ID);
                    String comment = textArea1.getText();
                    out.println(comment);
                    out.flush();
                    try {
                        String returnType = in.readLine();
                        if (returnType.equals("submitCommentSuccess")) {
                            JOptionPane.showMessageDialog(null, "操作成功");
                            dispose();
                        }else JOptionPane.showMessageDialog(null, "写出失败");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            panel1.add(button1);
            button1.setBounds(185, 235, 90, 35);

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
        panel1.setBounds(0, 0, 465, 285);

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
