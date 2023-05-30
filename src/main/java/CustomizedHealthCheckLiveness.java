import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped

  public class CustomizedHealthCheckLiveness implements HealthCheck {
      @Override
      public HealthCheckResponse call() {
          return HealthCheckResponse.named("Customized health check for liveness probe")
                .up()
                .withData("Type","Liveness")
                  .withData("Status", "Application is alive and kicking!")
                  .build();
        }
    }

