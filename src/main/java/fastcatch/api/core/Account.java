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
    private int actief;
    private final Set<String> roles;


    public Account(int id, String email, String wachtwoord, int actief) {
        this.id = id;
        this.email = email;
        this.Wachtwoord = wachtwoord;
        this.actief = actief;
        this.roles = null;
    }

    public Account(String email, Set<String> roles) {
        this.email = email;
        this.roles = roles;
    }

    public String getName() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
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

    public int getActief() {
        return actief;
    }

    public void setActief(int actief) {
        this.actief = actief;
    }
}


