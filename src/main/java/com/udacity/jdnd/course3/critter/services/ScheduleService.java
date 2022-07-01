package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employees;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Schedule createSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByPetId(Long petId){
        Pet pet = petRepository.getOne(petId);
        return scheduleRepository.findAllByPets(pet);
    }

    public List<Schedule> getSchedulesByEmployeeId(Long employeeId){
        Employees employees = employeeRepository.getOne(employeeId);
        return scheduleRepository.findAllByEmployees(employees);
    }

    public List<Schedule> getSchedulesByCustomerId(Long customerId){
        Customer customer = customerRepository.getOne(customerId);
        return scheduleRepository.getAllByPetsIn(customer.getPets());
    }
}
//    @PostMapping
//    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping
//    public List<ScheduleDTO> getAllSchedules() {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/pet/{petId}")
//    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/employee/{employeeId}")
//    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
//        throw new UnsupportedOperationException();
//    }