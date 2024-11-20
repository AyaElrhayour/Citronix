package com.youcode.citronix.Services.Implementation;

import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmOnlyDTO;
import com.youcode.citronix.Mappers.FarmMapper;
import com.youcode.citronix.Models.Entities.Farm;
import com.youcode.citronix.Repositories.FarmRepository;
import com.youcode.citronix.Services.Interfaces.FarmSIN;
import jakarta.persistence.EntityNotFoundException;
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
    public List<FarmOnlyDTO> getFarms() {
        List<Farm> farms = farmRepository.findAll();
        return farms.stream().map(farmMapper::toFarmOnlyDTO).toList();
    }

    @Override
    public FarmOnlyDTO getFarmById(UUID id) {
        if (farmRepository.existsById(id)) {
            return farmMapper.toFarmOnlyDTO(farmRepository.findById(id).get());
        }else {
            throw new EntityNotFoundException("Farm with id " + id + " not found");
        }
    }

    @Override
    public List<FarmOnlyDTO> globalGetFarm(String name, String location, Double surface, LocalDate creationDate) {
       List<Farm> farms = farmRepository.globalSearchForFarms(name, location, surface, creationDate);
        return farms.stream().map(farmMapper::toFarmOnlyDTO).toList();
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
    public FarmCreationDTO updateFarm(UUID id, FarmCreationDTO farmCreationDTO) {
        Farm farm = farmRepository.findById(id).orElseThrow(() -> new RuntimeException("Farm with id " + id + " not found"));

        farm.setName(farmCreationDTO.getName());
        farm.setLocation(farmCreationDTO.getLocation());
        farm.setSurface(farmCreationDTO.getSurface());
        farm.setCreationDate(farmCreationDTO.getCreationDate());
        return farmMapper.toFarmCreationDTO(farmRepository.save(farm));

    }
}
