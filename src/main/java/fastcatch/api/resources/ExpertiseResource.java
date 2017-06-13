package fastcatch.api.resources;

import fastcatch.api.core.Expertise;
import fastcatch.api.core.Gebruiker;
import fastcatch.api.db.ExpertiseDAO;
import fastcatch.api.db.GebruikerDAO;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by ronantalboom on 12-6-2017.
 */
@Path("/expertise")
@Produces(MediaType.APPLICATION_JSON)
public class ExpertiseResource {
    private final ExpertiseDAO expertiseDAO;

    public ExpertiseResource(ExpertiseDAO dao) { this.expertiseDAO = dao; }

    @GET
    @RolesAllowed("GEBRUIKER")
    public Collection<Expertise> getExpertises() { return expertiseDAO.getExpertises(); }

//    @GET
//    @Path("/{id}")
//    @RolesAllowed("ADMIN")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Gebruiker getProfiel(@PathParam("id") int id) { return expertiseDAO.getExpertise(); }

//    @PUT
//    @Path("/{profiel}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void wijzigWachtwoord(Gebruiker gebruiker) { gebruikerDAO.wijzigWachtwoord(gebruiker.getWachtwoord(), gebruiker.getEmailAdres());}
}
