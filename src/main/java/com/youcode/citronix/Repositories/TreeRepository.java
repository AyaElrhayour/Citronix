package com.youcode.citronix.Repositories;


import com.youcode.citronix.Models.Entities.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TreeRepository extends JpaRepository<Tree, UUID> {
}
