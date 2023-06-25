package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.AnoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnoLetivoRepository extends JpaRepository<AnoLetivo, Long> {

    @Query("SELECT a FROM AnoLetivo a WHERE a.ano = ?1")
    Optional<AnoLetivo> findAnoLetivoByAnoLetivo(String anoLetivo);

}
