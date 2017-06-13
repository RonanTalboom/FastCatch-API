package fastcatch.api.resources;

import fastcatch.api.core.Branche;
import fastcatch.api.db.BrancheDAO;
import fastcatch.api.db.ExpertiseDAO;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

        }
