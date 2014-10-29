package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome.integrationtest;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soitoolkit.commons.mule.util.ThreadSafeSimpleDateFormat;

import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ReferralOutcomeTypeCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.v3.HealthcareProfessionalType;
import riv.clinicalprocess.healthcond.actoutcome.v3.OrgUnitType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PatientSummaryHeaderType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PersonIdType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeBodyType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ResultType;
import se.skltp.agp.test.producer.TestProducerDb;

public class GetAggregatedReferralOutcomeTestProducerDb extends TestProducerDb {

	private static final Logger log = LoggerFactory.getLogger(GetAggregatedReferralOutcomeTestProducerDb.class);
	private static final ThreadSafeSimpleDateFormat df = new ThreadSafeSimpleDateFormat("yyyyMMddhhmmss");

	@Override
	public Object createResponse(Object... responseItems) {
		log.debug("Creates a response with {} items", responseItems);
		final GetReferralOutcomeResponseType response = new GetReferralOutcomeResponseType();
		for (int i = 0; i < responseItems.length; i++) {
			response.getReferralOutcome().add((ReferralOutcomeType) responseItems[i]);
			response.setResult(resultType());
		}
		return response;
	}

	@Override
	public Object createResponseItem(String logicalAddress, String registeredResidentId, String businessObjectId, String time) {
		if (log.isDebugEnabled()) {
			log.debug("Created one response item for logical-address {}, registeredResidentId {} and businessObjectId {}",
				new Object[] {logicalAddress, registeredResidentId, businessObjectId});
		}
		
		final ReferralOutcomeType ref = new ReferralOutcomeType();
		
		final PatientSummaryHeaderType header = new PatientSummaryHeaderType();
		header.setDocumentId(UUID.randomUUID().toString());
		header.setSourceSystemHSAId(logicalAddress);
		header.setDocumentTime(df.format(new Date()));
		
		final PersonIdType pp = new PersonIdType();
		pp.setId(registeredResidentId);
		pp.setType("1.2.752.129.2.1.3.1");
		header.setPatientId(pp);
		
		header.setAccountableHealthcareProfessional(hp(logicalAddress));
		
		ref.setReferralOutcomeHeader(header);
		ref.setReferralOutcomeBody(body(logicalAddress));
		
		
		return ref;
	}
	
	protected HealthcareProfessionalType hp(final String logicalAddress) {
		final HealthcareProfessionalType hp = new HealthcareProfessionalType();
		hp.setAuthorTime(df.format(new Date()));
		hp.setHealthcareProfessionalCareGiverHSAId(logicalAddress);
		
		final OrgUnitType ou = new OrgUnitType();
		ou.setOrgUnitAddress("Address");
		ou.setOrgUnitEmail("email@email.com");
		ou.setOrgUnitHSAId(logicalAddress);
		ou.setOrgUnitLocation("Location");
		ou.setOrgUnitName("Sjukhuset");
		ou.setOrgUnitTelecom("00-00000000");
		hp.setHealthcareProfessionalOrgUnit(ou);
		
		return hp;
	}
	
	protected ReferralOutcomeBodyType body(final String logicalAddress) {
		final ReferralOutcomeBodyType type = new ReferralOutcomeBodyType();
		final ReferralType referralType = new ReferralType();
		referralType.setReferralId("ReferralId");
		referralType.setReferralReason("ReferralReason");
		referralType.setReferralAuthor(hp(logicalAddress));
		referralType.setReferralTime(df.format(new Date()));
		type.setReferral(referralType);
		type.setReferralOutcomeText("OutcomeText");
		type.setReferralOutcomeTitle("ReferalOutcomeTitle");
		type.setReferralOutcomeTypeCode(ReferralOutcomeTypeCodeEnum.SR);
		return type;
	}
	
	protected ResultType resultType() {
		final ResultType type = new ResultType();
		type.setResultCode(ResultCodeEnum.OK);
		type.setMessage("Test message");
		type.setLogId("Test log id");
		return type;
	}
}
