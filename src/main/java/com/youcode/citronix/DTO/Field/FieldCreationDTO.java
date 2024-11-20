package com.youcode.citronix.DTO.Field;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldCreationDTO {

    private UUID id;


    @NotNull
    @Min(value = 1000, message = "The minimum surface is 1000 m²")
    private Double surface;

    @NotBlank
    private UUID farmId;
}
