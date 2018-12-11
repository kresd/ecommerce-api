package com.tabeldata.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaksi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaksi {
    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String idTrx;

    @ManyToOne
    @JoinColumn(name = "pembeli_id")
    private Pembeli idPembeli;

    @ManyToOne
    @JoinColumn(name = "produk_id")
    private Produk idProduk;

    @ManyToOne
    @JoinColumn(name = "toko_id")
    private Toko idToko;

    @Column(name = "jumlah_barang")
    private int jumlahBarang;

    @Column(name = "total_bayar")
    private BigDecimal totalBayar;

    @ManyToOne
    @JoinColumn(name = "statust_id")
    private Statust statust;

    @Column(name = "tanggal_transaksi")
    private Timestamp tanggalTrx;

    @Column(name = "is_cancel", nullable = false)
    private boolean pembatalan;

    @OneToMany(mappedBy = "transaksi")
    private List<TransaksiDetails> details = new ArrayList<>();
}
