package fastcatch.api.resources;

import fastcatch.api.core.Branche;
import fastcatch.api.db.BrancheDAO;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by ronantalboom on 13/06/2017.
 */
@Path("/branche")
@Produces(MediaType.APPLICATION_JSON)
public class BrancheResource {

    private final BrancheDAO brancheDAO;

    public BrancheResource(BrancheDAO dao) { this.brancheDAO = dao; }

    @GET
    @RolesAllowed("GEBRUIKER")
    public Collection<Branche> getBranches() { return brancheDAO.getBranches(); }

    @GET
    @RolesAllowed("GEBRUIKER")
    @Path("/gebruiker/{id}")
    public Collection<Branche> getGebruikerBranches(@PathParam("id") int id) {
        return brancheDAO.getGebruikerBranches(id);
    }

    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/delete/gebruiker/{id}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteExpertiseGebruiker(@PathParam("id") int id, Collection<Branche> branches) {
        for (Branche branche : branches) {
            brancheDAO.deleteGebruikerBranche(branche, id);
        }
        ;
    }

    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/gebruiker/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertBrancheGebruiker(@PathParam("id") int id, Collection<Branche> branches) {
        Collection<Branche> brancheCollection = brancheDAO.getGebruikerBranches(id);

        for (Branche branche : branches) {
            if (!brancheCollection.contains(branche))
                brancheDAO.insertBrancheGebruiker(branche, id);
        }
    }
}
