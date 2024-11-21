package com.youcode.citronix.Services.Implementation;

import com.youcode.citronix.DTO.Harvest.HarvestCreationDTO;
import com.youcode.citronix.DTO.Harvest.HarvestDTO;
import com.youcode.citronix.DTO.Harvest.HarvestOnlyDTO;
import com.youcode.citronix.Mappers.HarvestMapper;
import com.youcode.citronix.Models.Entities.Harvest;
import com.youcode.citronix.Repositories.HarvestRepository;
import com.youcode.citronix.Services.Interfaces.HarvestSIN;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class HarvestSIM implements HarvestSIN {

    private final HarvestRepository harvestRepository;
    private final HarvestMapper harvestMapper;

    @Override
    public HarvestCreationDTO createHarvest(HarvestCreationDTO harvestCreationDTO) {
        Harvest harvest = harvestMapper.toHarvest(harvestCreationDTO);
        harvest = harvestRepository.save(harvest);
        return harvestMapper.toHarvestCreationDTO(harvest);
    }

    @Override
    public List<HarvestOnlyDTO> getHarvests() {
        List<Harvest> harvests = harvestRepository.findAll();
        return harvests.stream().map(harvestMapper::toHarvestOnlyDTO).toList();
    }

    @Override
    public HarvestDTO getHarvestById(UUID id) {
        if (harvestRepository.existsById(id)) {
            return harvestMapper.toHarvestDTO(harvestRepository.findById(id).get());
        }else {
            throw new EntityNotFoundException("Harvest with id " + id + " not found");
        }
    }

    @Override
    public Boolean deleteHarvest(UUID id) {
        Harvest harvest = harvestRepository.findById(id).orElse(null);
        if (harvest != null) {
            harvestRepository.delete(harvest);
            return true;
        }
        return false;
    }

    @Override
    public HarvestCreationDTO updateHarvest(UUID id, HarvestCreationDTO harvestCreationDTO) {
        Harvest harvest = harvestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Harvest with id " + id + " not found"));

        harvest.setQuantity(harvestCreationDTO.getQuantity());
        harvest.setSeason(harvestCreationDTO.getSeason());
        harvest.setFullySold(harvestCreationDTO.isFullySold());
        return harvestMapper.toHarvestCreationDTO(harvestRepository.save(harvest));
    }
}
