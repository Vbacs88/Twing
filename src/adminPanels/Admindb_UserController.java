package adminPanels;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Admindb_UserController {
    
    private Stage stage;
    private Scene scene;
    
    @FXML
    private AnchorPane bg;
    
    public void buttonMinimize(ActionEvent event)throws IOException{
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    
    public void buttonExit(ActionEvent event) throws IOException {
        System.out.println("Test");
        stage = (Stage) bg.getScene().getWindow();
        System.out.println("You Pressed Exit");
        stage.close();
    }
    
}
