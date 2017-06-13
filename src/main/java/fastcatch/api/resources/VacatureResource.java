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
    @RolesAllowed("GEBRUIKER")
    public Collection<Vacature> getVacatures() { return vacatureDAO.getVacatures(); }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vacature getVacature(@PathParam("id") int id) { return vacatureDAO.getVacature(id); }

    @POST
    @RolesAllowed("ADMIN")
    public void insert(Vacature vacature) {
        vacatureDAO.insert(vacature.getBrancheType(), vacature.getTitel(), vacature.getRol(), vacature.getWerkNiveau(), vacature.getEigenaar(), vacature.getKlant(),
                vacature.getLocatie(), vacature.getStartdatum(), vacature.getEinddatum(), vacature.getPublicatiedatum(),
                vacature.getUitersteAanbiedingsdatum(), vacature.getUurPerWeek(),
                vacature.getAanvrager(), vacature.getOmschrijving(), vacature.getSamenvatting(), vacature.getActief());
    }

    @PUT
    @Path("/{id}/archief")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") int id) { vacatureDAO.delete(id); }

}
