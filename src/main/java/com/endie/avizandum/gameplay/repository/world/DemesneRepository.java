package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.Demesne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  DemesneRepository {

    Demesne findOneById(@Param("id") Long id);
}
