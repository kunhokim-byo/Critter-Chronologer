package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//public interface CrudRepository<T, ID> extends Repository<T, ID>
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<Customer> findAllCustomer();
}
