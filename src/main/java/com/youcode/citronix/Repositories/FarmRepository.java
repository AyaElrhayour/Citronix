package com.youcode.citronix.Repositories;

import com.youcode.citronix.Models.Entities.Farm;
import com.youcode.citronix.Repositories.Custom.FarmRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FarmRepository extends JpaRepository<Farm, UUID>, FarmRepositoryCustom {

}
