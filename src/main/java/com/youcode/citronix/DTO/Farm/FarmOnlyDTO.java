package com.youcode.citronix.DTO.Farm;

import com.youcode.citronix.DTO.Field.AllFieldsDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmOnlyDTO {

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

    @NotBlank
    private List<AllFieldsDTO> allFields;
}
