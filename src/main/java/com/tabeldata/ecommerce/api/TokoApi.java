package com.tabeldata.ecommerce.api;

import com.tabeldata.ecommerce.entity.Toko;
import com.tabeldata.ecommerce.service.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/toko")
public class TokoApi {

    @Autowired
    public TokoService service;

    @PostMapping("/save")
    public ResponseEntity<Toko> save(@RequestBody Toko toko) {
        toko = service.save(toko);
        return ResponseEntity.ok(toko);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toko> findById(@PathVariable("id") String id) {
        Optional<Toko> toko = service.findById(id);
        if (toko.isPresent()) {
            return ResponseEntity.ok(toko.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/list")
    public Page<Toko> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/save")
    public ResponseEntity<Toko> update(@RequestBody Toko toko) {
        toko = service.save(toko);
        return ResponseEntity.ok(toko);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }
}
