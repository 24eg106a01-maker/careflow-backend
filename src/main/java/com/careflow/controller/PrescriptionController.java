package com.careflow.controller;

import com.careflow.entity.Prescription;
import com.careflow.repository.PrescriptionRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    private final PrescriptionRepository repository;
    public PrescriptionController(PrescriptionRepository repository) { this.repository=repository; }

    @GetMapping
    public List<Prescription> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> update(@PathVariable Long id, @RequestBody Prescription value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
