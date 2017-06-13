package fastcatch.api.auth;

/**
 * Created by ronantalboom on 12/06/2017.
 */


import fastcatch.api.core.Account;
import fastcatch.api.core.Gebruiker;
import fastcatch.api.db.AccountDAO;
import fastcatch.api.db.GebruikerDAO;
import fastcatch.api.db.UserDAO;
import io.dropwizard.auth.Authorizer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class FastCatchAuthorizer implements Authorizer<Account> {

    private final GebruikerDAO gebruikerDAO;
    @Inject
    public FastCatchAuthorizer(GebruikerDAO gbDAO){
        this.gebruikerDAO = gbDAO;
    }
    @Override
    public boolean authorize(Account account, String roleName) {

        System.out.println(account.getId());
        Gebruiker gebruiker = gebruikerDAO.getProfiel(account.getId());

        ArrayList<String> roles = new ArrayList<String>();

        if(gebruiker.getSoortGebruiker().equals("ADMIN")){
            //is een beheerder
            roles.add("ADMIN");
            roles.add("GEBRUIKER");

        }else if(gebruiker.getSoortGebruiker().equals("GEBRUIKER")) {
            //is een admin
            roles.add("GEBRUIKER");

        }

        //controleren of de gebruiker de correcte role heeft

        return roles.contains(roleName) ? true : false;
    }
}