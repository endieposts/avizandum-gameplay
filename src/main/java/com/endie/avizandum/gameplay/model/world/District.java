package com.endie.avizandum.gameplay.model.world;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long districtId;

    private Long terrainId;
    private String name;

    public District() {

    }

    public District( String name, Long terrainId) {
        this.terrainId = terrainId;
        this.name = name;
    }

    public Long getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(Long terrainId) {
        this.terrainId = terrainId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


}
