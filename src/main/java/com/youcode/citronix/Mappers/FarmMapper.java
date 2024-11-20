package com.youcode.citronix.Mappers;


import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmOnlyDTO;
import com.youcode.citronix.Models.Entities.Farm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    Farm toFarm(FarmCreationDTO farmCreationDTO);

    FarmCreationDTO toFarmCreationDTO(Farm farm);

    FarmOnlyDTO toFarmOnlyDTO(Farm farm);

}
