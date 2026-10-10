package com.careflow.controller;

import com.careflow.entity.Consultation;
import com.careflow.repository.ConsultationRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {
    private final ConsultationRepository repository;
    public ConsultationController(ConsultationRepository repository) { this.repository=repository; }

    @GetMapping
    public List<Consultation> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Consultation> create(@RequestBody Consultation value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultation> update(@PathVariable Long id, @RequestBody Consultation value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
