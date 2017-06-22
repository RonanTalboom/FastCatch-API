package fastcatch.api.resources;

import fastcatch.api.core.Vacature;
import fastcatch.api.db.VacatureDAO;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Deze klasse regelt alle requests voor vacatures.
 *
 * @author Anna
 */
@Path("/vacature")
@Produces(MediaType.APPLICATION_JSON)
public class VacatureResource {
    private final VacatureDAO vacatureDAO;

    public VacatureResource(VacatureDAO dao) { this.vacatureDAO = dao; }

    /**
     * Request waarmee admins alle vacatures op kunnen halen.
     * @return vacaturelijst
     */
    @GET
    @RolesAllowed("ADMIN")
    public Collection<Vacature> getVacatures() { return vacatureDAO.getVacatures(); }

    /**
     * Request waarmee een gebruiker alle vacatures die voor hem/haar
     * interessant zijn ophaalt.
     * @param id
     * @return vacaturelijst
     */
    @GET
    @Path("/gebruiker/{id}")
    @RolesAllowed("GEBRUIKER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<Vacature> getVacaturesVoorGebruiker(@PathParam("id") int id){ return vacatureDAO.getVacaturesVoorGebruiker(id); }

    /**
     * Request waarmee gebruikers een vacature op kunnen halen
     * met behulp van de bijbehorende id.
     * @param id
     * @return vacature
     */
    @GET
    @Path("/{id}")
    @RolesAllowed("GEBRUIKER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vacature getVacature(@PathParam("id") int id) { return vacatureDAO.getVacature(id); }

    /**
     * Request waarmee een admin een nieuwe vacature kan toevoegen.
     * @param vacature
     */
    @POST
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Vacature vacature) {
        vacatureDAO.insert(vacature);
    }

    /**
     * Request waarmee een admin een vacature met behulp van de
     * bijbehorende id op non-actief kan zetten.
     * @param id
     */
    @DELETE
    @Path("/{id}/archief")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") int id) { vacatureDAO.delete(id); }

}
