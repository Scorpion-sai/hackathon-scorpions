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
import jakarta.transaction.Transactional;
import java.time.Duration;
import java.time.Month;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Transactional
@Table(name = "employee_project_details")
@Data
public class EmployeeProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long employeeId;
    
    @NonNull
    private Long projectId;
    private String employeeName;
    private String employeeEmailId;
    private String projectName;
    private String projectDescription;
    private String responsibility;
    private String roles;
    private String achievements;
    @ElementCollection
    @CollectionTable(name = "employee_project_details_skills", joinColumns = @JoinColumn(name = "employee_project_details_id"))
    @Column(name = "skills_used")
    private List<String> skillsUsed;
    private Month fromMonth;
    private int fromYear;
    private Month toMonth;
    private int toYear;
}
