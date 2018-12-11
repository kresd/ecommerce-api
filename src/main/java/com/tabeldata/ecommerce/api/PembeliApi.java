package com.tabeldata.ecommerce.api;

import com.tabeldata.ecommerce.entity.Pembeli;
import com.tabeldata.ecommerce.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pembeli")
public class PembeliApi {

    @Autowired
    public PembeliService service;

    @PostMapping("/save")
    public ResponseEntity<Pembeli> save(@RequestBody Pembeli pembeli) {
        pembeli = service.save(pembeli);
        return ResponseEntity.ok(pembeli);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pembeli> findById(@PathVariable("id") String id) {
        Optional<Pembeli> pembeli = service.findById(id);
        if (pembeli.isPresent()) {
            return ResponseEntity.ok(pembeli.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/list")
    public Page<Pembeli> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/save")
    public ResponseEntity<Pembeli> update(@RequestBody Pembeli pembeli) {
        pembeli = service.save(pembeli);
        return ResponseEntity.ok(pembeli);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }
}
