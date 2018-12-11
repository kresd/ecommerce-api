package com.tabeldata.ecommerce.service;

import com.tabeldata.ecommerce.entity.Checkout;
import com.tabeldata.ecommerce.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class CheckoutService {

    @Autowired
    private CheckoutRepository repository;

    @Transactional
    public Checkout save(Checkout checkout) {
        return repository.save(checkout);
    }

    public Optional<Checkout> findById(String id) {
        return repository.findById(id);
    }

    public Page<Checkout> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
