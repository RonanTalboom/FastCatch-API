package fastcatch.api.resources;

import fastcatch.api.core.Gebruiker;
import fastcatch.api.db.GebruikerDAO;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Anna on 12-6-2017.
 */
@Path("/gebruiker")
@Produces(MediaType.APPLICATION_JSON)
public class GebruikerResource {
    private final GebruikerDAO gebruikerDAO;

    public GebruikerResource(GebruikerDAO dao) { this.gebruikerDAO = dao; }

    @GET
    public Collection<Gebruiker> getProfielen() { return gebruikerDAO.getProfielen(); }

    @GET
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public Gebruiker getProfiel(@PathParam("id") int id) { return gebruikerDAO.getProfiel(id); }

//    @PUT
//    @Path("/{profiel}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void wijzigWachtwoord(Gebruiker gebruiker) { gebruikerDAO.wijzigWachtwoord(gebruiker.getWachtwoord(), gebruiker.getEmailAdres());}
}
