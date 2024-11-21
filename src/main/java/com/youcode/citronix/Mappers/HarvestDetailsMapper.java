package com.youcode.citronix.Mappers;


import com.youcode.citronix.DTO.HarvestDetails.HarvestDetailCreationDTO;
import com.youcode.citronix.Models.Entities.HarvestDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HarvestDetailsMapper {

    HarvestDetails toHarvestDetails(HarvestDetails harvestDetails);

    HarvestDetailCreationDTO toHarvestDetailCreationDTO(HarvestDetails harvestDetails);

}
