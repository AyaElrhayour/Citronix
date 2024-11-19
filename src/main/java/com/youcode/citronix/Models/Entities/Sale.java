package com.youcode.citronix.Models.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false , name = "salesDate")
    private LocalDate salesDate;


    @Column(nullable = false , name = "unitPrice")
    private Double unitPrice;


    @Column(nullable = false , name = "client")
    private String client;

    @ManyToOne(fetch = FetchType.EAGER)
    private Harvest harvest;
}
