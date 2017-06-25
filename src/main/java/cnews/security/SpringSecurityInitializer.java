package cnews.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class is instantiated to create springSecurityFilterChain bean
 * for proper work of Spring security in integration tests
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
