package com.tabeldata.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "toko")
@ToString(exclude = "daftarProduk")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Toko {
    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String idToko;

    @Column(name = "nama", nullable = false, length = 100)
    private String namaToko;

    @Column(name = "alamat", nullable = false, length = 100)
    private String alamatToko;

    @OneToMany
    @JoinTable(
            name = "produk_toko",
            joinColumns = @JoinColumn(name = "toko_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "produk_id", nullable = false)
    )
    private List<Produk> daftarProduk = new ArrayList<>();

}
