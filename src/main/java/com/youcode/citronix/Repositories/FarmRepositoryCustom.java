package com.youcode.citronix.Repositories;

import com.youcode.citronix.Models.Entities.Farm;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FarmRepositoryCustom {

    List<Farm> globalSearchForFarms(UUID id, String name, String location, Double surface, LocalDate creationDate);
}
