package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmOnlyDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FarmSIN {


    FarmCreationDTO createFarm(FarmCreationDTO farmCreationDTO);
    List<FarmOnlyDTO> getFarms();
    FarmOnlyDTO getFarmById(UUID id);
    List<FarmOnlyDTO> globalGetFarm(String name, String location, Double surface, LocalDate creationDate);
    Boolean deleteFarm(UUID id);
    FarmCreationDTO updateFarm(UUID id, FarmCreationDTO farmCreationDTO);
}
