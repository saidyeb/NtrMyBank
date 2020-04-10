package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;

import ntr.mybank.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{
}
