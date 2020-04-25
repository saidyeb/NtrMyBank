package ntr.mybank.gateway.service;

import org.springframework.stereotype.Service;

import spring._5001.soap.mybank.gateway.DebitRequest;

@Service
public interface OperationService {

	boolean debit(DebitRequest debitRequest);
}
