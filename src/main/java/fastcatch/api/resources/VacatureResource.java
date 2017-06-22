package fastcatch.api.resources;

import fastcatch.api.core.Vacature;
import fastcatch.api.db.VacatureDAO;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Anna on 12-6-2017.
 */
@Path("/vacature")
@Produces(MediaType.APPLICATION_JSON)
public class VacatureResource {
    private final VacatureDAO vacatureDAO;

    public VacatureResource(VacatureDAO dao) { this.vacatureDAO = dao; }

    @GET
    @RolesAllowed("ADMIN")
    public Collection<Vacature> getVacatures() { return vacatureDAO.getVacatures(); }

    @GET
    @Path("/gebruiker/{id}")
    @RolesAllowed("GEBRUIKER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<Vacature> getVacaturesVoorGebruiker(@PathParam("id") int id){ return vacatureDAO.getVacaturesVoorGebruiker(id); }

    @GET
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vacature getVacature(@PathParam("id") int id) { return vacatureDAO.getVacature(id); }

    @POST
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Vacature vacature) {
        vacatureDAO.insert(vacature);
    }

    @DELETE
    @Path("/{id}/archief")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") int id) { vacatureDAO.delete(id); }

}
