package ntr.mybank.service;

import ntr.mybank.bo.BoCreditCard;
import ntr.mybank.model.Account;
import ntr.mybank.model.Operation;

public interface AccountService {
	Operation debit(BoCreditCard boCreditCard, int amount) throws Exception;
	Operation debit(Account account, int amount) throws Exception;
	Operation credit(BoCreditCard boCreditCard, int amount) throws Exception;
	Operation credit(Account account, int amount) throws Exception;
	Account save(Account account) throws Exception;
	Account getAccountById(int id) throws Exception;
}
