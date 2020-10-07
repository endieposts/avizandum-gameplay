package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.User;
import com.endie.avizandum.gameplay.model.world.District;
import com.endie.avizandum.gameplay.repository.world.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class DistrictRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    DistrictRepository districtRepository;

    @Test
    public void should_find_no_districts_if_repository_is_empty() {
        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).isEmpty();
    }

    @Test
    public void should_store_a_district() {
        District district = districtRepository.save(new District("Test name", 1L));

        assertThat(district).hasFieldOrPropertyWithValue("name", "Test name");
        assertThat(district).hasFieldOrPropertyWithValue("terrainId", 1L);
    }
}
