package com.youcode.citronix.Models.Embded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailsEmbdedId {

    @Column(name = "treeId")
    private UUID treeId;

    @Column(name = "harvestId")
    private UUID harvestId;
}
