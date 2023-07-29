package com.scorpions.entities;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Duration;
import java.util.List;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "projectDetails")
@Data
public class EmployeeProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long employeeId;

    @NonNull
    private Long projectId;
    private String responsibility;
    private String roles;
    private String achievements;
    private String skillsUsed;
    private Duration fromDate;
    private Duration toData;
}
