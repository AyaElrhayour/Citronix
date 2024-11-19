package com.youcode.citronix.Mappers;


import com.youcode.citronix.DTO.Farm.AllFarmsDTO;
import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmOnlyDTO;
import com.youcode.citronix.Models.Entities.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    Farm toFarm(FarmCreationDTO farmCreationDTO);

    FarmCreationDTO toFarmCreationDTO(Farm farm);

    AllFarmsDTO toAllFarmsDTO(Farm farm);

    FarmOnlyDTO toFarmOnlyDTO(Farm farm);

    default void calculateFieldsCount(Farm farm, @MappingTarget AllFarmsDTO allFarmsDTO) {
        if (farm != null && farm.getFields() != null) {
            allFarmsDTO.setFieldsCount(farm.getFields().size());
        } else {
            allFarmsDTO.setFieldsCount(0);
        }
    }
}
