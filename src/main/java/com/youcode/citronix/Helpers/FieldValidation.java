package com.youcode.citronix.Helpers;


import com.youcode.citronix.Models.Entities.Farm;
import com.youcode.citronix.Models.Entities.Field;
import lombok.NoArgsConstructor;


public class FieldValidation {

    private FieldValidation() {}

    public static void validateFieldConstraints(Farm farm, Double fieldSurface) {

        if (farm.getFields().size() >= 10) {
            throw new IllegalArgumentException("Farm cannot have more than 10 fields");
        }

        double maxFieldSurface = farm.getSurface() * 0.5;
        if (fieldSurface > maxFieldSurface) {
            throw new IllegalArgumentException("Field surface cannot exceed 50% of the farm's total surface");
        }


        double farmSurface = farm.getFields().stream().mapToDouble(Field::getSurface).sum();
        if (farm.getSurface() < farmSurface + fieldSurface) {
            throw new RuntimeException("you have exceed the limit , there is only " + (farm.getSurface() - farmSurface) + " available");
        }
    }

}
