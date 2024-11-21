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
public class HarvestCreationDTO {

    private UUID id;

    private boolean isFullySold;

    @NotNull
    private Double quantity;

    private Season season;
}
