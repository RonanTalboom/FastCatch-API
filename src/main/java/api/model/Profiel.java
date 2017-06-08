package api.model;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

/**
 * Created by Anna on 31-5-2017.
 */
public class Profiel {

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String emailAdres;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String geslacht;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String voornaam;

    @Nullable
    //@JsonView(View.Public.class)
    private String tussenvoegsel;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String achternaam;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String soortGebruiker;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String telefoonnummer;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String cv;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String gebruikersnaam;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String wachtwoord;

    //todo kan dit leeg zijn?
    //@NotEmpty
    //@JsonView(View.Public.class)
    private ArrayList<String> branches;

    //todo kan dit leeg zijn?
    //@NotEmpty
    //@JsonView(View.Public.class)
    private ArrayList<String> expertises;

    public Profiel(String emailAdres, String geslacht, String voornaam, @Nullable String tussenvoegsel,
                   String achternaam, String soortGebruiker, String telefoonnummer, String cv,
                   String gebruikersnaam, String wachtwoord, ArrayList<String> branches, ArrayList<String> expertises) {
        this.emailAdres = emailAdres;
        this.geslacht = geslacht;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.soortGebruiker = soortGebruiker;
        this.telefoonnummer = telefoonnummer;
        this.cv = cv;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.branches = branches;
        this.expertises = expertises;
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

    public String getEmailAdres() { return emailAdres; }
    public void setEmailAdres(String emailAdres) { this.emailAdres = emailAdres; }

    public String getGeslacht() { return geslacht; }
    public void setGeslacht(String geslacht) { this.geslacht = geslacht; }

    public String getVoornaam() { return voornaam; }
    public void setVoornaam(String voornaam) { this.voornaam = voornaam; }

    @Nullable
    public String getTussenvoegsel() { return tussenvoegsel; }
    public void setTussenvoegsel(@Nullable String tussenvoegsel) { this.tussenvoegsel = tussenvoegsel; }

    public String getAchternaam() { return achternaam; }
    public void setAchternaam(String achternaam) { this.achternaam = achternaam; }

    public String getSoortGebruiker() { return soortGebruiker; }
    public void setSoortGebruiker(String soortGebruiker) { this.soortGebruiker = soortGebruiker; }

    public String getTelefoonnummer() { return telefoonnummer; }
    public void setTelefoonnummer(String telefoonnummer) { this.telefoonnummer = telefoonnummer; }

    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }

    public String getGebruikersnaam() { return gebruikersnaam; }
    public void setGebruikersnaam(String gebruikersnaam) { this.gebruikersnaam = gebruikersnaam; }

    public String getWachtwoord() { return wachtwoord; }
    public void setWachtwoord(String wachtwoord) { this.wachtwoord = wachtwoord; }

    public ArrayList<String> getBranches() { return branches; }
    public void setBranches(ArrayList<String> branches) { this.branches = branches; }

    public ArrayList<String> getExpertises() { return expertises; }
    public void setExpertises(ArrayList<String> expertises) { this.expertises = expertises; }
}
