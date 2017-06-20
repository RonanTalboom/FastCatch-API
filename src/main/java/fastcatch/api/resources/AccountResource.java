package fastcatch.api.resources;

/**
 * Created by ronantalboom on 20/06/2017.
 */

import fastcatch.api.core.Account;
import fastcatch.api.db.AccountDAO;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Qpasa on 13-6-2017.
 */

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    private AccountDAO accountDAO;
    public AccountResource(AccountDAO dao) { this.accountDAO = dao; }

    @GET
    @RolesAllowed("GEBRUIKER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Account getAccount(@Auth Account account) { return accountDAO.getAccount(account.getEmail(),account.getWachtwoord()); }
}
