package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntr.mybank.model.Account;
import ntr.mybank.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{
	Users findByAccount(Account account);
}
