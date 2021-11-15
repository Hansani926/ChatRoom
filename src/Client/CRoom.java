package Client;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static Client.LoginController.userName;
import static Client.LoginController.users;
public class CRoom  extends Thread implements Initializable{
    public TextArea msgRoom;
    public TextField msgfiled;
    public Label clientName;
    public Label userName;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*private void start() {
    }*/
    @Override
    public void run() {
        try {
            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fulmsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println(fulmsg);
                if (cmd.equalsIgnoreCase(LoginController.userName + ":")) {
                    continue;
                } else if (fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                msgRoom.appendText(msg + "\n");
            }
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*public void handleSentEvent(MouseEvent mouseEvent) {
        send();
        for(String user : users) {
            System.out.println(user.username);
        }
    }*/
    public void send() {

    }

    public void SendOnAction(ActionEvent actionEvent) {
        String msg = msgfiled.getText();
      writer.println(LoginController. userName+ ": " + msg);
        msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
      /*  msgRoom.appendText("Me: " + msg + "\n");*/
        msgRoom.appendText(LoginController.userName + ": "+msg+"\n");
        msgfiled .setText("");
        if(msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }
    }
    public boolean saveControl = false;
    public void handleSentEvent(MouseEvent mouseEvent) {
        send();
        for(String userName : users) {
            System.out.println(userName);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectSocket();
    }
}
