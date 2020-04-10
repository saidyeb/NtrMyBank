package ntr.mybank.repository;

import org.springframework.data.repository.CrudRepository;

import ntr.mybank.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
