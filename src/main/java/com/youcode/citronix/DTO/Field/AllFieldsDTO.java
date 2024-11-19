package com.youcode.citronix.DTO.Field;


import com.youcode.citronix.Models.Entities.Farm;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllFieldsDTO {

    @NotNull
    private UUID id;

    @NotNull
    private Double surface;

    @NotNull
    private Farm farm;

    @NotNull
    private Integer treeCount;
}
