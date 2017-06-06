package api.model;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

/**
 * Created by Anna on 31-5-2017.
 */
public class Profiel {

    //@NotEmpty
    //@JsonView(View.Public.class)
    private int id;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String gebruikersnaam;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String wachtwoord;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String voornaam;

    @Nullable
    //@JsonView(View.Public.class)
    private String tussenvoegsel;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String achternaam;

    //todo kan dit leeg zijn?
    //@NotEmpty
    //@JsonView(View.Public.class)
    private ArrayList<String> branches;

    //todo kan dit leeg zijn?
    //@NotEmpty
    //@JsonView(View.Public.class)
    private ArrayList<String> expertises;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String gebruikerSoort;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String emailAdres;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String cv;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String telefoonnummer;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String woonplaats;

    public Profiel(int id, String gebruikersnaam, String wachtwoord, String voornaam, @Nullable String tussenvoegsel,
                   String achternaam, ArrayList<String> branches, ArrayList<String> expertises, String gebruikerSoort,
                   String emailAdres, String cv, String telefoonnummer, String woonplaats) {
        this.id = id;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.branches = branches;
        this.expertises = expertises;
        this.gebruikerSoort = gebruikerSoort;
        this.emailAdres = emailAdres;
        this.cv = cv;
        this.telefoonnummer = telefoonnummer;
        this.woonplaats = woonplaats;
    }

    public Profiel() {

    }

    //@Override
    //@JsonIgnore
    public String getName() {
        if (tussenvoegsel != null) {
            return voornaam + " " + tussenvoegsel + " "
                    + achternaam;
        } else {
            return voornaam + " " + achternaam;
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getGebruikersnaam() { return gebruikersnaam; }
    public void setGebruikersnaam(String gebruikersnaam) { this.gebruikersnaam = gebruikersnaam; }

    public String getWachtwoord() { return wachtwoord; }
    public void setWachtwoord(String wachtwoord) { this.wachtwoord = wachtwoord; }

    public String getVoornaam() { return voornaam; }
    public void setVoornaam(String voornaam) { this.voornaam = voornaam; }

    @Nullable
    public String getTussenvoegsel() { return tussenvoegsel; }
    public void setTussenvoegsel(@Nullable String tussenvoegsel) { this.tussenvoegsel = tussenvoegsel; }

    public String getAchternaam() { return achternaam; }
    public void setAchternaam(String achternaam) { this.achternaam = achternaam; }

    public ArrayList<String> getBranches() { return branches; }
    public void setBranches(ArrayList<String> branches) { this.branches = branches; }

    public ArrayList<String> getExpertises() { return expertises; }
    public void setExpertises(ArrayList<String> expertises) { this.expertises = expertises; }

    public String getGebruikerSoort() { return gebruikerSoort; }
    public void setGebruikerSoort(String gebruikerSoort) { this.gebruikerSoort = gebruikerSoort; }

    public String getEmailAdres() { return emailAdres; }
    public void setEmailAdres(String emailAdres) { this.emailAdres = emailAdres; }

    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }

    public String getTelefoonnummer() { return telefoonnummer; }
    public void setTelefoonnummer(String telefoonnummer) { this.telefoonnummer = telefoonnummer; }

    public String getWoonplaats() { return woonplaats; }
    public void setWoonplaats(String woonplaats) { this.woonplaats = woonplaats; }
}
