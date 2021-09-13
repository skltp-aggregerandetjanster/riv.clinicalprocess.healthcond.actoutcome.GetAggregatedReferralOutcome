package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GAREOCreateFindContentTest extends CreateFindContentTest {

  private static GAREOAgpServiceConfiguration configuration = new GAREOAgpServiceConfiguration();
  private static AgpServiceFactory<GetReferralOutcomeResponseType> agpServiceFactory = new GAREOAgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();

  public GAREOCreateFindContentTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

}
