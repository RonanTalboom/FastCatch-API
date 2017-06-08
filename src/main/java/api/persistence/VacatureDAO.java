package api.persistence;

import api.model.Vacature;
import api.util.DatabaseConnector;
import org.apache.commons.dbutils.DbUtils;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 30-5-2017.
 */
public class VacatureDAO {

    private final static String getVacaturesQuery = "select * from vacature;";

    private final static String getVacatureDoorIdQuery = "select * from vacature " +
            " where vacature.id = ?;";

    /*private final static String getMeestBekekenVacatureQuery = "select * from vacature a " +
            " INNER JOIN ( select id, MAX(aantalBekeken) aantalBekeken from vacature b " +
            " group by id ) ON a.id = b.id AND a.aantalBekeken = b.aantalBekeken;";*/

    public VacatureDAO() {

    }

    public List<Vacature> getVacatures() {
        List<Vacature> vacatureLijst = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.prepareStatement(getVacaturesQuery);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vacature vacature = new Vacature();

                vacature.setId(rs.getInt("id"));
                vacature.setBrancheType(rs.getString("BranchebrancheType"));
                vacature.setWerkNiveau(rs.getString("werkNiveau"));
                vacature.setEigenaar(rs.getString("eigenaar"));
                vacature.setKlant(rs.getString("klant"));
                vacature.setLocatie(rs.getString("locatie"));
                vacature.setStartdatum(rs.getString("startdatum"));
                vacature.setEinddatum(rs.getString("einddatum"));
                vacature.setPublicatiedatum(rs.getString("publicatiedatum"));
                vacature.setUitersteAanbiedingsdatum(rs.getString("uitersteAanbiedingsdatum"));
                vacature.setSluitDatum(rs.getString("sluitDatum"));
                vacature.setUurPerWeek(rs.getInt("uurPerWeek"));
                vacature.setAantalVacatures(rs.getInt("aantalVacatures"));
                vacature.setAanvrager(rs.getString("aanvrager"));
                vacature.setOmschrijving(rs.getString("omschrijving"));
                vacature.setSamenvatting(rs.getString("samenvatting"));
                //vacature.setAantalBekeken(rs.getInt("aantalBekeken"));

                vacatureLijst.add(vacature);
        /*VACATURE NR 1
        vacatureLijst.add(new Vacature(0, "Test Specialist level 3", 40, 50, "Heerlen", "ict",
                "McDonalds", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                1));
        //VACATURE NR 2
        vacatureLijst.add(new Vacature(1, "Docent Aardrijkskunde", 80, 20, "Leiden", "onderwijs",
                "Hogeschool Leiden", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                5));
        //VACATURE NR 3
        vacatureLijst.add(new Vacature(2, "Java Programmeur", 35, 48, "Amsterdam", "ict",
                "Overheid", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                2));
        //VACATURE NR 4
        vacatureLijst.add(new Vacature(3, "Cactuskweker", 53, 60, "Delft", "natuur",
                "Groen inc", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                4));*/
        }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(rs);
                DbUtils.closeQuietly(stmt);
                DbUtils.closeQuietly(conn);
            }
        return vacatureLijst;
    }

    public Vacature getVacature(int id) {
        Vacature vacature = new Vacature();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.prepareStatement(getVacatureDoorIdQuery);

            stmt.setInt(1, id);
            stmt.executeQuery();
            rs = stmt.executeQuery();

            if (rs.next()) {
                vacature.setId(rs.getInt("id"));
                vacature.setBrancheType(rs.getString("BranchebrancheType"));
                vacature.setWerkNiveau(rs.getString("werkNiveau"));
                vacature.setEigenaar(rs.getString("eigenaar"));
                vacature.setKlant(rs.getString("klant"));
                vacature.setLocatie(rs.getString("locatie"));
                vacature.setStartdatum(rs.getString("startdatum"));
                vacature.setEinddatum(rs.getString("einddatum"));
                vacature.setPublicatiedatum(rs.getString("publicatiedatum"));
                vacature.setUitersteAanbiedingsdatum(rs.getString("uitersteAanbiedingsdatum"));
                vacature.setSluitDatum(rs.getString("sluitDatum"));
                vacature.setUurPerWeek(rs.getInt("uurPerWeek"));
                vacature.setAantalVacatures(rs.getInt("aantalVacatures"));
                vacature.setAanvrager(rs.getString("aanvrager"));
                vacature.setOmschrijving(rs.getString("omschrijving"));
                vacature.setSamenvatting(rs.getString("samenvatting"));
                //vacature.setAantalBekeken(rs.getInt("aantalBekeken"));

        /*for (int i=0; i < vacatureLijst.size(); i++){
            if (vacatureLijst.get(i).getId() == id) {
                vacature = vacatureLijst.get(i);
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
        return vacature;
    }

    /*public Vacature getMeestBekekenVacature() {
        Vacature vacature = new Vacature();

        /*Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.prepareStatement(getMeestBekekenVacature);
            rs = stmt.executeQuery();

            if (rs.next()) {
                vacature.setId(rs.getInt("id"));
                vacature.setTitel(rs.getString("titel"));
                vacature.setAantalUur(rs.getDouble("aantalUur"));
                vacature.setUurloon(rs.getDouble("uurloon"));
                vacature.setPlaats(rs.getString("plaats"));
                vacature.setBranche(rs.getString("branche"));
                vacature.setOrganisatie(rs.getString("organisatie"));
                vacature.setKorteSamenvatting(rs.getString("korteSamenvatting"));
                vacature.setVolledigeSamenvatting(rs.getString("volledigeSamenvatting"));
                vacature.setAantalBekeken(rs.getInt("aantalBekeken"));*/

        /*Vacature meestBekeken = vacatureLijst.get(0);
        for (int i=1; i < vacatureLijst.size(); i++){
            if (vacatureLijst.get(i).getAantalBekeken() > meestBekeken.getAantalBekeken()) {
                meestBekeken = vacatureLijst.get(i);
            }
        }
        vacature = meestBekeken;*/
        /*  }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }*/
        //return vacature;
    //}
}
