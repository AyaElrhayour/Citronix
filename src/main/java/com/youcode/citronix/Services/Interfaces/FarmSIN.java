package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FarmSIN {


    FarmCreationDTO createFarm(FarmCreationDTO farmCreationDTO);
    List<FarmDTO> getFarms();
    FarmDTO getFarmById(UUID id);
    List<FarmDTO> globalGetFarm(String name, String location, Double surface, LocalDate creationDate);
    Boolean deleteFarm(UUID id);
    FarmCreationDTO updateFarm(UUID id, FarmCreationDTO farmCreationDTO);
}
