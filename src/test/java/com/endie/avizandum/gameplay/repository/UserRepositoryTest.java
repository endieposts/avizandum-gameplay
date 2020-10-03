package com.endie.avizandum.gameplay.repository;

import com.endie.avizandum.gameplay.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_find_no_users_if_repository_is_empty() {
        Iterable<User> users = userRepository.findAll();

        assertThat(users).isEmpty();
    }

    @Test
    public void should_store_a_user() {
        User user = new User();
        user.setFirstName("Firstname");
        user.setLastName("Lastname");
        user.setKeycloakUserId("ABC123");
        userRepository.save(user);

        assertThat(user).hasFieldOrPropertyWithValue("keycloakUserId", "ABC123");
        assertThat(user).hasFieldOrPropertyWithValue("firstName", "Firstname");
        assertThat(user).hasFieldOrPropertyWithValue("lastName", "Lastname");
    }
}
