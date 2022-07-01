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
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PetRepository petRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


    public Customer getCustomerByPetId(Long petId){
        return petRepository.getOne(petId).getCustomer();
    }

    public Customer getCustomerById(Long customerID){
        return customerRepository.getOne(customerID);
    }

    public void addPetToCustomer(Pet pet, Customer customer){
        List<Pet> CustomerPetsList = customer.getPets();
        if(CustomerPetsList != null){
            CustomerPetsList.add(pet);
        }else{
            CustomerPetsList = new ArrayList<Pet>();
            CustomerPetsList.add(pet);
        }
        customer.setPets(CustomerPetsList);
        customerRepository.save(customer);
    }



}


//    @PostMapping("/customer")
//    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/customer")
//    public List<CustomerDTO> getAllCustomers(){
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/customer/pet/{petId}")
//    public CustomerDTO getOwnerByPet(@PathVariable long petId){
//        throw new UnsupportedOperationException();
//    }
//

//    }