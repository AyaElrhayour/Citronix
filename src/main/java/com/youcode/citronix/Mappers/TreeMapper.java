package com.youcode.citronix.Mappers;

import com.youcode.citronix.DTO.Tree.TreeCreationDTO;
import com.youcode.citronix.DTO.Tree.TreeDTO;
import com.youcode.citronix.DTO.Tree.TreeOnlyDTO;
import com.youcode.citronix.Models.Entities.Tree;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface TreeMapper {

    Tree toTree(TreeCreationDTO treeCreationDTO);

    TreeCreationDTO toTreeCreationDTO(Tree tree);

    TreeDTO toTreeDTO(Tree tree);

    TreeOnlyDTO toTreeOnlyDTO(Tree tree);
}
