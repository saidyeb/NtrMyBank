package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntr.mybank.model.Account;
import ntr.mybank.model.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer>{
	CreditCard findByAccount(Account account);
	CreditCard findByNumberCredit(int numberCredit);
	boolean existsByNumberCreditAndCVC(int numberCredit, int CVC);
}
