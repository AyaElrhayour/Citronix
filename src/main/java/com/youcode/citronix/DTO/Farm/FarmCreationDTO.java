package com.youcode.citronix.DTO.Farm;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmCreationDTO {

    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @Positive
    @NotNull
    private Double surface;

    @NotNull
    private LocalDate creationDate;
}
