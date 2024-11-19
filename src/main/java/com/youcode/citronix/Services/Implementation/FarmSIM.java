package com.youcode.citronix.Services.Implementation;

import com.youcode.citronix.DTO.Farm.AllFarmsDTO;
import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmOnlyDTO;
import com.youcode.citronix.Mappers.FarmMapper;
import com.youcode.citronix.Models.Entities.Farm;
import com.youcode.citronix.Repositories.FarmRepository;
import com.youcode.citronix.Services.Interfaces.FarmSIN;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FarmSIM implements FarmSIN {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;

    @Override
    public FarmCreationDTO createFarm(FarmCreationDTO farmCreationDTO) {
        Farm farm = farmMapper.toFarm(farmCreationDTO);
        farm = farmRepository.save(farm);
        return farmMapper.toFarmCreationDTO(farm);
    }

    @Override
    public List<AllFarmsDTO> getFarms() {
        List<Farm> farms = farmRepository.findAll();
        return farms.stream().map(farmMapper::toAllFarmsDTO).toList();
    }

    @Override
    public FarmOnlyDTO globalGetFarm(UUID id, String name, String location, Double surface, LocalDate creationDate) {
       List<Farm> farms = farmRepository.globalSearchForFarms(id, name, location, surface, creationDate);
        if (farms.isEmpty()) {
            return null;
        }
        return farmMapper.toFarmOnlyDTO(farms.stream().findFirst().get());
    }

    @Override
    public Boolean deleteFarm(UUID id) {
        Farm farm = farmRepository.findById(id).orElse(null);
        if (farm != null) {
            farmRepository.delete(farm);
            return true;
        }
        return false;
    }

    @Override
    public FarmCreationDTO updateFarm(FarmCreationDTO farmCreationDTO) {
        Farm existingFarm = farmRepository.findById(farmCreationDTO.getId()).orElse(null);
        if (existingFarm == null) {
            return null;
        }
        existingFarm.setName(farmCreationDTO.getName());
        existingFarm.setLocation(farmCreationDTO.getLocation());
        existingFarm.setSurface(farmCreationDTO.getSurface());
        existingFarm.setCreationDate(farmCreationDTO.getCreationDate());
        existingFarm = farmRepository.save(existingFarm);
        return farmMapper.toFarmCreationDTO(existingFarm);
    }
}
