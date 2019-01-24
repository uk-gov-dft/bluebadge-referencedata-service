package uk.gov.service.bluebadge.test;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@SuppressWarnings("squid:S2187")
@CucumberOptions(features = "classpath:features")
public class AcceptanceTest {
  // no-op, config class only
}
