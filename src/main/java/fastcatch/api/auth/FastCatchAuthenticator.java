package fastcatch.api.auth;

/**
 * Created by ronantalboom on 12/06/2017.
 */

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import fastcatch.api.core.Account;
import fastcatch.api.db.AccountDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Singleton
public class FastCatchAuthenticator implements Authenticator<BasicCredentials, Account> {
    /**
     * Valid users with mapping user -> roles
     */
    private final AccountDAO accountDAO;

    @Inject
    public FastCatchAuthenticator(AccountDAO accD) {
        this.accountDAO = accD;
    }

    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
            "Gast", ImmutableSet.of(),
            "Ingelogd", ImmutableSet.of("GEBRUIKER"),
            "admin", ImmutableSet.of("ADMIN")
    );

    @Override
    public Optional<Account> authenticate(BasicCredentials credentials) throws AuthenticationException {

        Account account = accountDAO.getAccount(credentials.getUsername(), credentials.getPassword());
        if (account != null) {

            Optional<Account> optional = Optional.of(account);
            return optional;

        }


        return Optional.empty();
    }
}
