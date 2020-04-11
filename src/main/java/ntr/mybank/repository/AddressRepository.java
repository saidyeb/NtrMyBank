package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntr.mybank.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
