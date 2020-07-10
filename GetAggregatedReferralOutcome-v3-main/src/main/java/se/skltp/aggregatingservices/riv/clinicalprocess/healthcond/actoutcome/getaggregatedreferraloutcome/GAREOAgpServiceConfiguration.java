package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcome.v3.rivtabp21.GetReferralOutcomeResponderInterface;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcome.v3.rivtabp21.GetReferralOutcomeResponderService;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "getaggregatedreferraloutcome.v3")
public class GAREOAgpServiceConfiguration extends se.skltp.aggregatingservices.configuration.AgpServiceConfiguration {

public static final String SCHEMA_PATH = "/schemas/clinicalprocess_healthcond_actoutcome/interactions/GetReferralOutcomeInteraction/GetReferralOutcomeInteraction_3.1_RIVTABP21.wsdl";

  public GAREOAgpServiceConfiguration() {

    setServiceName("GetAggregatedReferralOutcome-v3");
    setTargetNamespace("urn:riv:clinicalprocess:healthcond:actoutcome:GetReferralOutcome:3:rivtabp21");

    // Set inbound defaults
    setInboundServiceURL("http://localhost:9014/GetAggregatedReferralOutcome/service/v3");
    setInboundServiceWsdl(SCHEMA_PATH);
    setInboundServiceClass(GetReferralOutcomeResponderInterface.class.getName());
    setInboundPortName(GetReferralOutcomeResponderService.GetReferralOutcomeResponderPort.toString());

    // Set outbound defaults
    setOutboundServiceWsdl(SCHEMA_PATH);
    setOutboundServiceClass(GetReferralOutcomeResponderInterface.class.getName());
    setOutboundPortName(GetReferralOutcomeResponderService.GetReferralOutcomeResponderPort.toString());

    // FindContent
    setEiServiceDomain("riv:clinicalprocess:healthcond:actoutcome");
    setEiCategorization("und-kon-ure");

    // TAK
    setTakContract("urn:riv:clinicalprocess:healthcond:actoutcome:GetReferralOutcomeResponder:3");

    // Set service factory
    setServiceFactoryClass(GAREOAgpServiceFactoryImpl.class.getName());
    }


}
