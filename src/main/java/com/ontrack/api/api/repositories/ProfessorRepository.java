package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findProfessorByEmail(String email);
}
