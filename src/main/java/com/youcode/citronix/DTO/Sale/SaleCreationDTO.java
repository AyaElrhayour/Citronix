package com.youcode.citronix.DTO.Sale;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleCreationDTO {

    private UUID id;

    @NotNull
    private LocalDate salesDate;

    @NotNull
    private Double unitPrice;

    @NotBlank
    private String client;

}
