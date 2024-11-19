package com.youcode.citronix.Models.Entities;


import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("treeId")
    private Tree tree;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("harvestId")
    private Harvest harvest;
}
