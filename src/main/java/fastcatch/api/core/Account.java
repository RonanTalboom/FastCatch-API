package fastcatch.api.core;

import java.security.Principal;
import java.util.Set;

/**
 * Created by dani on 07/06/2017.
 */
// Dit is een voorbeeld
public class Account implements Principal {
    private int id;
    private String email;
    private String Wachtwoord;



    public Account(int id, String email, String wachtwoord) {
        this.id = id;
        this.email = email;
        this.Wachtwoord = wachtwoord;
    }

    public Account() {

    }

    public String getName() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        Wachtwoord = wachtwoord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


