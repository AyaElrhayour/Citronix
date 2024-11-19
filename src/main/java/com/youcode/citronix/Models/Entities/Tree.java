package com.youcode.citronix.Models.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trees")
public class Tree {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false , name = "age")
    private int age;

    @Column(name = "plantingDate" , nullable = false)
    private LocalDate plantingDate;

    @Column(name = "isHarvested" , nullable = false)
    private boolean isHarvested;

    @ManyToOne(fetch = FetchType.EAGER , optional = false)
    private Field field;

    @OneToMany(mappedBy = "tree", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<HarvestDetails> harvestDetails;
}
