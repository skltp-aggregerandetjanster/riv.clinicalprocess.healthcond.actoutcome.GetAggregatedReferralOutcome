package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ResultType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;


@Log4j2
public class GAREOAgpServiceFactoryImpl extends
    AgServiceFactoryBase<GetReferralOutcomeType, GetReferralOutcomeResponseType> {

  @Override
  public String getPatientId(GetReferralOutcomeType queryObject) {
    return queryObject.getPatientId().getId();
  }

  @Override
  public String getSourceSystemHsaId(GetReferralOutcomeType queryObject) {
    return queryObject.getSourceSystemHSAId();
  }

  @Override
  public GetReferralOutcomeResponseType aggregateResponse(
      List<GetReferralOutcomeResponseType> aggregatedResponseList) {
    GetReferralOutcomeResponseType aggregatedResponse = new GetReferralOutcomeResponseType();

    for (GetReferralOutcomeResponseType response : aggregatedResponseList) {
      aggregatedResponse.getReferralOutcome().addAll(response.getReferralOutcome());
    }
    aggregatedResponse.setResult(new ResultType());
    aggregatedResponse.getResult().setResultCode(ResultCodeEnum.INFO);
    aggregatedResponse.getResult().setLogId("NA");

    return aggregatedResponse;
  }
}

