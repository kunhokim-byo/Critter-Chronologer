package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Employees;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;


//http://localhost:8082/user/employee/availability -> check availability
@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    //check availability
    List<Employees> findAllByAvailableDaysContains(DayOfWeek dayOfWeek);

    List<Employees> findAllByAvailableDaysAndEmployeeSkillsIn(DayOfWeek dayOfWeek, Set<EmployeeSkill> skills);

}
