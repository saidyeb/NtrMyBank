package ntr.mybank.service;

import ntr.mybank.model.Account;
import ntr.mybank.model.CreditCard;

public interface CreditCardService {
	CreditCard getCreditCardByAccount(Account account) throws Exception;
	CreditCard getCreditCardByNumberCredit(int number) throws Exception;
	boolean isCardValid(CreditCard creditCard) throws Exception;
}
