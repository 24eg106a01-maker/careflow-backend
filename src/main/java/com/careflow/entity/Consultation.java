package com.careflow.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class Consultation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional=false) private Appointment appointment;
    @ManyToOne(optional=false) private Patient patient;
    @ManyToOne(optional=false) private Doctor doctor;
    private LocalDate consultationDate;
    @Column(length=2000) private String symptoms;
    @Column(length=2000) private String diagnosis;
    @Column(length=4000) private String notes;
    private LocalDate followUpDate;

    public Consultation() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Appointment getAppointment() { return appointment; }

    public void setAppointment(Appointment appointment) { this.appointment = appointment; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDate getConsultationDate() { return consultationDate; }

    public void setConsultationDate(LocalDate consultationDate) { this.consultationDate = consultationDate; }

    public String getSymptoms() { return symptoms; }

    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }

    public LocalDate getFollowUpDate() { return followUpDate; }

    public void setFollowUpDate(LocalDate followUpDate) { this.followUpDate = followUpDate; }
}
