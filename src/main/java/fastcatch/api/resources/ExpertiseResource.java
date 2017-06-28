package fastcatch.api.resources;

import fastcatch.api.core.Expertise;
import fastcatch.api.db.ExpertiseDAO;

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

    public ExpertiseResource(ExpertiseDAO dao) {
        this.expertiseDAO = dao;
    }

    @GET
    @RolesAllowed("GEBRUIKER")
    public Collection<Expertise> getExpertises() {
        return expertiseDAO.getExpertises();
    }

    @GET
    @RolesAllowed("GEBRUIKER")
    @Path("/gebruiker/{id}")
    public Collection<Expertise> getGebruikerExpertises(@PathParam("id") int id) {
        return expertiseDAO.getGebruikerExpertises(id);
    }

    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/gebruiker/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertExpertiseGebruiker(@PathParam("id") int id, Collection<Expertise> expertises) {
        Collection<Expertise> expertiseCollection = expertiseDAO.getGebruikerExpertises(id);

        for (Expertise expertise : expertises) {
            if (!expertiseCollection.contains(expertise))
                expertiseDAO.insertExpertiseGebruiker(expertise, id);
        }
    }

    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/delete/gebruiker/{id}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteExpertiseGebruiker(@PathParam("id") int id, Collection<Expertise> expertises) {
        for (Expertise e : expertises) {
            expertiseDAO.deleteGebruikerExpertise(e, id);
        }
        ;
    }
    @POST
    @RolesAllowed("GEBRUIKER")
    @Path("/vacature/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertExpertiseVacature(@PathParam("id") int id, Expertise expertise) {

    }

}
