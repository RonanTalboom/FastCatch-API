package fastcatch.api;

import fastcatch.api.auth.FastCatchAuthenticator;
import fastcatch.api.auth.FastCatchAuthorizer;
import fastcatch.api.auth.FastCatchUnauthorized;
import fastcatch.api.core.Account;
import fastcatch.api.core.Vacature;
import fastcatch.api.db.*;
import fastcatch.api.health.TemplateHealthCheck;
import fastcatch.api.resources.*;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import java.sql.Date;
import java.util.Calendar;
import java.util.EnumSet;



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
        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin,authorization");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter("Access-Control-Allow-Origin", "*");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        // DO NOT pass a preflight request to down-stream auth filters
        // unauthenticated preflight requests should be permitted by spec
        cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi;


        try {
            jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

            setUpResources(environment, jdbi);
            setupAuthentication(environment, jdbi);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

    private void setupAuthentication(Environment environment, DBI jdbi) {

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

    public void setUpResources(Environment environment, DBI jdbi) {
        final GebruikerDAO gdao = jdbi.onDemand(GebruikerDAO.class);
        final VacatureDAO vdao = jdbi.onDemand(VacatureDAO.class);
        final ExpertiseDAO edao = jdbi.onDemand(ExpertiseDAO.class);
        final BrancheDAO bdao = jdbi.onDemand(BrancheDAO.class);
        final AccountDAO adao = jdbi.onDemand(AccountDAO.class);
        environment.jersey().register(new GebruikerResource(gdao));
        environment.jersey().register(new VacatureResource(vdao));
        environment.jersey().register(new ExpertiseResource(edao));
        environment.jersey().register(new BrancheResource(bdao));
        environment.jersey().register(new AccountResource(adao));
    }


}
