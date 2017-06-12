package fastcatch.api.resources;

import fastcatch.api.core.Vacature;
import fastcatch.api.db.VacatureDAO;

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
    public Collection<Vacature> getVacatures() { return vacatureDAO.getVacatures(); }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vacature getVacature(@PathParam("id") int id) { return vacatureDAO.getVacature(id); }
}
