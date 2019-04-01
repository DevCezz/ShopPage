package pl.csanecki.AITSI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import pl.csanecki.AITSI.entity.Cart;

@Configuration
public class SessionConfig {
    @Bean
    @Scope(
            value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS
    )
    public Cart cart() {
        return new Cart();
    }
}
