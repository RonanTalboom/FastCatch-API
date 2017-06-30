package fastcatch.api.resources;

import fastcatch.api.core.Expertise;
import fastcatch.api.core.Vacature;
import fastcatch.api.core.mappers.VacatureMapperExtra;
import fastcatch.api.db.VacatureDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

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
     * Request waarmee admins alle niet actieve vacatures op kunnen halen.
     * @return vacaturelijst
     */
    @GET
    @Path("/archief")
    @RolesAllowed("ADMIN")
    public Collection<Vacature> getArchiefVacatures() { return vacatureDAO.getArchiefVacatures(); }

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
    @RegisterMapper(VacatureMapperExtra.class)
    public void insert(Vacature vacature) {
        vacatureDAO.insert(vacature);
        int id = vacatureDAO.getID();

        vacatureDAO.insertBranche(id, vacature.getBranchType());

        for(Expertise e : vacature.getExpertiseType()) {
            vacatureDAO.insertExpertise(id, e.getExpertiseType());
        }
    }

    /**
     * Request waarmee een admin een vacature met behulp van de
     * bijbehorende id op non-actief kan zetten.
     * @param id
     */
    @DELETE
    @Path("/archief/{id}")
    @RolesAllowed("ADMIN")
    public void archiveer(@PathParam("id") int id) { vacatureDAO.archiveer(id); }

    @DELETE
    @Path("/verwijder/{id}")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") int id) { vacatureDAO.delete(id); }

    /**
     * Request waarmee een admin een vacature met behulp van de
     * bijbehorende id op non-actief kan zetten.
     * @param id
     */
    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public void activate(@PathParam("id") int id) { vacatureDAO.activate(id); }


    @GET
    @Path("/match/{id}")
    @RolesAllowed("GEBRUIKER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<Vacature> getVacaturesGebruiker(@PathParam("id") int id) { return vacatureDAO.getVacaturesGebruiker(id); }

}
