import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Startup;

@Startup
@ApplicationScoped

  public class CustomizedHealthCheckStartup implements HealthCheck {
      @Override
      public HealthCheckResponse call() {
          performLogicToBeCalledOnlyOnStartupOnce();
          return HealthCheckResponse.named("Customized health check for Startup probe")
                .up()
                .withData("Type","Startup")
                  .withData("Status", "Application Started up successfully!")
                  .build();
        }

    private void performLogicToBeCalledOnlyOnStartupOnce() {
    }
}

