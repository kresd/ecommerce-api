package com.tabeldata.ecommerce.service;

import com.tabeldata.ecommerce.entity.Pembeli;
import com.tabeldata.ecommerce.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class PembeliService {

    @Autowired
    private PembeliRepository repository;

    @Transactional
    public Pembeli save(Pembeli pembeli) {
        return repository.save(pembeli);
    }

    public Optional<Pembeli> findById(String id) {
        return repository.findById(id);
    }

    public Page<Pembeli> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
