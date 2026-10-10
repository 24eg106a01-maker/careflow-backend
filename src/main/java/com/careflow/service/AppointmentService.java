
package com.careflow.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careflow.entity.Appointment;
import com.careflow.enums.AppointmentStatus;
import com.careflow.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Appointment create(Appointment appointment) {

        if (appointment.getPatient() == null
                || appointment.getPatient().getId() == null) {
            throw new IllegalArgumentException(
                "Patient is required");
        }

        if (appointment.getDoctor() == null
                || appointment.getDoctor().getId() == null) {
            throw new IllegalArgumentException(
                "Doctor is required");
        }

        if (appointment.getAppointmentDate() == null
                || appointment.getAppointmentTime() == null) {
            throw new IllegalArgumentException(
                "Appointment date and time are required");
        }

        LocalDate date = appointment.getAppointmentDate();
        LocalTime time = appointment.getAppointmentTime();

        if (date.isBefore(LocalDate.now())
                || (date.isEqual(LocalDate.now())
                && time.isBefore(LocalTime.now()))) {
            throw new IllegalArgumentException(
                "Cannot book an appointment in the past");
        }

        boolean alreadyBooked =
            repository.existsByDoctorIdAndAppointmentDateAndAppointmentTime(
                appointment.getDoctor().getId(), date, time);

        if (alreadyBooked) {
            throw new IllegalStateException(
                "Doctor is already booked for this date and time");
        }

        appointment.setStatus(AppointmentStatus.SCHEDULED);

        return repository.save(appointment);
    }
}
