package com.tabeldata.ecommerce.api;

import com.tabeldata.ecommerce.entity.Statust;
import com.tabeldata.ecommerce.service.StatustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/statustrx")
public class StatustApi {

    @Autowired
    public StatustService service;

    @PostMapping("/save")
    public ResponseEntity<Statust> save(@RequestBody Statust statusTrx) {
        statusTrx = service.save(statusTrx);
        return ResponseEntity.ok(statusTrx);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statust> findById(@PathVariable("id") String id) {
        Optional<Statust> statusTrx = service.findById(id);
        if (statusTrx.isPresent()) {
            return ResponseEntity.ok(statusTrx.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/list")
    public Page<Statust> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/save")
    public ResponseEntity<Statust> update(@RequestBody Statust statusTrx) {
        statusTrx = service.save(statusTrx);
        return ResponseEntity.ok(statusTrx);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }
}
