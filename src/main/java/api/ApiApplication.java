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
        VacatureDAO vacatureDAO = new VacatureDAO();
        VacatureService vacatureService = new VacatureService(vacatureDAO);
        VacatureResource vacatureResource = new VacatureResource(vacatureService);
        ProfielDAO profielDAO = new ProfielDAO();
        ProfielService profielService = new ProfielService(profielDAO);
        ProfielResource profielResource = new ProfielResource(profielService);

        List<Vacature> vacatures = (List)vacatureResource.retrieveAll();
        for (int i = 0; i < vacatures.size(); i++) {
            System.out.println(vacatures.get(i).getTitel());
        }

        System.out.println();
        System.out.println(vacatureResource.get(3).getTitel());

        System.out.println();

        List<Profiel> profielen = (List)profielResource.retrieveAll();
        for (int i = 0; i < profielen.size(); i++) {
            System.out.println(profielen.get(i).getGebruikersnaam());
        }

        System.out.println();
        Profiel profiel = profielResource.get(1);
        System.out.println(profiel.getGebruikersnaam());
        System.out.println(profiel.getWachtwoord());
        profiel.setWachtwoord("hetnieuwewachtwoord01");

        profielResource.wijzigWachtwoord(profiel);
        System.out.println();
        System.out.println(profielResource.get(1).getWachtwoord());
    }
}
