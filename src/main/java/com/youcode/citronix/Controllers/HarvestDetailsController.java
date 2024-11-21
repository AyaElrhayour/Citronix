package com.youcode.citronix.Controllers;


import com.youcode.citronix.DTO.HarvestDetails.HarvestDetailCreationDTO;
import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;
import com.youcode.citronix.Repositories.HarvestDetailsRepository;
import com.youcode.citronix.Services.Interfaces.HarvestDetailsSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping(path = "api/harvestDetails", produces = MediaType.APPLICATION_JSON_VALUE)
public class HarvestDetailsController {

    private final HarvestDetailsSIN harvestDetailsSIN;

    @PostMapping
    public ResponseEntity<HarvestDetailCreationDTO> createHarvestDetails(@Valid @RequestBody HarvestDetailCreationDTO harvestDetailCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(harvestDetailsSIN.createHarvest(harvestDetailCreationDTO));
    }

    @GetMapping
    public ResponseEntity<List<HarvestDetailCreationDTO>> getHarvestDetails() {
        return ResponseEntity.ok(harvestDetailsSIN.getHarvests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestDetailCreationDTO> getHarvestDetails(@PathVariable UUID id) {
        return ResponseEntity.ok(harvestDetailsSIN.getHarvestById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHarvestDetails(@PathVariable UUID id) {
        if (harvestDetailsSIN.deleteHarvest(id)) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Harvest Details could not be deleted");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestDetailCreationDTO> updateHarvestDetails(@PathVariable HarvestDetailsEmbdedId id, @Valid @RequestBody HarvestDetailCreationDTO harvestDetailCreationDTO) {
        return ResponseEntity.ok(harvestDetailsSIN.updateHarvest(id, harvestDetailCreationDTO));
    }
}
