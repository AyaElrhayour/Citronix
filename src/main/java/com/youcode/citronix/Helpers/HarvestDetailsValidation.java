package com.youcode.citronix.Helpers;


import com.youcode.citronix.Models.Entities.Tree;
import com.youcode.citronix.Models.Enums.Season;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

public class HarvestDetailsValidation {

    private HarvestDetailsValidation() {}

    public static void validateTreeAge(Tree tree) {
        int treeAge = Period.between(tree.getPlantingDate(), LocalDate.now()).getYears();
        if (treeAge > 20) {
            throw new IllegalArgumentException("A tree cannot be productive beyond 20 years.");
        }
    }

    public static void validateSingleCropPerSeason(Set<Tree> trees, Season season) {
        for (Tree tree : trees) {
            boolean alreadyHarvested = tree.getHarvestDetails()
                    .stream()
                    .anyMatch(hd -> hd.getHarvest().getSeason() == season);
            if (alreadyHarvested) {
                throw new IllegalArgumentException("A tree cannot be harvested more than once in the same season.");
            }
        }
    }

    public static void validateHarvestDateMatchesSeason(LocalDate harvestDate, Season season) {
        switch (season) {
            case WINTER:
                if (!(harvestDate.getMonthValue() == 12 || harvestDate.getMonthValue() <= 2)) {
                    throw new IllegalArgumentException("Harvest date must be in December, January, or February for Winter.");
                }
                break;
            case SPRING:
                if (harvestDate.getMonthValue() < 3 || harvestDate.getMonthValue() > 5) {
                    throw new IllegalArgumentException("Harvest date must be in March, April, or May for Spring.");
                }
                break;
            case SUMMER:
                if (harvestDate.getMonthValue() < 6 || harvestDate.getMonthValue() > 8) {
                    throw new IllegalArgumentException("Harvest date must be in June, July, or August for Summer.");
                }
                break;
            case FALL:
                if (harvestDate.getMonthValue() < 9 || harvestDate.getMonthValue() > 11) {
                    throw new IllegalArgumentException("Harvest date must be in September, October, or November for Fall.");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid season provided.");
        }
    }

    public static void resetTreeHarvestStatus(Tree tree) {
        tree.setHarvested(false);
    }
}
