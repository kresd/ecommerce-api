package com.tabeldata.ecommerce.api;

import com.tabeldata.ecommerce.entity.Transaksi;
import com.tabeldata.ecommerce.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiApi {
    @Autowired
    public TransaksiService service;

    @PostMapping("/save")
    public ResponseEntity<Transaksi> save(@RequestBody Transaksi transaksi) {
        transaksi = service.save(transaksi);
        return ResponseEntity.ok(transaksi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaksi> findById(@PathVariable("id") String id) {
        Optional<Transaksi> transaksi = service.findById(id);
        if (transaksi.isPresent()) {
            return ResponseEntity.ok(transaksi.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/list")
    public Page<Transaksi> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/save")
    public ResponseEntity<Transaksi> update(@RequestBody Transaksi transaksi) {
        transaksi = service.save(transaksi);
        return ResponseEntity.ok(transaksi);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }

    @PostMapping("/pembelian/produk")
    public ResponseEntity<?> transaksiPembelianProduk(@RequestBody Transaksi transaksi) {
        transaksi = service.pembelianProduk(transaksi);
        return ResponseEntity.ok(transaksi);
    }

    @PostMapping("/pembatalan/produk")
    public ResponseEntity<?> transaksiPembatalanProduk(@RequestParam("id") String transaksiId) {
        Optional<Transaksi> transaksiOptional = service.findById(transaksiId);
        if (!transaksiOptional.isPresent()) return ResponseEntity.noContent().build();
        else {
            Transaksi transaksi = transaksiOptional.get();
            if (transaksi.isPembatalan()) return ResponseEntity.badRequest().body("Telah dibatalkan!");
            else {
                transaksi = service.pembatalanProduk(transaksi);
                return ResponseEntity.ok(transaksi);
            }
        }

    }
}
