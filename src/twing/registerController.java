/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twing;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import utilities.config.PasswordHasher;
import utilities.config.dbConnector;

public class registerController {
    
    private Stage stage, stagelogin;
    private Scene scenelogin;
    public static String email, uname;
    private Parent root;
    //Choice Box Array List
    ObservableList<String> authorizationList = FXCollections.observableArrayList("User","Admin");
    
    @FXML
    private Label fx_warn1, fx_warn2, fx_warn3, fx_warn4, fx_warn5, fx_warn6;
    @FXML
    private TextField fx_fname, fx_lname, fx_uname, fx_email;
    @FXML
    private PasswordField fx_password, fx_cpassword;
    @FXML
    private ChoiceBox regChoiceBox;
    @FXML
    private AnchorPane bgLogin;
    
    @FXML
    private void initialize() throws IOException{
        //SceneBuild
        root = FXMLLoader.load(getClass().getResource("/twing/Login.fxml"));
        //Values
        regChoiceBox.setItems(authorizationList);
        regChoiceBox.setValue("User");
        fx_warn1.setText("");
        fx_warn2.setText("");
        fx_warn3.setText("");
        fx_warn4.setText("");
        fx_warn5.setText("");
        fx_warn6.setText("");
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
    
    public boolean fieldCheck(){
        boolean r = true;
        
        if(fx_fname.getText().isEmpty()){
            fx_warn1.setText("Field Required");
            r = false;
        }
        if(fx_lname.getText().isEmpty()){
            fx_warn2.setText("Field Required");
            r = false;
        }
        if(fx_uname.getText().isEmpty()){
            fx_warn3.setText("Field Required");
            r = false;
        }
        if(fx_email.getText().isEmpty()){
            fx_warn4.setText("Field Required");
            r = false;
        }
        if(fx_password.getText().isEmpty()){
            fx_warn5.setText("Field Required");
            r = false;
        }
        else if(fx_password.getText().length()<8){
            fx_warn5.setText("Password is too short!");
            r = false;
        }
        else if(!(fx_password.getText().equals(fx_cpassword.getText()))){
            fx_warn5.setText("Password does not match");
            r = false;
        }
        if(fx_cpassword.getText().isEmpty()){
            fx_warn6.setText("Field Required");
            r = false;
        }
        
        return r;
    }
    
    public boolean duplicateCheck(){
        dbConnector dbc = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_usn = '" + fx_uname.getText() + "' OR u_email = '" + fx_email.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(fx_email.getText())){
                    fx_warn4.setText("Email aldready used");
                }
                uname  = resultSet.getString("u_usn");
                if(uname.equals(fx_uname.getText())){
                    fx_warn3.setText("Username aldready used");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public void buttonRegister(ActionEvent event)throws IOException{
        
        boolean status = false;
        
        fx_warn1.setText("");
        fx_warn2.setText("");
        fx_warn3.setText("");
        fx_warn4.setText("");
        fx_warn5.setText("");
        fx_warn6.setText("");
        
        if(!fieldCheck()){
            System.out.println("Input error");
        }
        else if(duplicateCheck()){
            System.out.println("Duplicate Exist");
        }else{
            
            dbConnector dbc = new dbConnector();
            PasswordHasher ph = new PasswordHasher();    
            String password = ph.hashPassword(fx_password.getText());
            
            if(dbc.insertData("INSERT INTO tbl_user (u_fname, u_lname, u_usn, u_email, u_pass, u_type, u_status, auth_pass) "
                    + "VALUES ('"+fx_fname.getText()+"', '"+fx_lname.getText()+"', '"+fx_uname.getText()+"', "
                            + "'"+fx_email.getText()+"', '"+password+"', '"+regChoiceBox.getValue().toString()+"', 'Pending', 'None')")){
                System.out.println("Success");
                status = true;
            }else{
                System.out.println("Connection Error");
            }
        }
        
        if(status){
            stagelogin = (Stage)((Node)event.getSource()).getScene().getWindow();
            scenelogin = new Scene(root, Color.TRANSPARENT);
            scenelogin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stagelogin.setY(centerStageY(642));
            stagelogin.setX(centerStageX(986));
            stagelogin.setScene(scenelogin);
            stagelogin.show();
        }
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
    
    public void buttonBack(ActionEvent event)throws IOException{
        stagelogin = (Stage)((Node)event.getSource()).getScene().getWindow();
        scenelogin = new Scene(root, Color.TRANSPARENT);
        scenelogin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stagelogin.setY(centerStageY(642));
        stagelogin.setX(centerStageX(986));
        stagelogin.setScene(scenelogin);
        stagelogin.show();
    }
    
}
