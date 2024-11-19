package com.youcode.citronix.Models.Entities;


import com.youcode.citronix.Models.Enums.Season;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "harvests")
public class Harvest {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "harvestDate" , nullable = false)
    private LocalDate harvestDate;

    @Column(nullable = false , name = "quantity")
    private Double quantity;

    @Column(name = "season" , nullable = false)
    private Season season;

    @Column(name = "isFullySold")
    private boolean isFullySold;

    @OneToMany(mappedBy = "harvest" , fetch = FetchType.EAGER)
    private List<Sale> sales;

    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL)
    private List<HarvestDetails> harvestDetails;
}
