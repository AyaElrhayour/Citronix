package com.youcode.citronix.Repositories;

import com.youcode.citronix.Models.Entities.Farm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
@AllArgsConstructor
public class FarmRepositoryCustomImpl implements FarmRepositoryCustom {

    private EntityManager em;


    @Override
    public List<Farm> globalSearchForFarms(String name, String location, Double surface, LocalDate creationDate) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Farm> criteria = cb.createQuery(Farm.class);
        Root<Farm> farm = criteria.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();

        criteria.multiselect(
                farm.get("name"),
                farm.get("location"),
                farm.get("surface"),
                farm.get("creationDate")
        );


        if (name != null && !name.isEmpty()) {
            predicates.add(cb.equal(farm.get("name"), "%" + name + "%"));
        }

        if (location != null && !location.isEmpty()) {
            predicates.add(cb.equal(farm.get("location"), location));
        }

        if (surface != null) {
            predicates.add(cb.equal(farm.get("surface"), surface));
        }

        if (creationDate != null) {
            predicates.add(cb.equal(farm.get("creationDate"), creationDate));
        }

        criteria.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Farm> query = em.createQuery(criteria);
        return query.getResultList();

    }
}
