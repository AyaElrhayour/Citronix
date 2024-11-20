package com.youcode.citronix.Services.Interfaces;

import com.youcode.citronix.DTO.Tree.TreeCreationDTO;
import com.youcode.citronix.DTO.Tree.TreeDTO;
import com.youcode.citronix.DTO.Tree.TreeOnlyDTO;

import java.util.List;
import java.util.UUID;

public interface TreeSIN {

    TreeCreationDTO createTree(TreeCreationDTO treeCreationDTO);
    List<TreeOnlyDTO> getTrees();
    TreeDTO getTreeById(UUID id);
    Boolean deleteTree(UUID id);
    TreeCreationDTO updateTree(UUID id, TreeCreationDTO treeCreationDTO);

}
