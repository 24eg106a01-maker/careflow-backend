package com.careflow.controller;

import com.careflow.entity.Doctor;
import com.careflow.repository.DoctorRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorRepository repository;
    public DoctorController(DoctorRepository repository) { this.repository=repository; }

    @GetMapping
    public List<Doctor> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
