package com.youcode.citronix.Mappers;


import com.youcode.citronix.DTO.Field.FieldCreationDTO;
import com.youcode.citronix.DTO.Field.FieldDTO;
import com.youcode.citronix.DTO.Field.FieldOnlyDTO;
import com.youcode.citronix.Models.Entities.Field;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    Field toField(FieldCreationDTO fieldCreationDTO);

    FieldCreationDTO toFieldCreationDTO(Field field);

    FieldDTO toFieldDTO(Field field);

    FieldOnlyDTO toFieldOnlyDTO(Field field);

}
