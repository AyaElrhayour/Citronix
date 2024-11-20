package com.youcode.citronix.Controllers;

import com.youcode.citronix.DTO.Field.FieldCreationDTO;
import com.youcode.citronix.DTO.Field.FieldDTO;
import com.youcode.citronix.DTO.Field.FieldOnlyDTO;
import com.youcode.citronix.Services.Interfaces.FieldSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/field", produces = MediaType.APPLICATION_JSON_VALUE)
public class FieldController {

    private final FieldSIN fieldSIN;

    @PostMapping
    public ResponseEntity<FieldCreationDTO> createField(@Valid @RequestBody FieldCreationDTO fieldCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fieldSIN.createField(fieldCreationDTO));
    }


    @GetMapping
    public ResponseEntity<List<FieldOnlyDTO>> getAllFields() {
        return ResponseEntity.ok(fieldSIN.getFields());
    }


    @GetMapping("/{id}")
    public ResponseEntity<FieldDTO> getFieldById(@PathVariable UUID id) {
        return ResponseEntity.ok(fieldSIN.getField(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteField(@PathVariable UUID id) {
        if (fieldSIN.deleteField(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Field could not be deleted");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<FieldCreationDTO> updateField(
            @PathVariable UUID id, @Valid @RequestBody FieldCreationDTO fieldCreationDTO) {
        return ResponseEntity.ok(fieldSIN.updateField(id, fieldCreationDTO));
    }
}
