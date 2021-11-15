package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    public static String userName;
    public static String pw;
   /* public static ArrayList<User> loggedInUser = new ArrayList<>();*/
    /*public static ArrayList<User> users = new ArrayList<User>();*/
    public PasswordField txtpw;
    public TextField txtusername;
public static ArrayList<String> users=new ArrayList<>();
    public AnchorPane root;

    public void Login(ActionEvent actionEvent) throws IOException {
       /* userName=txtusername.getText();
        pw=txtpw.getText();
       boolean islog=false;
       if (users.isEmpty()){
           users.add(userName);
           islog=true;
       }
       for (String s:users){
           if (!s.equalsIgnoreCase(userName)){
               islog=true;
               System.out.println(userName);
               break;
           }

       }
       if (islog){
          this.root.getChildren().clear();
          this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("CRoom.fxml")));
       }*/
        /*username = Username.getText();
        password=txtpw.getText();
        boolean login = false;
        for (User x : users) {
            if (x.name.equalsIgnoreCase(username) && x.password.equalsIgnoreCase(password)) {
                login = true;
                loggedInUser.add(x);
                System.out.println(x.name);

                break;
            }
        }
        if (login) {
            changeWindow();
        } else {
            loginNotifier.setOpacity(1);
        }*/
    }

    public void login(ActionEvent actionEvent) throws IOException {
        userName=txtusername.getText();
        pw=txtpw.getText();
        boolean islog=false;
        if (users.isEmpty()){
            users.add(userName);
            islog=true;
        }
        for (String s:users){
            if (!s.equalsIgnoreCase(userName)){
                islog=true;
                System.out.println(userName);
                break;
            }

        }
        if (islog){
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("CRoom.fxml")));
        }
    }
}
