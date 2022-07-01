package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
//reference = https://stackoverflow.com/questions/8969059/difference-between-onetomany-and-elementcollection#:~:text=I%20believe%20%40ElementCollection%20is%20mainly,what%20you%20want%20to%20achieve.
// element collection -> non-entities
//@onetomany -> map entities
//private long id;
//private List<Long> employeeIds;
//private List<Long> petIds;
//private LocalDate date;
//private Set<EmployeeSkill> activities;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToMany
    private List<Employees> employees;

    @ManyToMany
    private Set<Pet> pets;

    @ElementCollection
    private Set<EmployeeSkill> activities;

    @ManyToMany
    private List<Customer> customers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
