package uk.gov.dft.bluebadge.service.referencedata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import uk.gov.dft.bluebadge.common.security.Permissions;
import uk.gov.dft.bluebadge.common.security.SecurityUtils;

@Configuration
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private static final String OAUTH_CHECK_TOKEN_URI = "/oauth/check_token";
  public static final String OAUTH_2_HAS_SCOPE_LA_WEB_APP = "#oauth2.hasScope('la-webapp')";
  public static final String AUTHORITIES_PATH = "/reference-data/authorities/**";

  @Value("${blue-badge.auth-server.url}")
  private String authServerUrl;

  @Value("${blue-badge.auth-server.client-id}")
  private String clientId;

  @Value("${blue-badge.auth-server.client-secret}")
  private String clientSecret;

  @Bean
  public RemoteTokenServices tokenService() {
    RemoteTokenServices tokenService = new RemoteTokenServices();
    tokenService.setCheckTokenEndpointUrl(authServerUrl + OAUTH_CHECK_TOKEN_URI);
    tokenService.setClientId(clientId);
    tokenService.setClientSecret(clientSecret);
    return tokenService;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(AUTHORITIES_PATH)
        .fullyAuthenticated()
        .antMatchers(AUTHORITIES_PATH)
        .hasAuthority(Permissions.MANAGE_LOCAL_AUTHORITIES.getPermissionName())
        .antMatchers(AUTHORITIES_PATH)
        .access(OAUTH_2_HAS_SCOPE_LA_WEB_APP)
        .anyRequest()
        .denyAll();
  }

  @Bean
  public SecurityUtils securityUtils() {
    return new SecurityUtils();
  }
}
