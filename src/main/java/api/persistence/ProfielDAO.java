package api.persistence;

import api.model.Profiel;
import api.util.DatabaseConnector;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anna on 31-5-2017.
 */
public class ProfielDAO {

    private final static String getProfielenQuery = "select * from profiel;";

    private final static String getProfielQuery = "select * from profiel " +
            " where profiel.emailAdres = ?;";

    private final static String wijzigWachtwoordQuery = "update profiel " +
            " set wachtwoord = ? where emailAdres = ?;";

    public ProfielDAO() {

    }

    public List<Profiel> getProfielen() {
        List<Profiel> profielLijst = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.prepareStatement(getProfielenQuery);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Profiel profiel = new Profiel();

                profiel.setEmailAdres(rs.getString("emailAdres"));
                profiel.setGeslacht(rs.getString("geslacht"));
                profiel.setVoornaam(rs.getString("voornaam"));
                profiel.setTussenvoegsel(rs.getString("tussenvoegsel"));
                profiel.setAchternaam(rs.getString("achternaam"));
                profiel.setSoortGebruiker(rs.getString("soortGebruiker"));
                profiel.setTelefoonnummer(rs.getString("telefoonnummer"));
                profiel.setCv(rs.getString("cv"));
                profiel.setGebruikersnaam(rs.getString("gebruikersnaam"));
                profiel.setWachtwoord(rs.getString("wachtwoord"));

                profielLijst.add(profiel);
        /*PROFIEL NR 1
        profielLijst.add(new Profiel(0, "mijnnaam", "wachtwoord", "Anna", null,
                "Verbree", new ArrayList<String>(Arrays.asList("Finance", "Handel", "Transport")),
                new ArrayList<String>(Arrays.asList("Finance", "HR", "Functioneel beheer")), "ZZPer",
                "mail@adres.nl", "dit is een cv", "12334242", "Leiden"));
        //PROFIEL NR 2
        profielLijst.add(new Profiel(1, "anderenaam", "mijnwachtwoord", "Piet", "van",
                "Vliet", new ArrayList<String>(Arrays.asList("ict", "Onderwijs")),
                new ArrayList<String>(Arrays.asList("Finance", "HR", "Functioneel beheer")), "admin",
                "mijn@mail.com", "dit is iets van een cv", "552253", "Woerden"));*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(rs);
                DbUtils.closeQuietly(stmt);
                DbUtils.closeQuietly(conn);
            }
            return profielLijst;
    }

    public Profiel getProfiel(String emailAdres) {
        Profiel profiel = new Profiel();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.prepareStatement(getProfielQuery);

            stmt.setString(1, emailAdres);
            stmt.executeQuery();
            rs = stmt.executeQuery();

            if (rs.next()) {
                profiel.setEmailAdres(rs.getString("emailAdres"));
                profiel.setGeslacht(rs.getString("geslacht"));
                profiel.setVoornaam(rs.getString("voornaam"));
                profiel.setTussenvoegsel(rs.getString("tussenvoegsel"));
                profiel.setAchternaam(rs.getString("achternaam"));
                profiel.setSoortGebruiker(rs.getString("soortGebruiker"));
                profiel.setTelefoonnummer(rs.getString("telefoonnummer"));
                profiel.setCv(rs.getString("cv"));
                profiel.setGebruikersnaam(rs.getString("gebruikersnaam"));
                profiel.setWachtwoord(rs.getString("wachtwoord"));

        /*for (int i=0; i < profielLijst.size(); i++) {
            if (profielLijst.get(i).getId() == id) {
                profiel = profielLijst.get(i);
            }
        }*/
          }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }
        return profiel;
    }

    public void wijzigWachtwoord(Profiel profiel) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.prepareStatement(wijzigWachtwoordQuery);

            stmt.setString(1, profiel.getWachtwoord());
            stmt.setString(2, profiel.getEmailAdres());

        /*for (int i=0; i < profielLijst.size(); i++) {
            if (profielLijst.get(i).getId() == profiel.getId()) {
                profielLijst.get(i).setWachtwoord(profiel.getWachtwoord());
            }
        }*/
          stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }

    }
}
