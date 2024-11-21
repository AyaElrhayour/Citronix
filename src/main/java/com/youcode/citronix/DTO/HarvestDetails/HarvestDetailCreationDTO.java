package com.youcode.citronix.DTO.HarvestDetails;


import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailCreationDTO {

    private UUID harvestId;

    private UUID treeId;


    @NotNull
    private Double quantity;

    private LocalDate harvestDate;


    public HarvestDetailCreationDTO(HarvestDetailsEmbdedId id, Double quantity, LocalDate harvestDate) {
    }
}
