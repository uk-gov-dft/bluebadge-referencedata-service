package uk.gov.dft.bluebadge.service.referencedata.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import uk.gov.dft.bluebadge.common.logging.LoggingAspect;
import uk.gov.dft.bluebadge.service.referencedata.client.postcodes.PostcodeIOErrorHandler;

@Configuration
public class ApiConfig {

  @Value("${blue-badge.postcodesio.url}")
  private String postcodesIOUrl;

  @Bean
  LoggingAspect getControllerLoggingAspect() {
    return new LoggingAspect();
  }

  @Bean("postcodeIORestTemplate")
  RestTemplate getPostcodeIORestTemplate(ObjectMapper objectMapper) {
    return new RestTemplateBuilder()
        .uriTemplateHandler(new DefaultUriBuilderFactory(postcodesIOUrl))
        .errorHandler(new PostcodeIOErrorHandler(objectMapper))
        .build();
  }
}
