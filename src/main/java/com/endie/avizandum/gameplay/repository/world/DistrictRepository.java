package com.endie.avizandum.gameplay.repository.world;

import com.endie.avizandum.gameplay.model.world.Demesne;
import com.endie.avizandum.gameplay.model.world.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository  extends JpaRepository<District, Long> {

    Demesne findOneById(@Param("id") Long id);
}
