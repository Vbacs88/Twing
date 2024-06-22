package utilities.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOclass {
    public static ObservableList<Person> getPersons() {
        ObservableList<Person> personList = FXCollections.observableArrayList();
        dbConnector db = new dbConnector();
        String query = "SELECT u_id, u_fname, u_lname, u_usn, u_type, u_status FROM tbl_user";

        try {
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                int u_id = rs.getInt("u_id");
                String firstname = rs.getString("u_fname");
                String lastname = rs.getString("u_lname");
                String username = rs.getString("u_usn");
                String type = rs.getString("u_type");
                String status = rs.getString("u_status");
                personList.add(new Person(u_id, firstname, lastname, username, type, status));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } 

        return personList;
    }
}
