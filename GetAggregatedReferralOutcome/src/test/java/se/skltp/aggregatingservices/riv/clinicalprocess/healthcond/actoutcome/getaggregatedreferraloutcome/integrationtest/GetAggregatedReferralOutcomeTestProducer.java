package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome.integrationtest;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcome.v3.rivtabp21.GetReferralOutcomeResponderInterface;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeType;
import se.skltp.agp.test.producer.TestProducerDb;

@WebService(serviceName = "GetReferralOutcomeResponderService", portName = "GetReferralOutcomeResponderPort", targetNamespace = "urn:riv:clinicalprocess:healthcond:actoutcome:GetReferralOutcome:3:rivtabp21", name = "GetReferralOutcomeInteraction")
public class GetAggregatedReferralOutcomeTestProducer implements GetReferralOutcomeResponderInterface {

	protected static final Logger log = LoggerFactory.getLogger(GetAggregatedReferralOutcomeTestProducer.class);

	private TestProducerDb testDb;
	public void setTestDb(TestProducerDb testDb) {
		this.testDb = testDb;
	}

	public GetReferralOutcomeResponseType getReferralOutcome(String logicalAddress, GetReferralOutcomeType request) {
		final Object response = testDb.processRequest(logicalAddress, request.getPatientId().getId());
		if (response == null) {
			return new GetReferralOutcomeResponseType();
		}
        return (GetReferralOutcomeResponseType) response;
	}
}
