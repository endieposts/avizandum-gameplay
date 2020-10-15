package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.District;
import com.endie.avizandum.gameplay.model.world.Domain;
import com.endie.avizandum.gameplay.model.world.Terrain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class TerrainRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TerrainRepository terrainRepository;

    @Test
    public void should_find_no_terrains_if_repository_is_empty() {
        Iterable<Terrain> terrains = terrainRepository.findAll();

        assertThat(terrains).isEmpty();
    }

    @Test
    public void should_store_a_terrain() {
        Terrain terrain = terrainRepository.save(new Terrain("Test terrain name"));

        assertThat(terrain).hasFieldOrPropertyWithValue("name", "Test terrain name");
    }

    @Test
    public void should_find_all_terrains() {
        Terrain terrain1 = new Terrain("A Test 1 name");
        entityManager.persist(terrain1);

        Terrain terrain2 = new Terrain("B Test 2 name");
        entityManager.persist(terrain2);

        Terrain terrain3 = new Terrain("C Test 3 name");
        entityManager.persist(terrain3);

        Iterable<Terrain> domains = terrainRepository.findAll();

        assertThat(domains).hasSize(3).contains(terrain1, terrain2, terrain3);
    }

    @Test
    public void should_find_terrain_by_id() {

        Terrain terrain1 = new Terrain("D Test 1 name");
        entityManager.persist(terrain1);

        Terrain terrain2 = new Terrain("E Test 2 name");
        entityManager.persist(terrain2);

        Terrain foundDomain = terrainRepository.findById(terrain2.getTerrainId()).get();

        assertThat(foundDomain).isEqualTo(terrain2);

    }

    @Test
    public void should_update_terrain_by_id() {
        Terrain terrain1 = new Terrain("F Terrain 1 name");
        entityManager.persist(terrain1);

        Terrain terrain2 = new Terrain("G Terrain 2 name");
        entityManager.persist(terrain2);

        Terrain updatedTerrain = new Terrain("H updated Terrain 2 name");

        Terrain terrain = terrainRepository.findById(terrain2.getTerrainId()).get();
        terrain.setName(updatedTerrain.getName());
        terrainRepository.save(terrain);

        Terrain checkTut = terrainRepository.findById(terrain2.getTerrainId()).get();

        assertThat(checkTut.getTerrainId()).isEqualTo(terrain2.getTerrainId());
        assertThat(checkTut.getName()).isEqualTo(updatedTerrain.getName());

    }
}
