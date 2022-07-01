package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Employees;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //1. Find Schedule by Pet

    List<Schedule> findAllByPets(Pet pet);
    //2. Find Schedule by Employee

    List<Schedule> findAllByEmployees(Employees employees);
    //3. Find Schedule by Owner (== customer

    List<Schedule> getAllByPetsIn(List<Pet> pets);
}
