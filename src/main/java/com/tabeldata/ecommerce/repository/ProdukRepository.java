package com.tabeldata.ecommerce.repository;

import com.tabeldata.ecommerce.entity.Produk;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdukRepository extends PagingAndSortingRepository<Produk, String> {
    @Modifying
    @Query("update from Produk set stock = stock - ?2 where id = ?1")
    int updateStockPembelian(String id, Integer stok);

    @Query("update from Produk set stock = stock + ?2 where id = ?1")
    @Modifying
    int updateStockPembatalan(String id, Integer stok);
}
