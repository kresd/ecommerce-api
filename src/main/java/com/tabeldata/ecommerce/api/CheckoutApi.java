package com.tabeldata.ecommerce.api;

import com.tabeldata.ecommerce.entity.Checkout;
import com.tabeldata.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutApi {

    @Autowired
    public CheckoutService service;

    @PostMapping("/save")
    public ResponseEntity<Checkout> save(@RequestBody Checkout checkout) {
        checkout = service.save(checkout);
        return ResponseEntity.ok(checkout);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkout> findById(@PathVariable("id") String id) {
        Optional<Checkout> checkout = service.findById(id);
        if (checkout.isPresent()) {
            return ResponseEntity.ok(checkout.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/list")
    public Page<Checkout> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/save")
    public ResponseEntity<Checkout> update(@RequestBody Checkout checkout) {
        checkout = service.save(checkout);
        return ResponseEntity.ok(checkout);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }
}
