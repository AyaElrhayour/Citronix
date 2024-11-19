package com.youcode.citronix.DTO.Field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldCreationDTO {

    private UUID id;

    @Positive
    @NonNull
    private Double surface;

    @NotBlank
    private UUID farmId;
}
