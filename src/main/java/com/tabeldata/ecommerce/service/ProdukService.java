package com.tabeldata.ecommerce.service;

import com.tabeldata.ecommerce.entity.Produk;
import com.tabeldata.ecommerce.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class ProdukService {

    @Autowired
    private ProdukRepository repository;

    @Transactional
    public Produk save(Produk produk) {
        return repository.save(produk);
    }

    public Optional<Produk> findById(String id) {
        return repository.findById(id);
    }

    public Page<Produk> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
