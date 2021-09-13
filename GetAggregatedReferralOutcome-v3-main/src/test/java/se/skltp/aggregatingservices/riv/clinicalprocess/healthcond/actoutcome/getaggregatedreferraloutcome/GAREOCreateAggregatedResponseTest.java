package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateAggregatedResponseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GAREOCreateAggregatedResponseTest extends CreateAggregatedResponseTest {

  private static GAREOAgpServiceConfiguration configuration = new GAREOAgpServiceConfiguration();
  private static AgpServiceFactory<GetReferralOutcomeResponseType> agpServiceFactory = new GAREOAgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();

  public GAREOCreateAggregatedResponseTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

  @Override
  public int getResponseSize(Object response) {
    GetReferralOutcomeResponseType responseType = (GetReferralOutcomeResponseType) response;
    return responseType.getReferralOutcome().size();
  }
}