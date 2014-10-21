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

	private static final Logger log = LoggerFactory.getLogger(GetAggregatedReferralOutcomeTestProducer.class);

	private TestProducerDb testDb;
	public void setTestDb(TestProducerDb testDb) {
		this.testDb = testDb;
	}

	public GetReferralOutcomeResponseType getReferralOutcome(String logicalAddress, GetReferralOutcomeType request) {
		GetReferralOutcomeResponseType response = null;


        // TODO: CHANGE GENERATED SAMPLE CODE - START
        if (1==1) throw new UnsupportedOperationException("Not yet implemented");
        /*

		log.info("### Virtual service for GetReferralOutcome call the source system with logical address: {} and patientId: {}", logicalAddress, request.getSubjectOfCareId());

		response = (GetReferralOutcomeResponseType)testDb.processRequest(logicalAddress, request.getSubjectOfCareId());
        if (response == null) {
        	// Return an empty response object instead of null if nothing is found
        	response = new GetReferralOutcomeResponseType();
        }

		log.info("### Virtual service got {} booknings in the reply from the source system with logical address: {} and patientId: {}", new Object[] {response.getRequestActivity().size(), logicalAddress, request.getSubjectOfCareId()});

        */
        // TODO: CHANGE GENERATED SAMPLE CODE - END


		// We are done
        return response;
	}
}
