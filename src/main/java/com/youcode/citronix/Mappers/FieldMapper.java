package com.youcode.citronix.Mappers;

import com.youcode.citronix.DTO.Field.AllFieldsDTO;
import com.youcode.citronix.Models.Entities.Field;

public class FieldMapper {

    public static AllFieldsDTO toAllFieldsDTO(Field field) {
        return new AllFieldsDTO(
                field.getId(),
                field.getSurface(),
                field.getFarm(),
                field.getTrees() != null ? field.getTrees().size() : 0
        );
    }
}
