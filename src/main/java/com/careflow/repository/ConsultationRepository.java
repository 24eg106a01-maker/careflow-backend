package com.careflow.repository;

import com.careflow.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    java.util.List<Consultation> findByPatientId(Long patientId);
    java.util.List<Consultation> findByDoctorId(Long doctorId);
}
