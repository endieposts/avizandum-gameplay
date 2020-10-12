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

    @Test
    public void should_find_all_districts() {
        District district1 = new District("A Test 1 name", 1L);
        entityManager.persist(district1);

        District district2 = new District("B Test 2 name", 2L);
        entityManager.persist(district2);

        District district3 = new District("C Test 3 name", 3L);
        entityManager.persist(district3);

        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).hasSize(3).contains(district1, district2, district3);
    }
}
