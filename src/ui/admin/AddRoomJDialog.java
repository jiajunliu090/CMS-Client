package ui.admin;

import ui.element.FocusButton;
import ui.element.MyJTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AddRoomJDialog extends JDialog {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JPanel contentPane;
    private JLabel roomName;
    private FocusButton buttonOK;
    private MyJTextField room_idField;

    public AddRoomJDialog(Window owner) throws IOException {
        super(owner);
        socket = new Socket("localhost", 12345);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        initComponents();
    }
    private void initComponents() {
        setTitle("add Room");
        contentPane = new JPanel();
        buttonOK = new FocusButton("添加");

        room_idField = new MyJTextField();
        roomName = new JLabel();
        roomName.setText("输入添加的会议室id");
        roomName.setBounds(100, 50, 150, 30);
        add(contentPane);
        contentPane.setLayout(null);
        room_idField.setBounds(95, 100, 130, 30);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String room_id = room_idField.getText();
                if (room_id.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter room ID");
                }else {
                    out.println("add Room");
                    out.println(room_id);
                    out.flush();
                    try {
                        String returnType = in.readLine();
                        if (returnType.equals("add room success")) {
                            JOptionPane.showMessageDialog(AddRoomJDialog.this, "Room added successfully.");
                            dispose();
                        }else JOptionPane.showMessageDialog(AddRoomJDialog.this, "Room not added.");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        contentPane.add(room_idField);
        contentPane.add(roomName);
        buttonOK.setBounds(110, 160, 100, 30);
        contentPane.add(buttonOK);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(550, 330, 330, 280);

    }
}
