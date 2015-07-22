package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome

import se.skltp.agp.testnonfunctional.TP03LoadAbstract

/**
 * Load test VP:GetAggregatedReferralOutcome.
 */
class TP03Load extends TP03LoadAbstract with CommonParameters {
 // override skltp-box with qa
  if (baseUrl.startsWith("http://33.33.33.33")) {
      baseUrl = "http://ine-sit-app03.sth.basefarm.net:9014/GetAggregatedReferralOutcome/service/v3"
//    baseUrl = "http://ine-dit-app02.sth.basefarm.net:9014/GetAggregatedReferralOutcome/service/v3"
  }
  setUp(setUpAbstract(serviceName, urn, responseElement, responseItem, baseUrl))
}