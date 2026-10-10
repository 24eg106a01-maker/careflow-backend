package com.careflow.controller;

import com.careflow.entity.Patient;
import com.careflow.repository.PatientRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientRepository repository;
    public PatientController(PatientRepository repository) { this.repository=repository; }

    @GetMapping
    public List<Patient> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
