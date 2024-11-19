package com.youcode.citronix.Repositories;

import com.youcode.citronix.Models.Entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface FarmRepository extends JpaRepository<Farm, UUID>, FarmRepositoryCustom {
}
