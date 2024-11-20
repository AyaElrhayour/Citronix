package com.youcode.citronix.DTO.Farm;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmOnlyDTO {

    private UUID id;

    @NotBlank
    private String name;
}
