package ntr.mybank.service;

import ntr.mybank.model.Account;
import ntr.mybank.model.CreditCard;
import ntr.mybank.model.Operation;

public interface AccountService {
	Operation debit(CreditCard creditCard, int amount) throws Exception;
	Operation debit(Account account, int amount) throws Exception;
	Operation credit(CreditCard creditCard, int amount) throws Exception;
	Operation credit(Account account, int amount) throws Exception;
	Account save(Account account) throws Exception;
}
