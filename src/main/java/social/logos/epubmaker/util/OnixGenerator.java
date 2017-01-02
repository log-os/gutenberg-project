/**
 * 
 */
package social.logos.epubmaker.util;

import onix.social.logos.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author naresh
 *
 */
public class OnixGenerator {
	/*public static void main(String a[]) {
		
		OnixGenerator og = new OnixGenerator();
		String isbn = "52523523523525";
		ONIXMessage om = new ONIXMessage();
		List<Product> products = new ArrayList<Product>();
		Product product = og.buildProduct(isbn);
		products.add(product);
		Header header = og.buildHeader();
		om.setHeader(header);
		om.setProduct(products);
		
		 * try { JAXBContext contextObj =
		 * JAXBContext.newInstance(ONIXMessage.class);
		 * 
		 * Marshaller marshallerObj = contextObj.createMarshaller();
		 * marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * 
		 * 
		 * marshallerObj.marshal(om, new FileOutputStream("onix.xml")); } catch
		 * (FileNotFoundException | JAXBException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 
		jaxbObjectToXML(om);
	}*/
	
	public String generateOnix(int gutenbergId,String isbn,String title,String subTitle,String author,String description,List<String> subjects,String onixPath){
		ONIXMessage om = new ONIXMessage();
		om.setRelease("3.0");
		List<Product> products = new ArrayList<Product>();
		Product product = this.buildProduct(isbn,title,subTitle,author,description,subjects);
		products.add(product);
		Header header = buildHeader(BigInteger.valueOf(gutenbergId));
		om.setHeader(header);
		om.setProduct(products);
		jaxbObjectToXML(om,onixPath);
		return isbn;
	}
	


	public Header buildHeader(BigInteger gutenbergId) {
		Header header = new Header();
		Sender sender = new Sender();
		SenderName senderName = new SenderName();
		senderName.setValue("gutenberg");
		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setValue("onix@logos.social");
		SentDateTime sentDateTime = new SentDateTime();
		sentDateTime.setValue("20161221T1127");
		sender.getContent().add(senderName);
		sender.getContent().add(emailAddress);
		header.setSender(sender);
		MessageNumber messageNumber = new MessageNumber();
		messageNumber.setValue(gutenbergId);
		header.setMessageNumber(messageNumber);
		header.setSentDateTime(sentDateTime);
		return header;

	}

	public Product buildProduct(String isbn, String title, String subTitle,String author, String description,List<String> subjects) {
		Product product = new Product();
		
		RecordReference recordRef = new RecordReference();
		recordRef.setValue(isbn);
		product.setRecordReference(recordRef);
		NotificationType nt = new NotificationType();
		nt.setValue("03");
		product.setNotificationType(nt);
		ProductIdentifier pid = this.buildProductIdentifier(isbn);
		product.getProductIdentifier().add(pid);
		DescriptiveDetail descriptiveDetail=this.buildDescriptiveDetail(title,subTitle,author,subjects);
		product.setDescriptiveDetail(descriptiveDetail);
		
		// CollateralDetail
		CollateralDetail collateralDetail=buildCollateralDetail(description);
		product.setCollateralDetail(collateralDetail);
		// PublishingDetail
		PublishingDetail publishingDetail = buildPublishingDetail();
		product.setPublishingDetail(publishingDetail);
		// ProductSupply
		ProductSupply productSupply = buildProductSupply();
		product.getProductSupply().add(productSupply);
	
		return product;

	}

	public ProductIdentifier buildProductIdentifier(String isbn) {
		ProductIdentifier id = new ProductIdentifier();
		ProductIDType idType = new ProductIDType();
		idType.setValue("01");
		IDValue idv = new IDValue();
		idv.setValue(isbn);
		id.setIDValue(idv);
		id.setProductIDType(idType);
		return id;

	}

	public DescriptiveDetail buildDescriptiveDetail(String title, String subTitle,String author,List<String> subjects) {
		DescriptiveDetail descriptiveDetail = new DescriptiveDetail();
		TitleDetail titleDetail = new TitleDetail();
		TitleType titleType = new TitleType();
		titleType.setValue("01");

		TitleElement titleElement = new TitleElement();
		TitleElementLevel titleElementLevel = new TitleElementLevel();
		titleElementLevel.setValue("01");

		TitleText titleText = new TitleText();
		titleText.setValue(title);
		Subtitle subtitle = new Subtitle();
		subtitle.setValue(subTitle);

		titleElement.getContent().add(titleElementLevel);
		titleElement.getContent().add(titleText);
		if(subtitle!=null){
		titleElement.getContent().add(subtitle);
		}

		titleDetail.getTitleElement().add(titleElement);
		titleDetail.setTitleType(titleType);
		descriptiveDetail.getTitleDetail().add(titleDetail);
		
		
		//Contributor
		Contributor contributor = getContributor(author);
		descriptiveDetail.getContributor().add(contributor);
				

		// Subjects
		for(String keyword:subjects){
		Subject subject = getSubject(keyword);
		descriptiveDetail.getSubject().add(subject);
		}
		return descriptiveDetail;

	}
	
	public Contributor getContributor(String author){
		Contributor contributor = new Contributor();
		if(author==null){
			return contributor;
		}
		SequenceNumber sequenceNumber = new SequenceNumber();
		sequenceNumber.setValue(BigInteger.valueOf(1));
		contributor.getContent().add(sequenceNumber);
		ContributorRole contributorRole = new ContributorRole();
		contributorRole.setValue(List17.A_01);
		contributor.getContent().add(contributorRole);
		PersonName personName = new PersonName();
		personName.setValue(author);
		contributor.getContent().add(personName);
		return contributor;
	}
	
