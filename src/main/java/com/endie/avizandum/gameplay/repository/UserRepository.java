package com.endie.avizandum.gameplay.repository;

import com.endie.avizandum.gameplay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLastName(String lastName);

    User findOneById(@Param("id") Long id);
    User findOnebyKeycloakUserId(@Param("keycloakUserId") String keycloakUserId);

}