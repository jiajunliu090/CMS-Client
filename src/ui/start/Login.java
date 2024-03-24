package ui.start;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import ui.admin.AdminUI;
import ui.element.FocusButton;
import ui.element.FocusableBorderPasswordField;
import ui.element.FocusableBorderTextField;
import ui.user.UserUI;

public class Login extends JFrame {
    private Socket socket;
    private PrintWriter out;
    JTextField userNameField = new FocusableBorderTextField(20);
    JPasswordField passWordField = new FocusableBorderPasswordField(20);
    UserService userService = new UserServiceImpl();
    AdminService adminService = new AdminServiceImpl();

    {
        setBounds(500, 300, 480, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Login() {
        //设置窗口标题
        this.setTitle("会议管理系统");
        //设置窗口大小
        Font font = new Font("楷体",Font.PLAIN,16);
        //添加一个面板作为容器
        JPanel root = new JPanel();
        this.setContentPane(root);
        //添加一个文本框
        root.add(userNameField);
        root.add(passWordField);
        userNameField.setText("");
        //添加标签
        JLabel jLabel1 = new JLabel("账号:");
        JLabel jLabel2 = new JLabel("密码:");
        JLabel jLabel3 = new JLabel("登录/Login");
        root.add(jLabel1);
        root.add(jLabel2);
        root.add(jLabel3);
        //
        FocusButton managerLogin = new FocusButton("管理员登录");
        FocusButton userLogin = new FocusButton("用户登录");
        FocusButton Sign = new FocusButton("注册");
        root.add(managerLogin);
        root.add(userLogin);
        root.add(Sign);
        root.setLayout(null);
        //
        managerLogin.setBounds(80,200,100,30);
        userLogin.setBounds(200,200,100,30);
        Sign.setBounds(320,200,60,30);
        userNameField.setBounds(150,50,200,30);
        passWordField.setBounds(150,125,200,30);
        jLabel1.setBounds(100,50,50,30);
        jLabel2.setBounds(100,125,50,30);
        jLabel3.setBounds(200,10,100,30);
        jLabel3.setFont(font);

        //
        managerLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (test() && adminService.login(userNameField.getText(), passWordField.getText())) {
                    // 管理员登录成功 新建一个管理员界面
                    AdminUI adminUI = new AdminUI(userService, adminService);
                    adminUI.setVisible(true);
                    adminUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        userLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (test()) {
                    if (socket.)
                    // 登录成功后 新建用户UI
                    UserUI userUI = new UserUI(userService);
                    userUI.setVisible(true);
                    // 设置默认关闭行为
                    userUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        Sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //销毁当前页面
                Register sign = new Register();
                sign.setVisible(true);
            }
        });
    }
    public boolean test(){
        String userName = userNameField.getText().trim();
        String passWord = passWordField.getText().trim();
        System.out.println(userName);
        System.out.println(passWord);
        //判断用户名和密码是否为空
        if("".equals(userName)){
            System.out.println("账号不能为空");
            JOptionPane.showMessageDialog(null,"账号不能为空");
            return false;
        }
        else if("".equals(passWord)){
            System.out.println("密码不能为空");
            JOptionPane.showMessageDialog(null,"密码不能为空");
            return false;
        }
        else{
            System.out.println("..");
            return true;
        }
    }
}