	public static Subject getSubject(String category){
		SubjectSchemeIdentifier ssid = new SubjectSchemeIdentifier();
		ssid.setValue("20");
		SubjectHeadingText sht = new SubjectHeadingText();
		sht.setValue(category);
		Subject subject = new Subject();
		subject.getContent().add(ssid);
		subject.getContent().add(sht);
		return subject;
	}

	public CollateralDetail buildCollateralDetail(String description) {
		CollateralDetail cd = new CollateralDetail();
		TextContent tc = new TextContent();
		TextType textType = new TextType();
		textType.setValue("03");
		ContentAudience contentAudience = new ContentAudience();
		contentAudience.setValue("00");
		Text text = new Text();
		text.getContent().add(description);
		tc.setTextType(textType);
		tc.getContentAudience().add(contentAudience);
		tc.getText().add(text);
		cd.getTextContent().add(tc);
		return cd;

	}

	public PublishingDetail buildPublishingDetail() {
		PublishingDetail publishingDetail = new PublishingDetail();
		Publisher publisher = new Publisher();
		PublishingRole publishingRole = new PublishingRole();

		PublisherIdentifier publisherIdentifier = new PublisherIdentifier();
		PublisherIDType publisherIDType = new PublisherIDType();
		publisherIDType.setValue("05");
		IDValue idValue = new IDValue();
		idValue.setValue("9876543");
		publisherIdentifier.setPublisherIDType(publisherIDType);
		publisherIdentifier.setIDValue(idValue);
		PublisherName publisherName = new PublisherName();
		publisherName.setValue("LOGOS GmbH");
		publisher.getContent().add(publishingRole);
		publisher.getContent().add(publisherIdentifier);
		publisher.getContent().add(publisherName);
		publishingDetail.getContent().add(publisher);
		CountryOfPublication countryOfPublication = new CountryOfPublication();
		countryOfPublication.setValue(List91.DE);
		PublishingStatus publishingStatus = new PublishingStatus();
		publishingStatus.setValue("07");
		publishingDetail.getContent().add(countryOfPublication);
		publishingDetail.getContent().add(publishingStatus);
		PublishingDate publishingDate = new PublishingDate();
		PublishingDateRole publishingDateRole = new PublishingDateRole();
		publishingDateRole.setValue("01");
		Date date = new Date();
		date.setDateformat("00");
		date.setValue("20161213");
		publishingDate.setPublishingDateRole(publishingDateRole);
		publishingDate.setDate(date);
		publishingDetail.getContent().add(publishingDate);
		return publishingDetail;
	}

	public RelatedMaterial buildRelatedMaterial() {
		return null;
	}

	public ProductSupply buildProductSupply() {
		ProductSupply productSupply = new ProductSupply();
		SupplyDetail supplyDetail = new SupplyDetail();
		Supplier supplier = new Supplier();
		SupplierRole supplierRole = new SupplierRole();
		supplierRole.setValue("00");
		SupplierIdentifier supplierIdentifier = new SupplierIdentifier();
		SupplierIDType supplierIDType = new SupplierIDType();
		supplierIDType.setValue("04");
		IDValue supplierIDValue = new IDValue();
		supplierIDValue.setValue("98765");
		supplierIdentifier.setSupplierIDType(supplierIDType);
		supplierIdentifier.setIDValue(supplierIDValue);
		supplier.getContent().add(supplierRole);
		supplier.getContent().add(supplierIdentifier);
		supplyDetail.setSupplier(supplier);
		ProductAvailability productAvailability = new ProductAvailability();
		productAvailability.setValue("20");
		supplyDetail.setProductAvailability(productAvailability);
		
		SupplyDate supplyDate = new SupplyDate();
		SupplyDateRole supplyDateRole = new SupplyDateRole();
		supplyDateRole.setValue("08");
		Date date = new Date();
		date.setValue("20161213");
		supplyDetail.getSupplyDate().add(supplyDate);
		
		Price priceIN = getPrice(List96.EUR,List91.IN,0);
		Price priceUS = getPrice(List96.EUR,List91.US,0);
		Price priceDE = getPrice(List96.EUR,List91.DE,0);
		supplyDetail.getPrice().add(priceIN);
		supplyDetail.getPrice().add(priceUS);
		supplyDetail.getPrice().add(priceDE);
		productSupply.getSupplyDetail().add(supplyDetail);
		return productSupply;
	}
	
	public static Price getPrice(List96 currency, List91 country, float price  ){
		Price price1 = new Price();
		PriceType priceType1 = new PriceType();
		priceType1.setValue("04");
		PriceAmount priceAmount1 = new PriceAmount();
		priceAmount1.setValue(new BigDecimal(0));
		CurrencyCode currencyCode1 = new CurrencyCode();
		currencyCode1.setValue(currency);
		Territory territory1 = new Territory();
		CountriesIncluded countriesIncluded1 = new CountriesIncluded();
		countriesIncluded1.getValue().add(country);
		territory1.getContent().add(countriesIncluded1);
		price1.setPriceType(priceType1);
		price1.setPriceAmount(priceAmount1);
		price1.setCurrencyCode(currencyCode1);
		price1.setTerritory(territory1);
		return price1;
	}

	private static void jaxbObjectToXML(ONIXMessage emp,String onixPath) {

		try {
			JAXBContext context = JAXBContext.newInstance(ONIXMessage.class);
			Marshaller m = context.createMarshaller();
			// for pretty-print XML in JAXB
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write to System.out for debugging
			// m.marshal(emp, System.out);

			// Write to File
			m.marshal(emp, new File(onixPath));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
