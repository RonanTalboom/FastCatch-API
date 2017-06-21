package fastcatch.api.resources;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fastcatch.api.core.User;
import fastcatch.api.db.UserDAO;
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDAO userDAO;

    public UserResource(UserDAO dao) {
    this.userDAO = dao;
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("GEBRUIKER")
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUserByEmail(@PathParam("id") int id) {
        return userDAO.findNameById(id);
    }
}
