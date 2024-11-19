package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.Farm.AllFarmsDTO;
import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmOnlyDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FarmSIN {


    FarmCreationDTO createFarm(FarmCreationDTO farmCreationDTO);
    List<AllFarmsDTO> getFarms();
    FarmOnlyDTO globalGetFarm(UUID id, String name, String location, Double surface, LocalDate creationDate);
    Boolean deleteFarm(UUID id);
    FarmCreationDTO updateFarm(FarmCreationDTO farmCreationDTO);
}
