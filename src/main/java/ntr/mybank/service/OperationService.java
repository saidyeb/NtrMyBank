package ntr.mybank.service;

import java.util.Date;
import java.util.List;

import ntr.mybank.model.Account;
import ntr.mybank.model.Operation;
import ntr.mybank.utilities.Operation_Type;

public interface OperationService {
	List<Operation> getOperations(Account account) throws Exception;
	List<Operation> getOperationsByDateCreated(Account account, Date dateCreated) throws Exception;
	Operation save(Operation operation) throws Exception;
	Operation save(Account account, int amount, Operation_Type type) throws Exception;
}
