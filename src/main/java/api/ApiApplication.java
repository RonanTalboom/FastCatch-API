package api;

import api.model.Profiel;
import api.model.Vacature;
import api.persistence.ProfielDAO;
import api.persistence.VacatureDAO;
import api.resource.ProfielResource;
import api.resource.VacatureResource;
import api.service.ProfielService;
import api.service.VacatureService;

import java.util.List;

/**
 * Created by Anna on 30-5-2017.
 */
public class ApiApplication {

    public static void main(String[] args) {
        //Maak alle andere klassen aan
        VacatureDAO vacatureDAO = new VacatureDAO();
        VacatureService vacatureService = new VacatureService(vacatureDAO);
        VacatureResource vacatureResource = new VacatureResource(vacatureService);
        ProfielDAO profielDAO = new ProfielDAO();
        ProfielService profielService = new ProfielService(profielDAO);
        ProfielResource profielResource = new ProfielResource(profielService);

        //Haal de lijst met alle vacatures op en print de titels
        List<Vacature> vacatures = (List)vacatureResource.retrieveAll();
        for (int i = 0; i < vacatures.size(); i++) {
            System.out.println(vacatures.get(i).getTitel());
        }

        System.out.println();
        //Print de titel van de vacature met id 3
        System.out.println(vacatureResource.get(3).getTitel());

        System.out.println();
        //Print de titel van de meest bekeken vacature
        System.out.println(vacatureResource.getMeestBekeken().getTitel());

        System.out.println();

        //Haal de lijst met alle profielen op en print de gebruikersnamen
        List<Profiel> profielen = (List)profielResource.retrieveAll();
        for (int i = 0; i < profielen.size(); i++) {
            System.out.println(profielen.get(i).getGebruikersnaam());
        }

        System.out.println();
        //Haal het profiel met id 1 op en print de gebruikersnaam en het wachtwoord
        Profiel profiel = profielResource.get(1);
        System.out.println(profiel.getGebruikersnaam());
        System.out.println(profiel.getWachtwoord());
        //Verander het wachtwoord van het profiel
        profiel.setWachtwoord("hetnieuwewachtwoord01");

        //Wijzig het wachtwoord in de lijst en print het wachtwoord
        profielResource.wijzigWachtwoord(profiel);
        System.out.println();
        System.out.println(profielResource.get(1).getWachtwoord());
    }
}
