package com.tabeldata.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pembeli")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pembeli {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String namaPembeli;

    @Column(name = "telp", nullable = false, length = 100)
    private String telp;

    @Column(name = "alamat", nullable = false, length = 100)
    private String alamat;

    @Column(name = "email", nullable = false, length = 100)
    private String email;
}
