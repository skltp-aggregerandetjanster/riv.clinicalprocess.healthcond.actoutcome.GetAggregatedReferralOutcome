package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.getaggregatedreferraloutcome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.GetReferralOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.getreferraloutcomeresponder.v3.ObjectFactory;
import riv.clinicalprocess.healthcond.actoutcome.v3.PersonIdType;
import se.skltp.agp.riv.itintegration.engagementindex.findcontentresponder.v1.FindContentType;
import se.skltp.agp.service.api.QueryObjectFactory;


public class QueryObjectFactoryTest {

	private static final QueryObjectFactoryImpl testObject = new QueryObjectFactoryImpl();
	private static final ObjectFactory objFactory = new ObjectFactory();
	
	private static final String CATEGORIZATION = UUID.randomUUID().toString();
	private static final String SERVICE_DOMAIN = UUID.randomUUID().toString();
	private static final String SUBJECTOFCARE = UUID.randomUUID().toString();
	private static final String SOURCESYSTEMHSAID = UUID.randomUUID().toString();
	
	
	@BeforeClass
	public static void init() {
		testObject.setEiCategorization(CATEGORIZATION);
		testObject.setEiServiceDomain(SERVICE_DOMAIN);
	}
	
	@Test
	public void testQueryObjectFactory() throws Exception {
		final GetReferralOutcomeType type = new GetReferralOutcomeType();
		
		final PersonIdType person = new PersonIdType();
		person.setId(SUBJECTOFCARE);
		type.setPatientId(person);
		type.setSourceSystemHSAId(SOURCESYSTEMHSAID);
		
		final Node node = createNode(type);
		final FindContentType findContent = testObject.createQueryObject(node).getFindContent();

		assertEquals(CATEGORIZATION, findContent.getCategorization());
		assertEquals(SERVICE_DOMAIN, findContent.getServiceDomain());
		assertEquals(SUBJECTOFCARE, findContent.getRegisteredResidentIdentification());
		assertEquals(SOURCESYSTEMHSAID, findContent.getLogicalAddress());
		assertEquals(SOURCESYSTEMHSAID, findContent.getSourceSystem());
		assertNull(findContent.getBusinessObjectInstanceIdentifier());
		assertNull(findContent.getClinicalProcessInterestId());
		assertNull(findContent.getDataController());
		assertNull(findContent.getMostRecentContent());
		assertNull(findContent.getOwner());
	}
	
	private Node createNode(final GetReferralOutcomeType req) throws Exception {
		JAXBElement<GetReferralOutcomeType> jaxb = objFactory.createGetReferralOutcome(req);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document node = db.newDocument();
		
		JAXBContext jc = JAXBContext.newInstance(GetReferralOutcomeType.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.marshal(jaxb, node);
		return node;
	}
}
