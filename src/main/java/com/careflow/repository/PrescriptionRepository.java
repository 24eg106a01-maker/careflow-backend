package com.careflow.repository;

import com.careflow.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    java.util.List<Prescription> findByPatientId(Long patientId);
}
