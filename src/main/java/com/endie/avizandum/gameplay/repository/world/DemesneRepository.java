package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.Demesne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  DemesneRepository  extends JpaRepository<Demesne, Long> {

    Demesne findOneById(@Param("id") Long id);
}
