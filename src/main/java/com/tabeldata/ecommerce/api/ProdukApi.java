package com.tabeldata.ecommerce.api;

import com.tabeldata.ecommerce.entity.Produk;
import com.tabeldata.ecommerce.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produk")
public class ProdukApi {

    @Autowired
    public ProdukService service;

    @PostMapping("/save")
    public ResponseEntity<Produk> save(@RequestBody Produk produk) {
        produk = service.save(produk);
        return ResponseEntity.ok(produk);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> findById(@PathVariable("id") String id) {
        Optional<Produk> produk = service.findById(id);
        if (produk.isPresent()) {
            return ResponseEntity.ok(produk.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/list")
    public Page<Produk> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/save")
    public ResponseEntity<Produk> update(@RequestBody Produk produk) {
        produk = service.save(produk);
        return ResponseEntity.ok(produk);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }
}
