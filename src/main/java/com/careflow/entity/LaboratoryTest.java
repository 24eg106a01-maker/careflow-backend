package com.careflow.entity;

import com.careflow.enums.LaboratoryStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class LaboratoryTest {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false) private Patient patient;
    @ManyToOne(optional=false) private Doctor doctor;
    private String testName;
    private LocalDate testDate;
    @Enumerated(EnumType.STRING) private LaboratoryStatus status;
    @Column(length=4000) private String result;
    private String remarks;

    public LaboratoryTest() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public String getTestName() { return testName; }

    public void setTestName(String testName) { this.testName = testName; }

    public LocalDate getTestDate() { return testDate; }

    public void setTestDate(LocalDate testDate) { this.testDate = testDate; }

    public LaboratoryStatus getStatus() { return status; }

    public void setStatus(LaboratoryStatus status) { this.status = status; }

    public String getResult() { return result; }

    public void setResult(String result) { this.result = result; }

    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks; }
}
