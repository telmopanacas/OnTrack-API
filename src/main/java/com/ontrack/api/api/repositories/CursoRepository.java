package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c WHERE c.codigo = ?1")
    Optional<Curso> findCursoByCodigo(String codigo);
}
