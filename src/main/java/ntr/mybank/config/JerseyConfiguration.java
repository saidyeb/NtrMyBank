package ntr.mybank.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import ntr.mybank.controller.MyBankApiController;

@Configuration
@ApplicationPath("/rest")
public class JerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void init() {
        register(MyBankApiController.class);
    }
}
