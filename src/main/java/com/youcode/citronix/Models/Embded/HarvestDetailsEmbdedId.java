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

    @Column(name = "TreeId")
    private UUID TreeId;

    @Column(name = "HarvestId")
    private UUID HarvestId;
}
