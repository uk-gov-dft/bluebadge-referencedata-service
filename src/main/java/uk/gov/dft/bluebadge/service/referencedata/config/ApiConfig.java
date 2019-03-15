package uk.gov.dft.bluebadge.service.referencedata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import uk.gov.dft.bluebadge.common.logging.LoggingAspect;

@Configuration
public class ApiConfig {

  @Value("${blue-badge.postcodesio.url}")
  private String postcodesIOUrl;

  @Bean
  LoggingAspect getControllerLoggingAspect() {
    return new LoggingAspect();
  }

  @Bean("postcodeIORestTemplate")
  RestTemplate getPostcodeIORestTemplate(){
    return new RestTemplateBuilder()
        .uriTemplateHandler(new DefaultUriBuilderFactory(postcodesIOUrl))
        .build();
  }
}
