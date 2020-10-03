package com.endie.avizandum.gameplay.repository;

import com.endie.avizandum.gameplay.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_find_no_tutorials_if_repository_is_empty() {
        Iterable<User> tutorials = userRepository.findAll();

        assertThat(tutorials).isEmpty();
    }
}
