package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

    Domain findOneByDomainId(@Param("domainId") Long domainId);
}
