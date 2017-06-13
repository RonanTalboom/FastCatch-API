package fastcatch.api.resources;

import fastcatch.api.core.Profiel;
import fastcatch.api.db.ProfielDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Anna on 12-6-2017.
 */
@Path("/profiel")
@Produces(MediaType.APPLICATION_JSON)
public class ProfielResource {
    private final ProfielDAO profielDAO;

    public ProfielResource(ProfielDAO dao) {
        this.profielDAO = dao;
    }

    @GET
    public Collection<Profiel> getProfielen() {
        return profielDAO.getProfielen();
    }

    @GET
    @Path("/{emailAdres}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Profiel getProfiel(@PathParam("emailAdres") String emailAdres) {
        return profielDAO.getProfiel(emailAdres);
    }

    @PUT
    @Path("/{profiel}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void wijzigWachtwoord(Profiel profiel) {
        profielDAO.wijzigWachtwoord(profiel.getWachtwoord(), profiel.getEmailAdres());
    }
}
