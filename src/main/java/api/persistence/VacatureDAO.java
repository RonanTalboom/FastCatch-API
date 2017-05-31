package api.persistence;

import api.model.Vacature;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 30-5-2017.
 */
public class VacatureDAO {

    private final static String getVacaturesQuery = "select * from vacature;";

    private final static String getVacatureDoorId = "select * from vacature " +
            " where vacature.id = ?;";

    public List<Vacature> vacatureLijst;

    public VacatureDAO() {

    }

    public List<Vacature> getVacatures() {
        vacatureLijst = new ArrayList<>();

        //VACATURE NR 1
        vacatureLijst.add(new Vacature(0, "Test Specialist level 3", 40, 50, "Heerlen", "ict",
                "McDonalds", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                1));
        //VACATURE NR 2
        vacatureLijst.add(new Vacature(1, "Docent Aardrijkskunde", 80, 20, "Leiden", "onderwijs",
                "Hogeschool Leiden", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                1));
        //VACATURE NR 3
        vacatureLijst.add(new Vacature(2, "Java Programmeur", 35, 48, "Amsterdam", "ict",
                "Overheid", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                1));
        //VACATURE NR 4
        vacatureLijst.add(new Vacature(3, "Cactuskweker", 53, 60, "Delft", "natuur",
                "Groen inc", "Dit is de korte samenvatting", "Dit is de volledige lange hele hele hele hele hahaha samenvatting",
                1));

        return vacatureLijst;

        //Connection conn = null;
        //PreparedStatement stmt = null;
        //ResultSet rs = null;




    }

    public Vacature getVacature(int id) {
        Vacature vacature = new Vacature();

        for (int i=0; i < vacatureLijst.size(); i++){
            if (vacatureLijst.get(i).getId() == id) {
                vacature = vacatureLijst.get(i);
            }
        }

        return vacature;
    }
}
