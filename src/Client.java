import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            // 发送数据到服务端
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from client!");

            // 读取服务端的响应数据
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

            // 关闭连接
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}