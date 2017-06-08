package fastcatch.api.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fastcatch.api.db.UserDAO;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON) 
public class UserResource {
    private final UserDAO userDAO;

    public UserResource(UserDAO dao) {
    this.userDAO = dao;
    }

    @GET
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getUserByEmail(@PathParam("email") int email) {
        return userDAO.findNameById(email);
    }
}
