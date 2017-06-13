package fastcatch.api.core;

import javax.annotation.Nullable;
import java.util.ArrayList;

/**
 * Created by Anna on 12-6-2017.
 */
public class Gebruiker {
    private int gebruikerID;
    private String geslacht;
    private String voornaam;
    @Nullable
    private String tussenvoegsel;
    private String achternaam;
    private String soortGebruiker;
    private String telefoonnummer;
    private String cv;
    private String gebruikersnaam;
    //private ArrayList<String> branches;
    //private ArrayList<String> expertises;


    public Gebruiker(int gebruikerID, String geslacht, String voornaam, String tussenvoegsel, String achternaam, String soortGebruiker, String telefoonnummer, String cv, String gebruikersnaam) {
        this.gebruikerID = gebruikerID;
        this.geslacht = geslacht;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.soortGebruiker = soortGebruiker;
        this.telefoonnummer = telefoonnummer;
        this.cv = cv;
        this.gebruikersnaam = gebruikersnaam;
    }

    public Gebruiker() {

    }

    public String getName() {
        if (tussenvoegsel != null) {
            return voornaam + " " + tussenvoegsel + " "
                    + achternaam;
        } else {
            return voornaam + " " + achternaam;
        }
    }

    public int getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(int gebruikerID) {
        this.gebruikerID = gebruikerID;
    }

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



    /*public ArrayList<String> getBranches() { return branches; }
    public void setBranches(ArrayList<String> branches) { this.branches = branches; }

    public ArrayList<String> getExpertises() { return expertises; }
    public void setExpertises(ArrayList<String> expertises) { this.expertises = expertises; }*/
}
