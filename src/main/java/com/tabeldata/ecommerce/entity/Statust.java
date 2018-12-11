package com.tabeldata.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "statust")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statust {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String idStatusTrx;

    @Column(name = "ket_status", nullable = false, length = 100)
    private String ketStatus;

}
