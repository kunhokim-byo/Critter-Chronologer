package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PetService {
    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    public Pet savePet(Pet pet){
//        1.
        Pet petSaved = petRepository.save(pet);
        Customer customer = petSaved.getCustomer();
        List<Pet> customerPets = customer.getPets();
        if(customerPets == null){
            customerPets = new ArrayList<>();
        }
        customerPets.add(petSaved);
        customer.setPets(customerPets);
        customerRepository.save(customer);

        return petSaved;
    }

    public Pet getPetById(Long petId){
        return petRepository.getOne(petId);
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public List<Pet> getPetsByCustomerId(Long customerId){
        return petRepository.findPetsByCustomerId(customerId);
    }

    public List<Pet> getAllPetsByIds(List<Long> ids){return petRepository.findAllById(ids);}




}
//    @PostMapping
//    public PetDTO savePet(@RequestBody PetDTO petDTO) {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/{petId}")
//    public PetDTO getPet(@PathVariable long petId) {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping
//    public List<PetDTO> getPets(){
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/owner/{ownerId}")
//    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
//        throw new UnsupportedOperationException();
//    }