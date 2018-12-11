package com.tabeldata.ecommerce.service;

import com.tabeldata.ecommerce.entity.Statust;
import com.tabeldata.ecommerce.repository.StatustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class StatustService {
    @Autowired
    private StatustRepository repository;

    @Transactional
    public Statust save(Statust statusTrx) {
        return repository.save(statusTrx);
    }

    public Optional<Statust> findById(String id) {
        return repository.findById(id);
    }

    public Page<Statust> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
