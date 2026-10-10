package com.careflow.repository;

import com.careflow.entity.LaboratoryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LaboratoryTestRepository extends JpaRepository<LaboratoryTest, Long> {

    java.util.List<LaboratoryTest> findByPatientId(Long patientId);
}
