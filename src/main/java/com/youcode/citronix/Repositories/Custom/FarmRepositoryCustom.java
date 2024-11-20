package com.youcode.citronix.Repositories.Custom;

import com.youcode.citronix.Models.Entities.Farm;

import java.time.LocalDate;
import java.util.List;

public interface FarmRepositoryCustom {

    List<Farm> globalSearchForFarms(String name, String location, Double surface, LocalDate creationDate);
}
