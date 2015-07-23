package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soitoolkit.commons.mule.jaxb.JaxbUtil;

import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.ObjectFactory;
import riv.clinicalprocess.healthcond.actoutcome.v3.ResultType;
import se.skltp.agp.riv.interoperability.headers.v1.ProcessingStatusType;
import se.skltp.agp.service.api.QueryObject;
import se.skltp.agp.service.api.ResponseListFactory;

public class ResponseListFactoryImpl implements ResponseListFactory {

    private static final Logger log = LoggerFactory.getLogger(ResponseListFactoryImpl.class);
    private static final JaxbUtil jaxbUtil = new JaxbUtil(GetReferralOutcomeResponseType.class, ProcessingStatusType.class);
    private static final ObjectFactory OF = new ObjectFactory();

    @Override
    public String getXmlFromAggregatedResponse(QueryObject queryObject, List<Object> aggregatedResponseList) {
        final GetReferralOutcomeResponseType aggregatedResponse = new GetReferralOutcomeResponseType();

        for (Object object : aggregatedResponseList) {
            final GetReferralOutcomeResponseType response = (GetReferralOutcomeResponseType) object;
            aggregatedResponse.getReferralOutcome().addAll(response.getReferralOutcome());
        }

        aggregatedResponse.setResult(new ResultType());
        aggregatedResponse.getResult().setLogId("NA");
        aggregatedResponse.getResult().setResultCode(ResultCodeEnum.INFO);

        String subjectOfCareId = queryObject.getFindContent().getRegisteredResidentIdentification();
        log.info("Returning {} aggregated alert informations for subject of care id {}", aggregatedResponse.getReferralOutcome().size(),
                subjectOfCareId);

        return jaxbUtil.marshal(OF.createGetReferralOutcomeResponse(aggregatedResponse));
    }
}
