
import com.formdev.flatlaf.FlatLightLaf;
import ui.start.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        FlatLightLaf.setup();
        Login login = new Login();
        login.setVisible(true);
    }
}