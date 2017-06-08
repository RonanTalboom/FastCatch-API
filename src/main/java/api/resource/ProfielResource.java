package api.resource;

import api.model.Profiel;
import api.service.ProfielService;

import java.util.Collection;

/**
 * Created by Anna on 31-5-2017.
 */
//@Singleton
//@Path("/profielen")
//@Produces(MediaType.APPLICATION_JSON)
public class ProfielResource {
    private final ProfielService profielService;

    //@Inject
    public ProfielResource(ProfielService profielService) { this.profielService = profielService; }

    //@GET
    //@JsonView(View.Public.class)
    //@RolesAllowed({"ADM", "BEH"})
    public Collection<Profiel> retrieveAll() {
        Collection<Profiel> profielen = profielService.getProfielen();
        return profielen;
    }

    //@GET
    //@Path("/id/{id}")
    //@RolesAllowed({"ADM", "BEH"})
    //@JsonView(View.Public.class)
    public Profiel get(/*@PathParam("id")*/ String emailAdres) {
        Profiel profiel = profielService.getProfiel(emailAdres);
        return profiel;
    }

    //@PUT
    //@Path("/{profiel}")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@JsonView(View.Public.class)
    public void wijzigWachtwoord(Profiel profiel) {
        profielService.wijzigWachtwoord(profiel);
    }
}
