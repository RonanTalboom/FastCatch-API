package fastcatch.api;

import fastcatch.api.auth.FastCatchAuthenticator;
import fastcatch.api.auth.FastCatchAuthorizer;
import fastcatch.api.auth.FastCatchUnauthorized;
import fastcatch.api.core.Account;
import fastcatch.api.db.AccountDAO;
import fastcatch.api.db.GebruikerDAO;
import fastcatch.api.db.UserDAO;
import fastcatch.api.db.VacatureDAO;
import fastcatch.api.health.TemplateHealthCheck;
import fastcatch.api.resources.GebruikerResource;
import fastcatch.api.resources.UserResource;
import fastcatch.api.resources.VacatureResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

public class FastCatchApplication extends Application<FastCatchConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FastCatchApplication().run(args);
    }

    @Override
    public String getName() {
        return "FastCatch";
    }

    @Override
    public void initialize(final Bootstrap<FastCatchConfiguration> bootstrap) {
        // TODO: application initialization
    }
    @Override
    public void run(final FastCatchConfiguration configuration,
                    final Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi;


        try {
            jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

            setUpResources(environment,jdbi);
            setupAuthentication(environment,jdbi);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);
    }

    private void setupAuthentication(Environment environment, DBI jdbi)
    {

        final AccountDAO accdao = jdbi.onDemand(AccountDAO.class);
        final GebruikerDAO gbdao = jdbi.onDemand(GebruikerDAO.class);

        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<Account>()
                        .setAuthenticator(new FastCatchAuthenticator(accdao))
                        .setAuthorizer(new FastCatchAuthorizer(gbdao))
                        .setRealm("SUPER SECRET STUFF")
                        .setUnauthorizedHandler(new FastCatchUnauthorized())
                        .buildAuthFilter())
        );

        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Account.class));
    }

    public void setUpResources(Environment environment, DBI jdbi){
        final UserDAO udao = jdbi.onDemand(UserDAO.class);
        final GebruikerDAO gdao = jdbi.onDemand(GebruikerDAO.class);
        final VacatureDAO vdao = jdbi.onDemand(VacatureDAO.class);

        environment.jersey().register(new UserResource(udao));
        environment.jersey().register(new GebruikerResource(gdao));
        environment.jersey().register(new VacatureResource(vdao));
    }




}
