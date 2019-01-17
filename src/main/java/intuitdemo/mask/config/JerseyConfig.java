package intuitdemo.mask.config;

import intuitdemo.mask.controllers.AccountController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(AccountController.class);
    }
}
