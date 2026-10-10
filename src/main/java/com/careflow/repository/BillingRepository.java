package com.careflow.repository;

import com.careflow.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {

    java.util.List<Billing> findByPatientId(Long patientId);
}
