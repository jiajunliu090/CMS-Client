package ui.user;

import ui.element.FocusButton;
import ui.element.MyJTextField;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class SignInForMeetingJDialog extends JDialog {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JPanel panel1;
    private JLabel signInLabel;
    private JLabel signInIcon;
    private MyJTextField codeField;
    private FocusButton submitButton;
    private BufferedImage captchaImage;
    private String meeting_ID;
    public SignInForMeetingJDialog(Window owner, String meeting_ID) throws IOException, ClassNotFoundException {
        super(owner);
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        this.meeting_ID = meeting_ID;
        initComponents();
    }

    private void initComponents() throws IOException, ClassNotFoundException {
        panel1 = new JPanel();
        signInLabel = new JLabel();
        signInIcon = new JLabel();
        codeField = new MyJTextField();
        submitButton = new FocusButton();
        out.println("getSignInInfo"); // 获取验证码图片和验证码
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        byte[] imageData = (byte[]) inputStream.readObject();

        // 将字节数组转换为 BufferedImage
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        captchaImage = ImageIO.read(bais);
        bais.close();
        String code = in.readLine();
        System.out.println("验证码：" + code);

        //======== this ========
        setTitle("会议签到");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setForeground(new Color(0xcccccc));
            panel1.setBackground(new Color(0x666666));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
                    . border. EmptyBorder( 0, 0, 0, 0) , " ", javax. swing. border. TitledBorder
                    . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialog" ,java .
                    awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){
                @Override public void propertyChange (java .beans .PropertyChangeEvent e) {
                    if ("border" .equals (e .getPropertyName () )) throw new RuntimeException( );
                }} )
        ;
            panel1.setLayout(null);

            //---- signInLabel ----
            signInLabel.setText("输入验证码：");
            signInLabel.setForeground(new Color(0xcccccc));
            panel1.add(signInLabel);
            signInLabel.setBounds(195, 55, 170, 40);
            signInIcon.setIcon(new ImageIcon(captchaImage));
            panel1.add(signInIcon);
            signInIcon.setBounds(40, 40, 185, 135);
            panel1.add(codeField);
            codeField.setBounds(195, 120, 105, 30);

            //---- submitButton ----
            submitButton.setText("签到");
            submitButton.setBackground(Color.darkGray);
            submitButton.setForeground(Color.lightGray);
            submitButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 开始签到
                    String target = codeField.getText();
                    if (isIdentical(code, target)) {
                        out.println("signInMeeting");
                        out.println(meeting_ID);
                        try {
                            String returnType = in.readLine();
                            if (returnType.equals("signInSuccess")) {
                                System.out.println("签到成功");
                                JOptionPane.showMessageDialog(null, "操作成功");
                                dispose();
                            }
                            if (returnType.equals("signInFail")) {
                                System.out.println("签到失败");
                                JOptionPane.showMessageDialog(null, "签到失败");
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else {
                        System.out.println("验证码不正确");
                    }
                }
            });
            panel1.add(submitButton);
            submitButton.setBounds(160, 210, 85, 30);

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
        panel1.setBounds(0, 0, 400, 270);

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
    private boolean isIdentical(String code, String target) {
        if (code.equals(target)) {
            return true;
        }
        else return false;
    }
}
