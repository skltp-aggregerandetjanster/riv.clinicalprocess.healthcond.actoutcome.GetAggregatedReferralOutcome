package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome.integrationtest;

import static se.skltp.agp.test.producer.TestProducerDb.TEST_RR_ID_ONE_HIT;

import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcome.v3.rivtabp21.GetReferralOutcomeResponderInterface;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeType;
import se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome.GetAggregatedReferralOutcomeMuleServer;
import se.skltp.agp.test.consumer.AbstractTestConsumer;
import se.skltp.agp.test.consumer.SoapHeaderCxfInterceptor;
import se.skltp.agp.riv.interoperability.headers.v1.ProcessingStatusType;

public class GetAggregatedReferralOutcomeTestConsumer extends AbstractTestConsumer<GetReferralOutcomeResponderInterface> {

	private static final Logger log = LoggerFactory.getLogger(GetAggregatedReferralOutcomeTestConsumer.class);

	public static void main(String[] args) {
		String serviceAddress = GetAggregatedReferralOutcomeMuleServer.getAddress("SERVICE_INBOUND_URL");
		String personnummer = TEST_RR_ID_ONE_HIT;

		GetAggregatedReferralOutcomeTestConsumer consumer = new GetAggregatedReferralOutcomeTestConsumer(serviceAddress, SAMPLE_SENDER_ID, SAMPLE_ORIGINAL_CONSUMER_HSAID);
		Holder<GetReferralOutcomeResponseType> responseHolder = new Holder<GetReferralOutcomeResponseType>();
		Holder<ProcessingStatusType> processingStatusHolder = new Holder<ProcessingStatusType>();

		consumer.callService("logical-adress", personnummer, processingStatusHolder, responseHolder);


        // TODO: CHANGE GENERATED SAMPLE CODE - START
        if (1==1) throw new UnsupportedOperationException("Not yet implemented");
        /*

		log.info("Returned #timeslots = " + responseHolder.value.getRequestActivity().size());

		*/
        // TODO: CHANGE GENERATED SAMPLE CODE - END

	}

	public GetAggregatedReferralOutcomeTestConsumer(String serviceAddress, String senderId, String originalConsumerHsaId) {

		// Setup a web service proxy for communication using HTTPS with Mutual Authentication
		super(GetReferralOutcomeResponderInterface.class, serviceAddress, senderId, originalConsumerHsaId);
	}

	public void callService(String logicalAddress, String registeredResidentId, Holder<ProcessingStatusType> processingStatusHolder, Holder<GetReferralOutcomeResponseType> responseHolder) {

		log.debug("Calling GetReferralOutcome-soap-service with Registered Resident Id = {}", registeredResidentId);

		GetReferralOutcomeType request = new GetReferralOutcomeType();


        // TODO: CHANGE GENERATED SAMPLE CODE - START
        if (1==1) throw new UnsupportedOperationException("Not yet implemented");
        /*

		request.setSubjectOfCareId(registeredResidentId);

        */
        // TODO: CHANGE GENERATED SAMPLE CODE - END

		GetReferralOutcomeResponseType response = _service.getReferralOutcome(logicalAddress, request);
		responseHolder.value = response;

		processingStatusHolder.value = SoapHeaderCxfInterceptor.getLastFoundProcessingStatus();
	}
}
