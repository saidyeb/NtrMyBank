package ntr.mybank.gateway.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ntr.mybank.gateway.service.OperationService;
import spring._5001.soap.mybank.gateway.DebitResponse;
import spring._5001.soap.mybank.gateway.DebitRequest;


@Endpoint
public class OperationEndPoint {
	
	private static final String NAMESPACE_URL = "http://spring:5001/soap/myBank/gateway";

	private OperationService operationService; 
	
	@Autowired
	public OperationEndPoint(OperationService operationService) {
		this.operationService = operationService;
	}
	
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "debitRequest")
    @ResponsePayload
    public DebitResponse getCountry(@RequestPayload DebitRequest debitRequest) {
    	DebitResponse debitResponse = new DebitResponse();
    	boolean status = this.operationService.debit(debitRequest);
    	debitResponse.setStatus(status);
        return debitResponse;
    }
    
}
