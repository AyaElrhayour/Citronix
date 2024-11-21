package com.youcode.citronix.DTO.Harvest;


import com.youcode.citronix.Models.Enums.Season;
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

    private Double quantity;

    private Season season;
}
