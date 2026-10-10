package com.careflow.entity;

import com.careflow.enums.BillingStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

public class Billing {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false) private Patient patient;
    @ManyToOne private Appointment appointment;
    @ManyToOne private Consultation consultation;
    @Column(nullable=false, precision=12, scale=2) private BigDecimal amount;
    private String description;
    private LocalDate billingDate;
    @Enumerated(EnumType.STRING) private BillingStatus status;

    public Billing() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public Appointment getAppointment() { return appointment; }

    public void setAppointment(Appointment appointment) { this.appointment = appointment; }

    public Consultation getConsultation() { return consultation; }

    public void setConsultation(Consultation consultation) { this.consultation = consultation; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public LocalDate getBillingDate() { return billingDate; }

    public void setBillingDate(LocalDate billingDate) { this.billingDate = billingDate; }

    public BillingStatus getStatus() { return status; }

    public void setStatus(BillingStatus status) { this.status = status; }
}
