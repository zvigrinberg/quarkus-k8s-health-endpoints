import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.*;

@Readiness
@ApplicationScoped
public class CustomizedHealthCheckReadiness implements HealthCheck {
    //Mock external database response
    @ConfigProperty(name = "database.up", defaultValue = "false")
    private boolean databaseIsUp;

    @Override
  public HealthCheckResponse call() {
      HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Customized Readiness Probe for checking external Dependencies like Database connection health check");

      if (externalDatabaseisAlive())
      {
          return responseBuilder.up().withData("status","Database connection is healthy and stable").build();
      }
      else
      {
          return responseBuilder
                .down()
                .withData("status","Database connection is down, service not ready to accept traffic")
                .withData("type","Readiness")
                .build();
      }

     }

    private boolean externalDatabaseisAlive() {
        //here comes logic to interact with database
        return this.databaseIsUp;

    }
}

