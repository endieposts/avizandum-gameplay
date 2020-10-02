package com.endie.avizandum.gameplay.model.world;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long predominantTerrain;
    private Integer northing;
    private Integer easting;
}
