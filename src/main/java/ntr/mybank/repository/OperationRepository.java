package ntr.mybank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntr.mybank.model.Account;
import ntr.mybank.model.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer>{
	List<Operation> findByAccount(Account account);
	List<Operation> findByDateCreatedAccount(Date dateCreated, Account account);
}
