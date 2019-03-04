package uk.gov.dft.bluebadge.service.referencedata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.dft.bluebadge.common.logging.LoggingAspect;

@Configuration
public class ApiConfig {

  @Bean
  LoggingAspect getControllerLoggingAspect() {
    return new LoggingAspect();
  }
}
