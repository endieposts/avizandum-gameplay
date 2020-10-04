package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.Domain;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository {

    Domain findOneByTerrainId(@Param("terrainId") Long terrainId);
}
