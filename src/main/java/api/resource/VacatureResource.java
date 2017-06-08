package api.resource;

import api.model.Vacature;
import api.service.VacatureService;

import java.util.Collection;

/**
 * Created by Anna on 30-5-2017.
 */
//@Singleton
//@Path("/vacatures")
//@Produces(MediaType.APPLICATION_JSON)
public class VacatureResource {
    private final VacatureService vacatureService;

    //@Inject
    public VacatureResource(VacatureService vacatureService) {
        this.vacatureService = vacatureService;
    }

    //@GET
    //@JsonView(View.Public.class)
    //@RolesAllowed({"ADM", "BEH"})
    public Collection<Vacature> retrieveAll() {
        Collection<Vacature> vacatures = vacatureService.getVacatures();
        return vacatures;
    }

    //@GET
    //@Path("/id/{id}")
    //@RolesAllowed({"ADM", "BEH"})
    //@JsonView(View.Public.class)
    public Vacature get(/*@PathParam("id")*/ int id) {
        Vacature vacature = vacatureService.getVacature(id);
        return vacature;
    }

    //@GET
    //@RolesAllowed({"ADM"})
    //@JsonView(View.Public.class_
    /*public Vacature getMeestBekeken() {
        Vacature vacature = vacatureService.getMeestBekekenVacature();
        return vacature;
    }*/
}
