package ntr.mybank.service;

import java.util.Date;
import java.util.List;

import ntr.mybank.model.Account;
import ntr.mybank.model.Operation;

public interface OperationService {
	List<Operation> getOperations(Account account) throws Exception;
	List<Operation> getOperationsByDateCreated(Account account, Date dateCreated) throws Exception;
}
