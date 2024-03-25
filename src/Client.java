
import com.formdev.flatlaf.FlatLightLaf;
import ui.start.Login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        FlatLightLaf.setup();
        try {
            Socket socket = new Socket("localhost", 12345); // socket连接

            // 发送数据到服务端
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Login login = new Login();
            login.setVisible(true);

            // 关闭连接
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}