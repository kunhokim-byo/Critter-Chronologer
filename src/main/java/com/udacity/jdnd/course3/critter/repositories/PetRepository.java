package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//create update delete read
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
//    http://localhost:8082/pet/owner/1 -> owner == customer
    List<Pet> findPetsByCustomerId(Long customerId);


}
