package fastcatch.api;

import fastcatch.api.db.UserDAO;
import fastcatch.api.health.TemplateHealthCheck;
import fastcatch.api.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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
            final UserDAO dao = jdbi.onDemand(UserDAO.class);
            dao.createSomethingTable();
            environment.jersey().register(new UserResource(dao));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);
    }
    

}
