package fastcatch.api.resources;

import com.fasterxml.jackson.annotation.JsonView;
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


    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/gebruiker/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertExpertiseGebruiker(@PathParam("id") int id, Expertise expertise) {
        expertiseDAO.insertExpertiseGebruiker(expertise.getExpertiseType(), id );
    }
    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/vacature/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertExpertiseVacature(@PathParam("id") int id, Expertise expertise) {
        expertiseDAO.insertExpertiseVacature(expertise.getExpertiseType(), id );
    }

}
