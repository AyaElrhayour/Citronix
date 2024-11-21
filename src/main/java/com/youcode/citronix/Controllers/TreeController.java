package com.youcode.citronix.Controllers;

import com.youcode.citronix.DTO.Tree.TreeCreationDTO;
import com.youcode.citronix.DTO.Tree.TreeDTO;
import com.youcode.citronix.DTO.Tree.TreeOnlyDTO;
import com.youcode.citronix.Services.Interfaces.TreeSIN;
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
@RequestMapping(path = "api/tree", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreeController {

    private final TreeSIN treeSIN;

    @PostMapping
    public ResponseEntity<TreeCreationDTO> createTree(@Valid @RequestBody TreeCreationDTO treeCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treeSIN.createTree(treeCreationDTO));
    }

    @GetMapping
    public ResponseEntity<List<TreeOnlyDTO>> getAllTrees() {
        return ResponseEntity.ok(treeSIN.getTrees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDTO> getTreeById(@PathVariable UUID id) {
        return ResponseEntity.ok(treeSIN.getTreeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTree(@PathVariable UUID id) {
        if (treeSIN.deleteTree(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tree could not be deleted");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreeCreationDTO> updateTree(
            @PathVariable UUID id, @Valid @RequestBody TreeCreationDTO treeCreationDTO) {
        return ResponseEntity.ok(treeSIN.updateTree(id, treeCreationDTO));
    }
}
