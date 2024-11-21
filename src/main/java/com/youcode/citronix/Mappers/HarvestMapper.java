package com.youcode.citronix.Mappers;

import com.youcode.citronix.DTO.Harvest.HarvestCreationDTO;
import com.youcode.citronix.DTO.Harvest.HarvestDTO;
import com.youcode.citronix.DTO.Harvest.HarvestOnlyDTO;
import com.youcode.citronix.Models.Entities.Harvest;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface HarvestMapper {

    Harvest toHarvest(HarvestCreationDTO harvestCreationDTO);

    HarvestDTO toHarvestDTO(Harvest harvest);

    HarvestCreationDTO toHarvestCreationDTO(Harvest harvest);

    HarvestOnlyDTO toHarvestOnlyDTO(Harvest harvest);
}
