/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminPanels;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import twing.Twing;

/**
 *
 * @author KANYE YEAST
 */
public class FXML_MainLoader {
    
    private Pane view;
    
    public Pane getPage(String fileName){
        try {
            URL fileUrl = Twing.class.getResource("/adminPanels/" + fileName + ".fxml");
            
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file '" + fileName + ".fxml' can't be found");
            }
            
            view = new FXMLLoader().load(fileUrl);
            
        } catch (Exception e){
            System.out.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace(); // Print the full stack trace for debugging
        }
        
        return view;
    }
}

