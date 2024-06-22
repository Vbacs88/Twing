package adminPanels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AdminMainController {
    
    
    @FXML
    private AnchorPane fx_adminAnchorPane;
    
    @FXML
    private BorderPane fx_mainPane;
    
    
    @FXML
    private void handleButtonAction1 (ActionEvent event) {
        System.out.println("You Clicked me!");
        FXML_MainLoader object = new FXML_MainLoader();
        Pane view = object.getPage("userPanel");
        fx_mainPane.setCenter(view);
        
    }
    
    private void handleButtonAction2 (ActionEvent event) {
        System.out.println("You Clicked me!");
        FXML_MainLoader object = new FXML_MainLoader();
        Pane view = object.getPage("screen 2");
        fx_mainPane.setCenter(view);
        
    }
    
    private void handleButtonAction3 (ActionEvent event) {
        System.out.println("You Clicked me!");
        FXML_MainLoader object = new FXML_MainLoader();
        Pane view = object.getPage("screen 3");
        fx_mainPane.setCenter(view);
        
    }
    
    private void handleButtonAction4 (ActionEvent event) {
        System.out.println("You Clicked me!");
        FXML_MainLoader object = new FXML_MainLoader();
        Pane view = object.getPage("screen 4");
        fx_mainPane.setCenter(view);
        
    }

}
