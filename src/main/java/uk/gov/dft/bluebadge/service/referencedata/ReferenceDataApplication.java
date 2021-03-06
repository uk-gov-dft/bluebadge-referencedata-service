package uk.gov.dft.bluebadge.service.referencedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"uk.gov.dft.bluebadge"})
public class ReferenceDataApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReferenceDataApplication.class, args);
  }
}
