package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

//@ElementCollection(targetClass = Days.class)
//@CollectionTable(name = "days", joinColumns = @JoinColumn(name = "rule_id"))
//@Column(name = "daysOfWeek", nullable = false)
//@Enumerated(EnumType.STRING)
//private Set<EmployeeSkill> skills; -> enum
//private Set<DayOfWeek> daysAvailable; -> enum
@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String name;


    @ElementCollection
    private Set<EmployeeSkill> employeeSkills;

    @ElementCollection
    private Set<DayOfWeek> availableDays;

    @ManyToMany(mappedBy = "employees")
    private Set<Schedule> schedules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(Set<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public Set<DayOfWeek> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Set<DayOfWeek> availableDays) {
        this.availableDays = availableDays;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}


