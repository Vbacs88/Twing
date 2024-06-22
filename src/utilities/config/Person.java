/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.config;

/**
 *
 * @author KANYE YEAST
 */
public class Person {
    private final int u_id;
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String type;
    private final String status;

    public Person(int u_id, String firstname, String lastname, String username, String type, String status) {
        this.u_id = u_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.type = type;
        this.status = status;
    }

    public int getID() {
        return u_id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getUserName() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }
}
