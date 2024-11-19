package com.youcode.citronix.DTO.Field;

import com.youcode.citronix.DTO.Tree.TreeCreationDTO;
import com.youcode.citronix.Models.Entities.Farm;
import com.youcode.citronix.Models.Entities.Tree;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDTO {

    private UUID id;

    @NonNull
    private Double surface;

    @NotBlank
    private Farm farm;

    @NotBlank
    private List<TreeCreationDTO> trees;

}
