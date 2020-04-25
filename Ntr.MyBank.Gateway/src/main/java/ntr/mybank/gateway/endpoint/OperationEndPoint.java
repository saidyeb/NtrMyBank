package ntr.mybank.gateway.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import spring._5001.soap.mybank.gateway.DebitResponse;
import spring._5001.soap.mybank.gateway.DebitRequest;


@Endpoint
public class OperationEndPoint {
	
	private static final String NAMESPACE_URL = "http://spring:5001/soap/myBank/gateway";

	@Autowired
	public OperationEndPoint() {}
	
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "debitRequest")
    @ResponsePayload
    public DebitResponse getCountry(@RequestPayload DebitRequest debitRequest) {
    	DebitResponse debitResponse = new DebitResponse();
        return debitResponse;
    }
    
}
