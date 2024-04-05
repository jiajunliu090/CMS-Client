package ui.start;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    {
        setBounds(500, 300, 480, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Login() throws IOException {
        //设置窗口标题
        this.setTitle("会议管理系统");
        socket = new Socket("localhost", 12345);
        out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

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
                if (test()) {
                    String userName = userNameField.getText().trim();
                    String passWord = passWordField.getText().trim();
                    out.println("AdminLogin"); // 发送登录类型标识
                    out.println(userName); // 发送用户名
                    out.println(passWord); // 发送密码
                    out.flush(); // 确保数据发送到服务器

                    String response = null; // 从服务器接收响应
                    try {
                        response = in.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if ("LoginSuccess".equals(response)) {
                        // 管理员登录成功，执行下一步操作
                        AdminUI adminUI = null;
                        try {
                            adminUI = new AdminUI(userNameField.getText());
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        adminUI.setVisible(true);
                        adminUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        // 管理员登录失败，显示错误消息
                        JOptionPane.showMessageDialog(null, "管理员登录失败");
                    }
                }

            }
        });
        userLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (test()) {
                    String userName = userNameField.getText().trim();
                    String passWord = passWordField.getText().trim();
                    out.println("UserLogin"); // 发送登录类型标识
                    out.println(userName); // 发送用户名
                    out.println(passWord); // 发送密码
                    out.flush(); // 确保数据发送到服务器

                    String response = null; // 从服务器接收响应
                    try {
                        response = in.readLine();
                        System.out.println(response);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if ("LoginSuccess".equals(response)) {
                        // 用户登录成功，执行下一步操作
                        UserUI userUI = null;
                        try {
                            userUI = new UserUI(userName);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        userUI.setVisible(true);
                        userUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        // 用户登录失败，显示错误消息
                        JOptionPane.showMessageDialog(null, "用户登录失败");
                    }
                }
            }
        });
        Sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //销毁当前页面
                Register sign = null;
                try {
                    sign = new Register();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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


