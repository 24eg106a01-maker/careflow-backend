package com.careflow.controller;

import com.careflow.entity.Billing;
import com.careflow.repository.BillingRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    private final BillingRepository repository;
    public BillingController(BillingRepository repository) { this.repository=repository; }

    @GetMapping
    public List<Billing> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Billing> create(@RequestBody Billing value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Billing> update(@PathVariable Long id, @RequestBody Billing value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
