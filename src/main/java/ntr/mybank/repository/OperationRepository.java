package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;

import ntr.mybank.model.Operation;

public interface OperationRepository extends CrudRepository<Operation, Integer>{
}
