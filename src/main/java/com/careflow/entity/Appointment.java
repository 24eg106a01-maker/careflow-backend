package com.careflow.entity;

import com.careflow.enums.AppointmentStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity

@Table(uniqueConstraints=@UniqueConstraint(columnNames={"doctor_id","appointment_date","appointment_time"}))
public class Appointment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false) private Patient patient;
    @ManyToOne(optional=false) private Doctor doctor;
    @Column(name="appointment_date", nullable=false) private LocalDate appointmentDate;
    @Column(name="appointment_time", nullable=false) private LocalTime appointmentTime;
    @Enumerated(EnumType.STRING) private AppointmentStatus status;
    private String reason;

    public Appointment() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDate getAppointmentDate() { return appointmentDate; }

    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public LocalTime getAppointmentTime() { return appointmentTime; }

    public void setAppointmentTime(LocalTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public AppointmentStatus getStatus() { return status; }

    public void setStatus(AppointmentStatus status) { this.status = status; }

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }
}
