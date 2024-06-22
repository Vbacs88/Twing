package adminPanels;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utilities.config.DAOclass;
import utilities.config.Person;

public class userPanelController {
    
     @FXML
    private TableView<Person> tableView;
    
    @FXML
    private TableColumn<Person, Integer> fx_id;

    @FXML
    private TableColumn<Person, String> fx_fullname;

    @FXML
    private TableColumn<Person, String> fx_username;
    
    @FXML
    private TableColumn<Person, String> fx_type;
    
    @FXML
    private TableColumn<Person, String> fx_status;

    @FXML
    private void initialize() {
    // Initialize the columns
    fx_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
    fx_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName")); // Use the combined name
    fx_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
    fx_type.setCellValueFactory(new PropertyValueFactory<>("type"));
    fx_status.setCellValueFactory(new PropertyValueFactory<>("status"));
    
    // Load data from the database
    ObservableList<Person> personList = DAOclass.getPersons();
    tableView.setItems(personList);
    }
}
