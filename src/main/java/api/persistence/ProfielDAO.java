package api.persistence;

import api.model.Profiel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anna on 31-5-2017.
 */
public class ProfielDAO {

    private final static String getProfielenQuery = "select * from profiel;";

    private final static String getProfielQuery = "select * from profiel " +
            " where profiel.id = ?;";

    private final static String wijzigWachtwoordQuery = "update profiel " +
            " set wachtwoord = ? where id = ?;";

    public List<Profiel> profielLijst;

    public ProfielDAO() {

    }

    public List<Profiel> getProfielen() {
        profielLijst = new ArrayList<>();

        //PROFIEL NR 1
        profielLijst.add(new Profiel(0, "mijnnaam", "wachtwoord", "Anna", null,
                "Verbree", new ArrayList<String>(Arrays.asList("Finance", "Handel", "Transport")),
                new ArrayList<String>(Arrays.asList("Finance", "HR", "Functioneel beheer")), "ZZPer",
                "mail@adres.nl", "dit is een cv", "12334242", "Leiden"));
        //PROFIEL NR 2
        profielLijst.add(new Profiel(1, "anderenaam", "mijnwachtwoord", "Piet", "van",
                "Vliet", new ArrayList<String>(Arrays.asList("ict", "Onderwijs")),
                new ArrayList<String>(Arrays.asList("Finance", "HR", "Functioneel beheer")), "admin",
                "mijn@mail.com", "dit is iets van een cv", "552253", "Woerden"));

        return profielLijst;
    }

    public Profiel getProfiel(int id) {
        Profiel profiel = new Profiel();

        for (int i=0; i < profielLijst.size(); i++) {
            if (profielLijst.get(i).getId() == id) {
                profiel = profielLijst.get(i);
            }
        }

        return profiel;
    }

    public void wijzigWachtwoord(Profiel profiel) {
        for (int i=0; i < profielLijst.size(); i++) {
            if (profielLijst.get(i).getId() == profiel.getId()) {
                profielLijst.get(i).setWachtwoord(profiel.getWachtwoord());
            }
        }
    }
}
