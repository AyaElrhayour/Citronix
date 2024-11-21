package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.HarvestDetails.HarvestDetailCreationDTO;
import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;

import java.util.List;
import java.util.UUID;

public interface HarvestDetailsSIN {

    HarvestDetailCreationDTO createHarvest(HarvestDetailCreationDTO harvestDetailCreationDTO);
    List<HarvestDetailCreationDTO> getHarvests();
    HarvestDetailCreationDTO getHarvestById(UUID id);
    Boolean deleteHarvest(UUID id);
    HarvestDetailCreationDTO updateHarvest(HarvestDetailsEmbdedId id, HarvestDetailCreationDTO harvestDetailCreationDTO);
}
