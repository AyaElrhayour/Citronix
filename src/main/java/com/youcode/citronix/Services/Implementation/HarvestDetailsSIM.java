package com.youcode.citronix.Services.Implementation;

import com.youcode.citronix.DTO.HarvestDetails.HarvestDetailCreationDTO;
import com.youcode.citronix.Helpers.HarvestDetailsValidation;
import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;
import com.youcode.citronix.Models.Entities.Harvest;
import com.youcode.citronix.Models.Entities.HarvestDetails;
import com.youcode.citronix.Models.Entities.Tree;
import com.youcode.citronix.Repositories.HarvestDetailsRepository;
import com.youcode.citronix.Repositories.HarvestRepository;
import com.youcode.citronix.Repositories.TreeRepository;
import com.youcode.citronix.Services.Interfaces.HarvestDetailsSIN;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HarvestDetailsSIM implements HarvestDetailsSIN {

    private final HarvestDetailsRepository harvestDetailsRepository;
    private final TreeRepository treeRepository;
    private final HarvestRepository harvestRepository;


    @Override
    public HarvestDetailCreationDTO createHarvest(HarvestDetailCreationDTO harvestDetailCreationDTO) {
        HarvestDetails harvestDetails = new HarvestDetails();

        // Fetch related Tree and Harvest entities
        Tree tree = treeRepository.findById(harvestDetailCreationDTO.getTreeId())
                .orElseThrow(() -> new EntityNotFoundException("Tree not found"));
        Harvest harvest = harvestRepository.findById(harvestDetailCreationDTO.getHarvestId())
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found"));

        HarvestDetailsValidation.validateTreeAge(tree);
        HarvestDetailsValidation.validateSingleCropPerSeason(Set.of(tree), harvest.getSeason());
        HarvestDetailsValidation.validateHarvestDateMatchesSeason(harvestDetailCreationDTO.getHarvestDate(), harvest.getSeason());

        tree.setHarvested(true);

        HarvestDetailsEmbdedId id = new HarvestDetailsEmbdedId();
        id.setHarvestId(harvestDetailCreationDTO.getHarvestId());
        id.setTreeId(tree.getId());

        harvestDetails.setId(id);


        harvestDetails.setQuantity(harvestDetailCreationDTO.getQuantity());
        harvestDetails.setHarvestDate(harvestDetailCreationDTO.getHarvestDate());
        harvestDetails.setTree(tree);
        harvestDetails.setHarvest(harvest);

        harvestDetailsRepository.save(harvestDetails);

        HarvestDetailsValidation.resetTreeHarvestStatus(tree);

        return harvestDetailCreationDTO;
    }

    @Override
    public List<HarvestDetailCreationDTO> getHarvests() {
        return harvestDetailsRepository.findAll()
                .stream()
                .map(harvestDetails -> new HarvestDetailCreationDTO(
                        harvestDetails.getId(),
                        harvestDetails.getQuantity(),
                        harvestDetails.getHarvestDate()
                )).toList();
    }

    @Override
    public HarvestDetailCreationDTO getHarvestById(UUID id) {
        return null;
    }

    @Override
    public Boolean deleteHarvest(UUID id) {
        return null;
    }

    @Override
    public HarvestDetailCreationDTO updateHarvest(HarvestDetailsEmbdedId id, HarvestDetailCreationDTO harvestDetailCreationDTO) {
        return null;
    }
}
