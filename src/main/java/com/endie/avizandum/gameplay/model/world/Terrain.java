package com.endie.avizandum.gameplay.model.world;

import javax.persistence.*;

@Entity
@Table(name="terrain")
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long terrainId;

    private String name;

    public Long getTerrainId() {
        return terrainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
