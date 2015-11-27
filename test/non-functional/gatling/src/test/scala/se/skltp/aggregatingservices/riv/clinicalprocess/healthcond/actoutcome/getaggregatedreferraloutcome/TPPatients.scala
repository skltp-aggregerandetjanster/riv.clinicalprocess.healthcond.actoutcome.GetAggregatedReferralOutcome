package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome

import se.skltp.agp.testnonfunctional.TPPatientsAbstract

/**
 * Test VP:GetAggregatedReferralOutcome over 12 hours
 */
class TPPatients extends TPPatientsAbstract with CommonParameters {
  setUp(setUpAbstract(serviceName, urn, responseElement, responseItem, baseUrl))
}
