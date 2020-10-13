package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.District;
import com.endie.avizandum.gameplay.model.world.Domain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class DomainRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    DomainRepository domainRepository;

    @Test
    public void should_find_no_domains_if_repository_is_empty() {
        Iterable<Domain> domains = domainRepository.findAll();

        assertThat(domains).isEmpty();
    }

    @Test
    public void should_store_a_domain() {
        Domain domain = domainRepository.save(new Domain("Test name"));

        assertThat(domain).hasFieldOrPropertyWithValue("name", "Test name");
    }

    @Test
    public void should_find_all_domains() {
        Domain domain1 = new Domain("A Test 1 name");
        entityManager.persist(domain1);

        Domain domain2 = new Domain("B Test 2 name");
        entityManager.persist(domain2);

        Domain domain3 = new Domain("C Test 3 name");
        entityManager.persist(domain3);

        Iterable<Domain> domains = domainRepository.findAll();

        assertThat(domains).hasSize(3).contains(domain1, domain2, domain3);
    }

    @Test
    public void should_find_district_by_id() {

        Domain domain1 = new Domain("D Test 1 name");
        entityManager.persist(domain1);

        Domain domain2 = new Domain("E Test 2 name");
        entityManager.persist(domain2);

        Domain foundDomain = domainRepository.findById(domain2.getDomainId()).get();

        assertThat(foundDomain).isEqualTo(domain2);

    }
}
