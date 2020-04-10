package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntr.mybank.model.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer>{

}
