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
    public void should_find_all_domains() {
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
    public void should_find_district_by_id() {

        Terrain terrain1 = new Terrain("D Test 1 name");
        entityManager.persist(terrain1);

        Terrain terrain2 = new Terrain("E Test 2 name");
        entityManager.persist(terrain2);

        Terrain foundDomain = terrainRepository.findById(terrain2.getTerrainId()).get();

        assertThat(foundDomain).isEqualTo(terrain2);

    }
}
