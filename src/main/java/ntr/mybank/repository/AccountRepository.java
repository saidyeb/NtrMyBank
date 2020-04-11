package ntr.mybank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntr.mybank.model.Account;
import ntr.mybank.model.Bank;
import ntr.mybank.model.Users;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{
	List<Account> findByUser(Users user); 
	List<Account> findByBank(Bank bank);
	List<Account> findByNumberAccount(String numberAccount); 
	List<Account> findByStatus(String status);
}
