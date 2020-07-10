package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Service;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PatientSummaryHeaderType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PersonIdType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeBodyType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ReferralOutcomeType;
import se.skltp.aggregatingservices.data.TestDataGenerator;

@Log4j2
@Service
public class ServiceTestDataGenerator extends TestDataGenerator {

  @Override
  public String getPatientId(MessageContentsList messageContentsList) {
    GetReferralOutcomeType request = (GetReferralOutcomeType) messageContentsList.get(1);
    return request.getPatientId().getId();
  }

  @Override
  public Object createResponse(Object... responseItems) {
    log.info("Creating a response with {} items", responseItems.length);
    GetReferralOutcomeResponseType response = new GetReferralOutcomeResponseType();
    for (int i = 0; i < responseItems.length; i++) {
      response.getReferralOutcome().add((ReferralOutcomeType) responseItems[i]);
    }
    log.info("response.toString:" + response.toString());

    return response;
  }

  @Override
  public Object createResponseItem(String logicalAddress, String registeredResidentId,
      String businessObjectId, String time) {
    log.debug(
        "Created ResponseItem for logical-address {}, registeredResidentId {} and businessObjectId {}",
        new Object[]{logicalAddress, registeredResidentId, businessObjectId});

    ReferralOutcomeType response = new ReferralOutcomeType();
    response.setReferralOutcomeBody(new ReferralOutcomeBodyType());
    response.setReferralOutcomeHeader(new PatientSummaryHeaderType());
    response.getReferralOutcomeHeader().setPatientId(new PersonIdType());
    response.getReferralOutcomeHeader().getPatientId().setId(registeredResidentId);
    return response;
  }

  public Object createRequest(String patientId, String sourceSystemHSAId) {
    GetReferralOutcomeType request = new GetReferralOutcomeType();
    PersonIdType person = new PersonIdType();
    person.setId(patientId);
    request.setPatientId(person);
    request.setSourceSystemHSAId(sourceSystemHSAId);
    return request;
  }
}
