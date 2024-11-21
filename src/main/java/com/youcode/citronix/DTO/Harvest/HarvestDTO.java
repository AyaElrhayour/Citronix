package com.youcode.citronix.DTO.Harvest;


import com.youcode.citronix.Models.Enums.Season;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestDTO {


    private UUID id;

    private LocalDate harvestDate;

    private Double quantity;

    private Season season;

    private boolean isFullySold;

}
