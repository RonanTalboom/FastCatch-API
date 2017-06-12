package fastcatch.api.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fastcatch.api.db.UserDAO;
import fastcatch.api.core.User;
//Dit is een voorbeeld.
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDAO userDAO;

    public UserResource(UserDAO dao) {
    this.userDAO = dao;
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUserByEmail(@PathParam("id") int id) {
        return userDAO.findNameById(id);
    }
}
