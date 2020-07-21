package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcome.v3.rivtabp21.GetReferralOutcomeResponderInterface;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcome.v3.rivtabp21.GetReferralOutcomeResponderService;
import se.skltp.aggregatingservices.config.TestProducerConfiguration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="getaggregatedreferraloutcome.v3.teststub")
public class ServiceConfiguration extends TestProducerConfiguration {

  public static final String SCHEMA_PATH = "/schemas/clinicalprocess_healthcond_actoutcome/interactions/GetReferralOutcomeInteraction/GetReferralOutcomeInteraction_3.1_RIVTABP21.wsdl";

  public ServiceConfiguration() {
    setProducerAddress("http://localhost:8083/vp");
    setServiceClass(GetReferralOutcomeResponderInterface.class.getName());
    setServiceNamespace("urn:riv:clinicalprocess:healthcond:actoutcome:GetReferralOutcomeResponder:3");
    setPortName(GetReferralOutcomeResponderService.GetReferralOutcomeResponderPort.toString());
    setWsdlPath(SCHEMA_PATH);
    setTestDataGeneratorClass(ServiceTestDataGenerator.class.getName());
   	setServiceTimeout(27000);
  }

}
