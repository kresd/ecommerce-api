package com.tabeldata.ecommerce.repository;

import com.tabeldata.ecommerce.entity.Transaksi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, String> {
    @Query("update Transaksi set pembatalan = true, tanggalPembatalan = ?2 where id = ?1")
    @Modifying
    int pembatalanTransaksi(String id, Timestamp tanggalPembatalan);
}
