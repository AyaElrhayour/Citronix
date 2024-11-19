package com.youcode.citronix.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "farms")
public class Farm {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false , name = "name")
    private String name;

    @Column(name = "localisation" , nullable = false)
    private String localisation;

    @Column(nullable = false , name = "surface")
    private Double surface;

    @Column(name = "creationDate" , nullable = false)
    private LocalDate creationDate;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "farm")
    private List<Field> fields;
}
