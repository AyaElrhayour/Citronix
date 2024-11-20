package com.youcode.citronix.DTO.Tree;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    private int age;

    @NotNull
    private LocalDate plantingDate;

    @NotNull
    private boolean isHarvested;

    @NotNull
    private UUID fieldId;
}
