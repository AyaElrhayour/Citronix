package com.youcode.citronix.DTO.Tree;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeCreationDTO {

    private UUID id;

    @NotNull
    private LocalDate plantingDate;

    private String age;

    private String treeType;

    private String seasonalProductivity;

    @NotNull
    private boolean isHarvested;

    @NotNull
    private UUID fieldId;
}
