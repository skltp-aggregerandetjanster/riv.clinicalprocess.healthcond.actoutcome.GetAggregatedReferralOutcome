package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome.integrationtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;

import se.skltp.agp.test.producer.TestProducerDb;

public class GetAggregatedReferralOutcomeTestProducerDb extends TestProducerDb {

	private static final Logger log = LoggerFactory.getLogger(GetAggregatedReferralOutcomeTestProducerDb.class);

	@Override
	public Object createResponse(Object... responseItems) {
		log.debug("Creates a response with {} items", responseItems);
		GetReferralOutcomeResponseType response = new GetReferralOutcomeResponseType();
		for (int i = 0; i < responseItems.length; i++) {

            // TODO: CHANGE GENERATED SAMPLE CODE - START
            if (1==1) throw new UnsupportedOperationException("Not yet implemented");
            /*

			response.getRequestActivity().add((RequestActivityType)responseItems[i]);

            */
            // TODO: CHANGE GENERATED SAMPLE CODE - END

		}
		return response;
	}

	@Override
	public Object createResponseItem(String logicalAddress, String registeredResidentId, String businessObjectId, String time) {

		if (log.isDebugEnabled()) {
			log.debug("Created one response item for logical-address {}, registeredResidentId {} and businessObjectId {}",
				new Object[] {logicalAddress, registeredResidentId, businessObjectId});
		}


        // TODO: CHANGE GENERATED SAMPLE CODE - START
        if (1==1) throw new UnsupportedOperationException("Not yet implemented");
        /*

		RequestActivityType response = new RequestActivityType();

		response.setCareUnit(logicalAddress);
		response.setSubjectOfCareId(registeredResidentId);
		response.setSenderRequestId(businessObjectId);

		return response;

        */
        return null;
        // TODO: CHANGE GENERATED SAMPLE CODE - END

	}
}
