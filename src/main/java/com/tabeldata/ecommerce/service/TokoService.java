package com.tabeldata.ecommerce.service;

import com.tabeldata.ecommerce.entity.Toko;
import com.tabeldata.ecommerce.repository.TokoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class TokoService {

    @Autowired
    private TokoRepository repository;

    @Transactional
    public Toko save(Toko toko) {
        return repository.save(toko);
    }

    public Optional<Toko> findById(String id) {
        return repository.findById(id);
    }

    public Page<Toko> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
