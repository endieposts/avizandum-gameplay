package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.District;
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
}
