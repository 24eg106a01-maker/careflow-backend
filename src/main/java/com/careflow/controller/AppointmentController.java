package com.careflow.controller;

import com.careflow.entity.Appointment;
import com.careflow.repository.AppointmentRepository;
import com.careflow.service.AppointmentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentRepository repository;
    private final AppointmentService service;
    public AppointmentController(AppointmentRepository repository, AppointmentService service) {
        this.repository=repository; this.service=service;
    }

    @GetMapping public List<Appointment> all() { return repository.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Appointment> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/patient/{patientId}") public List<Appointment> patient(@PathVariable Long patientId) {
        return repository.findByPatientId(patientId);
    }
    @GetMapping("/doctor/{doctorId}") public List<Appointment> doctor(@PathVariable Long doctorId) {
        return repository.findByDoctorId(doctorId);
    }
    @PostMapping public ResponseEntity<Appointment> create(@RequestBody Appointment a) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(a));
    }
    @PutMapping("/{id}") public ResponseEntity<Appointment> update(@PathVariable Long id,@RequestBody Appointment a) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        a.setId(id); return ResponseEntity.ok(repository.save(a));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
