package com.youcode.citronix.DTO.Tree;


import com.youcode.citronix.DTO.Field.FieldOnlyDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDTO {

    private UUID id;

    private int age;

    @NotNull
    private boolean isHarvested;

    private FieldOnlyDTO field;


}
