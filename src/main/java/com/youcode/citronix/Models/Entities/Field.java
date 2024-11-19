package com.youcode.citronix.Models.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fields")
public class Field {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false , name = "surface")
    private Double surface;

    @ManyToOne(fetch = FetchType.EAGER)
    private Farm farm;

    @OneToMany(mappedBy = "field" , fetch = FetchType.EAGER)
    private List<Tree> Trees;
}
