package com.youcode.citronix.Controllers;


import com.youcode.citronix.DTO.Farm.FarmCreationDTO;
import com.youcode.citronix.DTO.Farm.FarmDTO;
import com.youcode.citronix.Services.Interfaces.FarmSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping(path = "api/farm", produces = MediaType.APPLICATION_JSON_VALUE)
public class FarmController {

    private final FarmSIN farmSIN;

    @PostMapping
    public ResponseEntity<FarmCreationDTO> createFarm(@Valid @RequestBody FarmCreationDTO farmCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(farmSIN.createFarm(farmCreationDTO));
    }

    @GetMapping
    public ResponseEntity<List<FarmDTO>> getAllFarms() {
        return ResponseEntity.ok(farmSIN.getFarms());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<FarmDTO> getFarmById(@PathVariable UUID id) {
        return ResponseEntity.ok(farmSIN.getFarmById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<FarmDTO>> globalSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double surface,
            @RequestParam(required = false) LocalDate creationDate) {
        List<FarmDTO> farm = farmSIN.globalGetFarm( name, location, surface, creationDate);
        if (farm == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(farm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFarm(@PathVariable UUID id) {
        if (farmSIN.deleteFarm(id)) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farm isn't deleted ");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmCreationDTO> updateFarm(@PathVariable UUID id, @Valid @RequestBody FarmCreationDTO farmCreationDTO) {
        return ResponseEntity.ok(farmSIN.updateFarm(id, farmCreationDTO));
    }
}
