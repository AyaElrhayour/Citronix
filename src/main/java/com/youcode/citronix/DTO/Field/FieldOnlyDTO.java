package com.youcode.citronix.DTO.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldOnlyDTO {

    private UUID id;

    @NonNull
    private Double surface;
}
