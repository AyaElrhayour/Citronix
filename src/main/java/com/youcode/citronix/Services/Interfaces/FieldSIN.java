package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.Field.FieldCreationDTO;
import com.youcode.citronix.DTO.Field.FieldDTO;
import com.youcode.citronix.DTO.Field.FieldOnlyDTO;

import java.util.List;
import java.util.UUID;

public interface FieldSIN {

    FieldCreationDTO createField(FieldCreationDTO fieldCreationDTO);
    List<FieldOnlyDTO> getFields();
    FieldDTO getField(UUID id);
    Boolean deleteField(UUID id);
    FieldCreationDTO updateField(UUID id , FieldCreationDTO fieldCreationDTO);
}
