package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.Harvest.HarvestCreationDTO;
import com.youcode.citronix.DTO.Harvest.HarvestDTO;
import com.youcode.citronix.DTO.Harvest.HarvestOnlyDTO;

import java.util.List;
import java.util.UUID;

public interface HarvestSIN {

    HarvestCreationDTO createHarvest(HarvestCreationDTO harvestCreationDTO);
    List<HarvestOnlyDTO> getHarvests();
    HarvestDTO getHarvestById(UUID id);
    Boolean deleteHarvest(UUID id);
    HarvestCreationDTO updateHarvest(UUID id,  HarvestCreationDTO harvestCreationDTO);
}
