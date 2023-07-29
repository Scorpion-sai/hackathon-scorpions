package com.scorpions.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Transactional
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long employeeId;
    private String name;
    private String emailId;
    private String gender;
    private String currentDesignation;
    private int yearsOfExperience;
    private String skills;
    private String areaOfInterest;
    private boolean showWithoutAuth;
}