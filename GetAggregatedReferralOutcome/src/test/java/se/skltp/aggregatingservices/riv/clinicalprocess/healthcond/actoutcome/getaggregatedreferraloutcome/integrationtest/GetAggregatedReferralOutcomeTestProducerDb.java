package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome.integrationtest;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soitoolkit.commons.mule.util.ThreadSafeSimpleDateFormat;

import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ReferralOutcomeTypeCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.v3.HealthcareProfessionalType;
import riv.clinicalprocess.healthcond.actoutcome.v3.OrgUnitType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PatientSummaryHeaderType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PersonIdType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeBodyType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralType;
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
		header.setAccountableHealthcareProfessional(hp);
		
		ref.setReferralOutcomeHeader(header);
		
		return ref;
	}
	
	protected ReferralOutcomeBodyType body() {
		final ReferralOutcomeBodyType type = new ReferralOutcomeBodyType();
		final ReferralType referralType = new ReferralType();
		referralType.setReferralId("ReferralId");
		referralType.setReferralReason("ReferralReason");
		referralType.setReferralTime(df.format(new Date()));
		type.setReferral(referralType);
		type.setReferralOutcomeText("OutcomeText");
		type.setReferralOutcomeTitle("ReferalOutcomeTitle");
		type.setReferralOutcomeTypeCode(ReferralOutcomeTypeCodeEnum.SR);
		return type;
	}
}
