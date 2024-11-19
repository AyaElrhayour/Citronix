package com.youcode.citronix.Mappers;

import com.youcode.citronix.DTO.Farm.AllFarmsDTO;
import com.youcode.citronix.Models.Entities.Farm;

public class FarmMapper {

    public static AllFarmsDTO toAllFarmsDTO(Farm farm) {
        return new AllFarmsDTO(
                farm.getId(),
                farm.getName(),
                farm.getLocation(),
                farm.getSurface(),
                farm.getCreationDate(),
                farm.getFields() != null ? farm.getFields().size() : 0
        );
    }
}
