package ui.user;

import model.Captcha;
import service.UserService;
import utilities.CaptchaGenerator;
import view.element.FocusButton;
import view.element.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignInForMeetingJDialog extends JDialog {
    private JPanel panel1;
    private JLabel signInLabel;
    private JLabel signInIcon;
    private MyJTextField codeField;
    private FocusButton submitButton;
    private Captcha captcha;
    private UserService userService;
    private String meeting_ID;
    public SignInForMeetingJDialog(Window owner, UserService userService, String meeting_ID) {
        super(owner);
        this.userService = userService;
        this.meeting_ID = meeting_ID;
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        signInLabel = new JLabel();
        signInIcon = new JLabel();
        codeField = new MyJTextField();
        submitButton = new FocusButton();
        captcha = CaptchaGenerator.generateCaptcha();
        //======== this ========
        setTitle("\u4f1a\u8bae\u7b7e\u5230");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setForeground(new Color(0xcccccc));
            panel1.setBackground(new Color(0x666666));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
                    . border. EmptyBorder( 0, 0, 0, 0) , " ", javax. swing. border. TitledBorder
                    . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
                    awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
            panel1.setLayout(null);

            //---- signInLabel ----
            signInLabel.setText("\u8f93\u5165\u9a8c\u8bc1\u7801\uff1a");
            signInLabel.setForeground(new Color(0xcccccc));
            panel1.add(signInLabel);
            signInLabel.setBounds(195, 55, 170, 40);
            signInIcon.setIcon(new ImageIcon(captcha.getImage()));
            panel1.add(signInIcon);
            signInIcon.setBounds(40, 40, 185, 135);
            panel1.add(codeField);
            codeField.setBounds(195, 120, 105, 30);

            //---- submitButton ----
            submitButton.setText("\u7b7e\u5230");
            submitButton.setBackground(Color.darkGray);
            submitButton.setForeground(Color.lightGray);
            submitButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (codeField.getText().equals(captcha.getCode())) {
                        if(userService.signInMeeting(meeting_ID)) {
                            // 弹出签到成功的画面
                            System.out.println("签到成功");
                        }
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
}
