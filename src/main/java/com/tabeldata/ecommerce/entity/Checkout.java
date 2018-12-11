package com.tabeldata.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "checkout")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checkout {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String idCheckOut;

    @ManyToOne
    @JoinColumn(name = "pembeli_id")
    private Pembeli idPembeli;

    @ManyToOne
    @JoinColumn(name = "produk_id")
    private Produk idProduk;

    @Column(name = "jumlah_barang")
    private int jumlahBarang;

    @Column(name = "total_bayar")
    private BigDecimal totalBayar;
}
