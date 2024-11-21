package com.youcode.citronix.Repositories;

import com.youcode.citronix.Models.Embded.HarvestDetailsEmbdedId;
import com.youcode.citronix.Models.Entities.HarvestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HarvestDetailsRepository extends JpaRepository<HarvestDetails, HarvestDetailsEmbdedId> {
}
