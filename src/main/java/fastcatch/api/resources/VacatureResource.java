package fastcatch.api.resources;

import fastcatch.api.core.Vacature;
import fastcatch.api.db.VacatureDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Anna on 12-6-2017.
 */
@Path("/vacature")
@Produces(MediaType.APPLICATION_JSON)
public class VacatureResource {
    private final VacatureDAO vacatureDAO;

    public VacatureResource(VacatureDAO dao) { this.vacatureDAO = dao; }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vacature getVacature(@PathParam("id") int id) { return vacatureDAO.getVacature(id); }
}
