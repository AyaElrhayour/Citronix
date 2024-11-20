package com.youcode.citronix.DTO.Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeOnlyDTO {

    private UUID id;

    private int age;

}
