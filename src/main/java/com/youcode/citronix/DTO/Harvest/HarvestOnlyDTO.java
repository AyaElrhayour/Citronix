package com.youcode.citronix.DTO.Harvest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestOnlyDTO {

    private UUID id;

    private LocalDate harvestDate;

    private Double quantity;
}
