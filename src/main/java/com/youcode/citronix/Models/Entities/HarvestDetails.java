package com.youcode.citronix.Models.Entities;


import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "harvestDetails")
public class HarvestDetails {

    @EmbeddedId
    private HarvestDetailsEmbdedId id;

    @Column(nullable = false)
    private Double quantity;

    @Column(name = "harvestDate" , nullable = false)
    private LocalDate harvestDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("treeId")
    private Tree tree;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("harvestId")
    private Harvest harvest;
}
