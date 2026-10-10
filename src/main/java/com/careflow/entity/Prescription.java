package com.careflow.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class Prescription {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false) private Consultation consultation;
    @ManyToOne(optional=false) private Patient patient;
    @ManyToOne(optional=false) private Doctor doctor;
    private String medicineName;
    private String dosage;
    private String frequency;
    private String duration;
    private String instructions;
    private LocalDate prescribedDate;

    public Prescription() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Consultation getConsultation() { return consultation; }

    public void setConsultation(Consultation consultation) { this.consultation = consultation; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public String getMedicineName() { return medicineName; }

    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }

    public String getDosage() { return dosage; }

    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getFrequency() { return frequency; }

    public void setFrequency(String frequency) { this.frequency = frequency; }

    public String getDuration() { return duration; }

    public void setDuration(String duration) { this.duration = duration; }

    public String getInstructions() { return instructions; }

    public void setInstructions(String instructions) { this.instructions = instructions; }

    public LocalDate getPrescribedDate() { return prescribedDate; }

    public void setPrescribedDate(LocalDate prescribedDate) { this.prescribedDate = prescribedDate; }
}
