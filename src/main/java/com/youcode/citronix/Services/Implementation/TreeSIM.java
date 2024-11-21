package com.youcode.citronix.Services.Implementation;

import com.youcode.citronix.DTO.Tree.TreeCreationDTO;
import com.youcode.citronix.DTO.Tree.TreeDTO;
import com.youcode.citronix.DTO.Tree.TreeOnlyDTO;
import com.youcode.citronix.Helpers.TreeValidation;
import com.youcode.citronix.Mappers.TreeMapper;
import com.youcode.citronix.Models.Entities.Field;
import com.youcode.citronix.Models.Entities.Tree;
import com.youcode.citronix.Repositories.FieldRepository;
import com.youcode.citronix.Repositories.TreeRepository;
import com.youcode.citronix.Services.Interfaces.TreeSIN;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.youcode.citronix.Helpers.TreeValidation.calculateTreeAge;

@Service
@AllArgsConstructor
public class TreeSIM implements TreeSIN {

    private final TreeRepository treeRepository;
    private final FieldRepository fieldRepository;
    private final TreeMapper treeMapper;


    @Override
    public TreeCreationDTO createTree(TreeCreationDTO treeCreationDTO) {
        Field field = fieldRepository.findById(treeCreationDTO.getFieldId())
                .orElseThrow(() -> new EntityNotFoundException("Field with id " + treeCreationDTO.getFieldId() + " not found"));

        Tree tree = treeMapper.toTree(treeCreationDTO);

        TreeValidation.validateTree(field, tree.getPlantingDate());

        int treeAge = TreeValidation.calculateTreeAge(tree.getPlantingDate());
        String treeType = TreeValidation.calculateTreeType(treeAge);
        String seasonalProductivity = TreeValidation.calculateSeasonalProductivity(treeType);

        tree.setField(field);

        Tree savedTree = treeRepository.save(tree);

        TreeCreationDTO responseDTO = treeMapper.toTreeCreationDTO(savedTree);
        responseDTO.setAge(treeAge + " Years");
        responseDTO.setTreeType(treeType);
        responseDTO.setSeasonalProductivity(seasonalProductivity);

        return responseDTO;
    }


    @Override
    public List<TreeOnlyDTO> getTrees() {
        List<Tree> trees = treeRepository.findAll();
        return trees.stream().map(treeMapper::toTreeOnlyDTO).toList();
    }

    @Override
    public TreeDTO getTreeById(UUID id) {
        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree with id " + id + " not found"));
        return treeMapper.toTreeDTO(tree);
    }

    @Override
    public Boolean deleteTree(UUID id) {
        Tree tree = treeRepository.findById(id).orElse(null);
        if (tree != null) {
            treeRepository.delete(tree);
            return true;
        }
        return false;
    }

    @Override
    public TreeCreationDTO updateTree(UUID id, TreeCreationDTO treeCreationDTO) {
        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree with id " + id + " not found"));

        Field field = fieldRepository.findById(treeCreationDTO.getFieldId())
                .orElseThrow(() -> new EntityNotFoundException("Field with id " + treeCreationDTO.getFieldId() + " not found"));


        tree.setPlantingDate(treeCreationDTO.getPlantingDate());
        tree.setField(field);
        tree.setHarvested(treeCreationDTO.isHarvested());

        TreeValidation.validateTree(field, tree.getPlantingDate());

        return treeMapper.toTreeCreationDTO(treeRepository.save(tree));
    }
}
