package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome

trait CommonParameters {
  val serviceName:String     = "ReferralOutcome"
  val urn:String             = "urn:riv:clinicalprocess:healthcond:actoutcome:GetReferralOutcomeResponder:3"
  val responseElement:String = "GetReferralOutcomeResponse"
  val responseItem:String    = "referralOutcome"
  var baseUrl:String         = if (System.getProperty("baseUrl") != null && !System.getProperty("baseUrl").isEmpty()) {
                                   System.getProperty("baseUrl")
                               } else {
                                   "http://33.33.33.33:8081/GetAggregatedReferralOutcome/service/v3"
                               }
}
