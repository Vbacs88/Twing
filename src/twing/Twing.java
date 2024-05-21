package twing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Twing extends Application {
    
    public static void main(String[] args) {
        
        launch(args);
    }
    
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    
    public double centerStageX(){
        double centerX = screenBounds.getWidth() / 2;
        int windowWidth = 986;
        double n = centerX - windowWidth / 2;
        return n;
    }
    
    public double centerStageY(){
        double centerY = screenBounds.getHeight() / 2;
        int windowHeight = 642;
        double n = centerY - windowHeight / 2;
        return n;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("TripWing");
        stage.getIcons().add(new Image(Twing.class.getResourceAsStream("/twing/TwingIcon.png")));
        //--
        Font.loadFont(getClass().getResource("/fonts/Poppins-Regular.ttf").toExternalForm(), 10);
        //--
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, Color.TRANSPARENT);
        
        //CSS
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        //Center Stage
        stage.setX(centerStageX());
        stage.setY(centerStageY());
        
        //Set Stage
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        
    }


}
