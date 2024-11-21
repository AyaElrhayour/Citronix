package com.youcode.citronix.Controllers;


import com.youcode.citronix.DTO.Harvest.HarvestCreationDTO;
import com.youcode.citronix.DTO.Harvest.HarvestDTO;
import com.youcode.citronix.DTO.Harvest.HarvestOnlyDTO;
import com.youcode.citronix.Models.Entities.Harvest;
import com.youcode.citronix.Services.Interfaces.HarvestSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping(path = "api/harvest" , produces = MediaType.APPLICATION_JSON_VALUE)
public class HarvestController {

    private final HarvestSIN harvestSIN;

    @PostMapping
    public ResponseEntity<HarvestCreationDTO> createHarvest(@Valid @RequestBody HarvestCreationDTO harvestCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(harvestSIN.createHarvest(harvestCreationDTO));
    }

    @GetMapping
    public ResponseEntity<List<HarvestOnlyDTO>> getAllHarvests() {
        return ResponseEntity.ok(harvestSIN.getHarvests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestDTO> getHarvestById(@PathVariable UUID id) {
        return ResponseEntity.ok(harvestSIN.getHarvestById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHarvestById(@PathVariable UUID id) {
        if (harvestSIN.deleteHarvest(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Harvest isn't deleted ");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestCreationDTO> updateHarvestById(@PathVariable UUID id,@Valid @RequestBody HarvestCreationDTO harvestCreationDTO) {
        return ResponseEntity.ok(harvestSIN.updateHarvest(id, harvestCreationDTO));
    }
}
