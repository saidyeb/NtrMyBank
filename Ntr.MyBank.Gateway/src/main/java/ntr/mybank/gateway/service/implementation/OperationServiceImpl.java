package ntr.mybank.gateway.service.implementation;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import ntr.mybank.gateway.service.OperationService;
import spring._5001.soap.mybank.gateway.CreditCard;
import spring._5001.soap.mybank.gateway.DebitRequest;

public class OperationServiceImpl implements OperationService {

	private String _baseUrlMyBank = "http://localhost:5000/rest/mybankapicontroller"; 
	
	@Override
	public boolean debit(DebitRequest debitRequest) 
	{
		boolean status = false;
		
		try
		{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(_baseUrlMyBank+"/savedebit?amount="+debitRequest.getAmount());
	        postRequest.addHeader("content-type", "application/xml");
	        
	        //convert creditcard 
	        StringWriter writer = new StringWriter();
	        JAXBContext jaxbContext = JAXBContext.newInstance(CreditCard.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.marshal(debitRequest.getCreditCard(), writer);
	        // set body post creditcard
	        StringEntity creditCardEntity = new StringEntity(writer.getBuffer().toString());
	        postRequest.setEntity(creditCardEntity);
	        
	        HttpResponse response = httpClient.execute(postRequest);
	        
	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode == 200) 
	        {
	        	status = true; 
	        }
		}
		catch(Exception ex)
		{
		}
		
		return status;
	}

}
