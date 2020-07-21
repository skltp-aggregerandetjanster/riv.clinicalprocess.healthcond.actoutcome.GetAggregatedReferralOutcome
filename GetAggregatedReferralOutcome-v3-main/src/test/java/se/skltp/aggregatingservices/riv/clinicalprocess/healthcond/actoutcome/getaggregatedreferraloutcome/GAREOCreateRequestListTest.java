package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateRequestListTest;


@RunWith(SpringJUnit4ClassRunner.class)
public class GAREOCreateRequestListTest extends CreateRequestListTest {

  private static GAREOAgpServiceConfiguration configuration = new GAREOAgpServiceConfiguration();
  private static AgpServiceFactory<GetReferralOutcomeResponseType> agpServiceFactory = new GAREOAgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();


  public GAREOCreateRequestListTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }
}