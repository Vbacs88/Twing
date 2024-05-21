package adminPanels;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class AdmindbController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
        
    @FXML
    private Button fxbuttonPanel2, fxbuttonPanel3, fxbuttonPanel4, fxbuttonPanel5, fxbuttonPanel6, fxbuttonPanel7, fxbuttonPanel8, fxbuttonPanel9, fxbuttonPanel10;
    
    @FXML
    private Rectangle fxR2, fxR3, fxR4, fxR5, fxR6, fxR7, fxR8, fxR9, fxR10;
    
    @FXML
    private AnchorPane bgRegister;
    
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
    
    public void initialize(){
        
        fxbuttonPanel2.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR2.setFill(Color.web("#ffffff"));
            }else{
                fxR2.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel3.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR3.setFill(Color.web("#ffffff"));
            }else{
                fxR3.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel4.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR4.setFill(Color.web("#ffffff"));
            }else{
                fxR4.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel5.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR5.setFill(Color.web("#ffffff"));
            }else{
                fxR5.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel6.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR6.setFill(Color.web("#ffffff"));
            }else{
                fxR6.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel7.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR7.setFill(Color.web("#ffffff"));
            }else{
                fxR7.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel8.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR8.setFill(Color.web("#ffffff"));
            }else{
                fxR8.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel9.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR9.setFill(Color.web("#ffffff"));
            }else{
                fxR9.setFill(Color.web("#f6f6f6"));
            }
        });
        
        fxbuttonPanel10.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                fxR10.setFill(Color.web("#ffffff"));
            }else{
                fxR10.setFill(Color.web("#f6f6f6"));
            }
        });
        
    }
    
    public void buttonUser(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("/adminPanels/Admindb_User.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setX(centerStageX(1361));
        stage.setY(centerStageY(901));
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.show();
    }
    
    public void buttonMinimize(ActionEvent event)throws IOException{
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    
    public void buttonExit(ActionEvent event) throws IOException {
        System.out.println("Test");
        stage = (Stage) bgRegister.getScene().getWindow();
        System.out.println("You Pressed Exit");
        stage.close();
    }
    
}
