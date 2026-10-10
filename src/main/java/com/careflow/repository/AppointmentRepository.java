package com.careflow.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careflow.entity.Appointment;

@Repository
public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTime(
            Long doctorId,
            LocalDate appointmentDate,
            LocalTime appointmentTime
    );

    List<Appointment> findByPatientId(Long patientId);

    List<Appointment> findByDoctorId(Long doctorId);
}
