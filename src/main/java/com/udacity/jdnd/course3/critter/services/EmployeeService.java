package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Employees;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employees saveEmployee(Employees employees){
        return employeeRepository.save(employees);
    }

    public Employees getEmployeeById(Long employeeId){
        return employeeRepository.getOne(employeeId);
    }

    public List<Employees> getEmployees(){return employeeRepository.findAll();}

    public void SetAvailability(Long employeeId, Set<DayOfWeek> availableDays){
        Employees employees = employeeRepository.getOne(employeeId);
        employees.setAvailableDays(availableDays);
        employeeRepository.save(employees);
    }

    public List<Employees> findEmployeesForCaring(Set<EmployeeSkill> employeeSkills, DayOfWeek availableDays){

        List<Employees> employees = employeeRepository.findAllByAvailableDaysAndEmployeeSkillsIn(availableDays, employeeSkills);
        List<Employees> availableEmployees = new ArrayList<>();
        for(Employees e: employees){
            if(e.getEmployeeSkills().containsAll(employeeSkills)){
                availableEmployees.add(e);
            }
        }
        return availableEmployees;
    }
}
