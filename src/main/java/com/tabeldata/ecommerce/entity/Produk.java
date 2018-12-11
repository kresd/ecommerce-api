package com.tabeldata.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produk")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produk {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String idProduk;

    @Column(name = "nama_produk", nullable = false, length = 100)
    private String namaProduk;

    @Column(name = "stock", nullable = false)
    private int stockProduk;

    @Column(name = "harga", nullable = false)
    private BigDecimal priceProduk;

    @ManyToOne
    @JoinColumn(name = "toko_id")
    private Toko toko;
}
