package com.youcode.citronix.Helpers;

import com.youcode.citronix.Models.Entities.Field;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class TreeValidation {

    private TreeValidation() {}

    public static void validateTree(Field field, LocalDate plantingDate) {
        calculateTreeAge(plantingDate);
        validateTreeDensity(field);
        validatePlantingPeriod(plantingDate);
    }

    public static int calculateTreeAge(LocalDate plantingDate) {
        if (plantingDate == null) {
            throw new IllegalArgumentException("Planting date cannot be null.");
        }

        LocalDate currentDate = LocalDate.now();
        if (plantingDate.isAfter(currentDate)) {
            throw new IllegalArgumentException("Planting date cannot be in the future.");
        }

        Period agePeriod = Period.between(plantingDate, currentDate);
        return agePeriod.getYears();
    }

    public static String calculateTreeType(int treeAge) {
        if (treeAge < 3) {
            return "Young";
        } else if (treeAge <= 10) {
            return "Mature";
        } else {
            return "Old";
        }
    }

    public static String calculateSeasonalProductivity(String treeType) {
        switch (treeType) {
            case "Young":
                return "2.5 kg / season";
            case "Mature":
                return "12 kg / season";
            case "Old":
                return "20 kg / season";
            default:
                throw new IllegalArgumentException("Invalid tree type.");
        }
    }

    private static void validateTreeDensity(Field field) {
        double fieldSurfaceInSquareMeters = field.getSurface() * 10_000;
        int maxTrees = (int) (fieldSurfaceInSquareMeters / 10);

        if (field.getTrees().size() > maxTrees) {
            throw new IllegalArgumentException("The field cannot have more than " + maxTrees + " trees based on its size.");
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
}
