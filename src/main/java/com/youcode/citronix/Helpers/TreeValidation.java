package com.youcode.citronix.Helpers;

import com.youcode.citronix.Models.Entities.Field;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class TreeValidation {

    private TreeValidation() {}

    public static void validateTree(Field field, LocalDate plantingDate) {
        int treeAge = calculateTreeAge(plantingDate);
        validateTreeDensity(field);
        validateTreeAge(treeAge);
        validatePlantingPeriod(plantingDate);
    }

    private static void validateTreeDensity(Field field) {

        double fieldSurfaceInSquareMeters = field.getSurface() * 10_000;
        int maxTrees = (int) (fieldSurfaceInSquareMeters / 10);

        if (field.getTrees().size() > maxTrees) {
            throw new IllegalArgumentException("The field cannot have more than " + maxTrees + " trees based on its size.");
        }
    }

    private static void validateTreeAge(int treeAge) {
        int maxTreeLifespan = 20;
        if (treeAge > maxTreeLifespan) {
            throw new IllegalArgumentException("A tree cannot be productive beyond " + maxTreeLifespan + " years of age.");
        }
    }

    private static void validatePlantingPeriod(LocalDate plantingDate) {
        if (plantingDate == null) {
            throw new IllegalArgumentException("The planting date cannot be null.");
        }

        Month plantingMonth = plantingDate.getMonth();
        if (plantingMonth.compareTo(Month.MARCH) < 0 || plantingMonth.compareTo(Month.MAY) > 0) {
            throw new IllegalArgumentException("Trees can only be planted between March and May.");
        }
    }

    public static int calculateTreeAge(LocalDate plantingDate) {
        if (plantingDate == null) {
            throw new IllegalArgumentException("Planting date cannot be null.");
        }

        LocalDate currentDate = LocalDate.now();
        if (plantingDate.isAfter(currentDate)) {
            throw new IllegalArgumentException("Planting date cannot be in the future.");
        }

        return Period.between(plantingDate, currentDate).getYears();
    }
}
