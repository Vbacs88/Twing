
package twing;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import utilities.config.PasswordHasher;
import utilities.config.dbConnector;



public class loginController {
    
    static String status;
    static String type;
    
    private Stage stage;
    private Stage stage2;
    private Scene scene;
    private Scene scene2;
    
    @FXML
    private AnchorPane bgLogin;
    @FXML
    private TextField fxuserField;
    @FXML
    private PasswordField fxpasswordField;
    
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM tbl_user WHERE u_usn = '" +username+ "' AND u_pass = '" +password+ "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    
    public double centerStageX(int windowWidth){
        double centerX = screenBounds.getWidth() / 2;
        double n = centerX - windowWidth / 2;
        return n;
    }
    
    public double centerStageY(int windowHeight){
        double centerY = screenBounds.getHeight() / 2;
        double n = centerY - windowHeight / 2;
        return n;
    }
    
    public void buttonLogin(ActionEvent event) throws IOException {
        PasswordHasher psh = new PasswordHasher();
        String usernameIn = fxuserField.getText();
        String passwordIn = psh.hashPassword(fxpasswordField.getText());
        System.out.println("Input Text: " + usernameIn);
        //---
        Parent root = FXMLLoader.load(getClass().getResource("/adminPanels/AdminMain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setX(centerStageX(1348));
        stage.setY(centerStageY(907));
        //---
        scene = new Scene(root, Color.TRANSPARENT);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        System.out.println(""+usernameIn+" "+passwordIn);
        
        if(loginAcc(usernameIn, passwordIn)){
            if(!status.equals("Active")){
                System.out.println("User Not Active");
            }else{
                if(type.equals("User")){
                    System.out.println("Login Success as User");
                    stage.show();
                }else if(type.equals("Admin")){
                    System.out.println("Login Success as Admin");
                    stage.show();
                }else{
                    System.out.println("Error");
                }
            }
        }else{
            System.out.println("Log in Failed");
        }
        
        System.out.println("WUUUT");
    }
    
    public void buttonRegister(ActionEvent event)throws IOException{
        Parent root2 = FXMLLoader.load(getClass().getResource("/twing/Register.fxml"));
        stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene2 = new Scene(root2, Color.TRANSPARENT);
        scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage2.setY(centerStageY(642));
        stage2.setX(centerStageX(986));
        stage2.setScene(scene2);
        stage2.show();
    }
    
    public void buttonMinimize(ActionEvent event)throws IOException{
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    
    public void buttonExit(ActionEvent event) throws IOException {
        System.out.println("Test");
        stage = (Stage) bgLogin.getScene().getWindow();
        System.out.println("You Pressed Exit");
        stage.close();
    }
    
}
