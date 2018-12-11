package com.tabeldata.ecommerce.service;

import com.tabeldata.ecommerce.entity.Transaksi;;
import com.tabeldata.ecommerce.entity.TransaksiDetails;
import com.tabeldata.ecommerce.repository.ProdukRepository;
import com.tabeldata.ecommerce.repository.TransaksiDetailRepository;
import com.tabeldata.ecommerce.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class TransaksiService {

    @Autowired
    private ProdukRepository produkRepository;

    @Autowired
    private TransaksiDetailRepository transaksiDetailRepository;

    @Autowired
    private TransaksiRepository repository;

    @Transactional
    public Transaksi save(Transaksi transaksi) {
        return repository.save(transaksi);
    }

    public Optional<Transaksi> findById(String id) {
        return repository.findById(id);
    }

    public Page<Transaksi> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    @Transactional
    public Transaksi pembelianProduk(Transaksi transaksi) {
        List<TransaksiDetails> details = transaksi.getDetails();
        transaksi = repository.save(transaksi);
        for (TransaksiDetails detail : details) {
            detail.setTransaksi(transaksi);
            transaksiDetailRepository.save(detail);
            produkRepository.updateStockPembelian(detail.getProduk().getIdProduk(), 1);
        }
        return transaksi;
    }

    @Transactional
    public Transaksi pembatalanProduk(Transaksi transaksi) {
        repository.pembatalanTransaksi(transaksi.getIdTrx(), Timestamp.valueOf(LocalDateTime.now()));
        for (TransaksiDetails detail : transaksi.getDetails()) {
            produkRepository.updateStockPembatalan(detail.getProduk().getIdProduk(), 1);
        }
        return transaksi;
    }
}
