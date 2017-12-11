package dropbox.dropbox.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.*;

@Document
public class users {
    public users(){}
    public users(String firstname,String lastname, String password,String email){
        super();
        this.email=email;
        this.firstname=firstname;
        this.lastname = lastname;
        this.password=password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String firstname;
    private String lastname;
    private String email;
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }
}
