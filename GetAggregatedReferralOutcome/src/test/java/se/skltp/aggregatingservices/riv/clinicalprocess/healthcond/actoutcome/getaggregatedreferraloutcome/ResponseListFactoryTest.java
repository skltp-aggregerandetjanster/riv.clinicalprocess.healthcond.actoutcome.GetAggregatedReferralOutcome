package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.mockito.Mockito;
import org.soitoolkit.commons.mule.jaxb.JaxbUtil;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PatientSummaryHeaderType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PersonIdType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeBodyType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeType;
import se.skltp.agp.riv.itintegration.engagementindex.findcontentresponder.v1.FindContentType;
import se.skltp.agp.service.api.QueryObject;
import se.skltp.agp.service.api.ResponseListFactory;


public class ResponseListFactoryTest {

	private final static String SUBJECT_OF_CARE = UUID.randomUUID().toString();
	private final static int NUMBER_OF_RESPONSES = 5;
	
	private final ResponseListFactoryImpl testObject = new ResponseListFactoryImpl();
	private final List<Object> responseList = new ArrayList<Object>();
	
	private final QueryObject queryObject = Mockito.mock(QueryObject.class);
	private final FindContentType findContentType = Mockito.mock(FindContentType.class);
	
	@Before
	public void setup() {
		Mockito.when(findContentType.getRegisteredResidentIdentification()).thenReturn(SUBJECT_OF_CARE);
		Mockito.when(queryObject.getFindContent()).thenReturn(findContentType);
		
		for(int i = 0; i < NUMBER_OF_RESPONSES; i++) {
			final GetReferralOutcomeResponseType resp = new GetReferralOutcomeResponseType();
			final ReferralOutcomeType ref = new ReferralOutcomeType();
			ref.setReferralOutcomeBody(new ReferralOutcomeBodyType());
			ref.setReferralOutcomeHeader(new PatientSummaryHeaderType());
			ref.getReferralOutcomeHeader().setPatientId(new PersonIdType());
			ref.getReferralOutcomeHeader().getPatientId().setId(SUBJECT_OF_CARE);
			resp.getReferralOutcome().add(ref);
			responseList.add(resp);
		}
	}

	@Test
	public void testGetXmlFromAggregatedResponse() {
		final JaxbUtil jaxbUtil = new JaxbUtil(GetReferralOutcomeResponseType.class);

		final String after = testObject.getXmlFromAggregatedResponse(queryObject, responseList);
		final GetReferralOutcomeResponseType type = (GetReferralOutcomeResponseType) jaxbUtil.unmarshal(after);
		
		assertEquals(NUMBER_OF_RESPONSES, type.getReferralOutcome().size());
		for(ReferralOutcomeType ref : type.getReferralOutcome()) {
			assertEquals(SUBJECT_OF_CARE, ref.getReferralOutcomeHeader().getPatientId().getId());
		}
	}
}
