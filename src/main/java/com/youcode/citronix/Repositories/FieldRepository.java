package com.youcode.citronix.Repositories;

import com.youcode.citronix.Models.Entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FieldRepository extends JpaRepository<Field, UUID> {
}
