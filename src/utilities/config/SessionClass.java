package utilities.config;

public class SessionClass {
    
    private static SessionClass instance;
    private int uid;
    private String fname;
    private String lname;
    private String email;
    private String usn;
    private String type;
    private String status;
    private String auth;
    
    private SessionClass(){
          
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    

    public static synchronized SessionClass getInstance() {
        if(instance == null){
            instance = new SessionClass();
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getAuth() {
        return auth;
    }

    public void getAuth(String auth) {
        this.auth = auth;
    }
    
}
