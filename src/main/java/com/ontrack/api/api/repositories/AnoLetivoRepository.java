package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.AnoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnoLetivoRepository extends JpaRepository<AnoLetivo, Long> {
}
