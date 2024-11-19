package com.youcode.citronix.DTO.HarvestDetails;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailCreationDTO {

    private UUID id;

    @NotNull
    private Double quantity;


}
